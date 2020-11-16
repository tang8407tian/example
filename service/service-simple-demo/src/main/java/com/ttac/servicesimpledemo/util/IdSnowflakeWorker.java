package com.ttac.servicesimpledemo.util;

import lombok.extern.slf4j.Slf4j;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 描述: 雪花算法id生成器
 *
 * @author bang.tang
 * @create 2020-09-22 16:45
 */
@Slf4j
public class IdSnowflakeWorker {


    /**
     * EPOCH为id起始时间 可配置，但正式使用了之后不可再更改
     * 开始时间截 (2020-09-22 16:27:03)
     * 1600763223883L
     */
    private static long EPOCH = 1600763223883L;

    /**
     * 每台workerId服务器有3个备份workerId, 备份workerId数量越多, 可靠性越高, 但是可部署的sequence ID服务越少
     */
    private static final long BACKUP_COUNT = 3;

    /**
     * worker id 的bit数，最多支持8192个节点
     */
    private static final long workerIdBits = 5L;
    /**
     * 数据中心标识位数
     */
    private static final long dataCenterIdBits = 5L;
    /**
     * 序列号，支持单节点最高每毫秒的最大ID数4096
     * 毫秒内自增位
     */
    private static final long sequenceBits = 12L;

    /**
     * 机器ID偏左移12位
     */
    private static final long workerIdShift = sequenceBits;

    /**
     * 数据中心ID左移17位(12+5)
     */
    private static final long dataCenterIdShift = sequenceBits + workerIdBits;

    /**
     * 时间毫秒左移22位(5+5+12)
     */
    private static final long timestampLeftShift = sequenceBits + workerIdBits + dataCenterIdBits;
    /**
     * sequence掩码，确保sequnce不会超出上限
     * 最大的序列号，4096
     * -1 的补码（二进制全1）右移12位, 然后取反
     * 生成序列的掩码，这里为4095 (0b111111111111=0xfff=4095)
     * //private final static long sequenceMask = ~(-1L << sequenceBits);
     */
    private static final long sequenceMask = -1L ^ (-1L << sequenceBits);


    /**
     * 实际的最大workerId的值 结果是31，8091
     * workerId原则上上限为1024, 但是需要为每台sequence服务预留BACKUP_AMOUNT个workerId,
     * (这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数)
     * //private static final long maxWorkerId = (1L << workerIdBits) / (BACKUP_COUNT + 1);
     * //原来代码 -1 的补码（二进制全1）右移13位, 然后取反
     * //private final static long maxWorkerId = ~(-1L << workerIdBits);
     */

    private static final long maxWorkerId = -1L ^ (-1L << workerIdBits);

    /**
     * 支持的最大数据标识id，结果是31
     */
    private static final long maxDataCenterId = -1L ^ (-1L << dataCenterIdBits);
    /**
     * long workerIdBits = 5L;
     * -1L 的二进制: 1111111111111111111111111111111111111111111111111111111111111111
     * -1L<<workerIdBits = -32 ,二进制: 1111111111111111111111111111111111111111111111111111111111100000
     * workerMask= -1L ^ -32 = 31, 二进制: 11111
     */
    private static long workerMask = -1L ^ (-1L << workerIdBits);
    //进程编码
    private long processId = 1L;
    private static long processMask = -1L ^ (-1L << dataCenterIdBits);


    /**
     * 工作机器ID(0~31)
     * snowflake算法给workerId预留了10位，即workId的取值范围为[0, 1023]，
     * 事实上实际生产环境不大可能需要部署1024个分布式ID服务，
     * 所以：将workerId取值范围缩小为[0, 511]，[512, 1023]
     * 这个范围的workerId当做备用workerId。workId为0的备用workerId是512，
     * workId为1的备用workerId是513，以此类推
     */
    private static long workerId;

    /**
     * 数据中心ID(0~31)
     */
    private long dataCenterId;

    /**
     * 当前毫秒生成的序列
     */
    private long sequence = 0L;

    /**
     * 上次生成ID的时间戳
     */
    private long lastTimestamp = -1L;

    private long extension = 0L;
    private long maxExtension = 0L;

    /**
     * 保留workerId和lastTimestamp, 以及备用workerId和其对应的lastTimestamp
     */
    private static Map<Long, Long> workerIdLastTimeMap = new ConcurrentHashMap<>();

    /**
     * 最大容忍时间, 单位毫秒, 即如果时钟只是回拨了该变量指定的时间, 那么等待相应的时间即可;
     * 考虑到sequence服务的高性能, 这个值不易过大
     */
    private static final long MAX_BACKWARD_MS = 3;
    private static IdSnowflakeWorker idWorker;

    static {
        idWorker = new IdSnowflakeWorker();
    }


    static {
        //2020-09-22 16:27:03
        LocalDateTime dateTime = LocalDateTime.of(2020, 9, 22, 16, 27, 3);
        long milli = dateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        // EPOCH是服务器第一次上线时间点, 设置后不允许修改
        EPOCH = milli;
    }

    //成员类，IdGenUtils的实例对象的保存域
    private static class SnowflakeIdGenHolder {
        private static final IdSnowflakeWorker instance = new IdSnowflakeWorker();
    }

    //外部调用获取IdGenUtils的实例对象，确保不可变
    public static IdSnowflakeWorker getInstance() {
        return SnowflakeIdGenHolder.instance;
    }

    /**
     * 静态工具类
     *
     * @return
     */
    public static Long getGenerateId() {
        long id = idWorker.nextId();
        return id;
    }

    //初始化构造，无参构造有参函数，默认节点都是0
    public IdSnowflakeWorker() {
        //this(0L, 0L);
        this.dataCenterId = getDataCenterId(maxDataCenterId);
        //获取机器编码
        this.workerId = getWorkerId(dataCenterId, maxWorkerId);
    }

    /**
     * 构造函数
     *
     * @param workerId     工作ID (0~31)
     * @param dataCenterId 数据中心ID (0~31)
     */
    public IdSnowflakeWorker(long workerId, long dataCenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (dataCenterId > maxDataCenterId || dataCenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDataCenterId));
        }
        this.workerId = workerId;
        this.dataCenterId = dataCenterId;
    }

    /**
     * 获取带自定义前缀的全局唯一编码
     */
    public String getStrCodingByPrefix(String prefix) {
        Long ele = this.nextId();
        return prefix + ele.toString();
    }

    /**
     * 获得下一个ID (该方法是线程安全的)
     * 在单节点上获得下一个ID，使用Synchronized控制并发，而非CAS的方式，
     * 是因为CAS不适合并发量非常高的场景。
     * <p>
     * 考虑时钟回拨
     * 缺陷: 如果连续两次时钟回拨, 可能还是会有问题, 但是这种概率极低极低
     *
     * @return
     */
    public synchronized long nextId() {
        long currentTimestamp = timeGen();
        // 当发生时钟回拨时
        if (currentTimestamp < lastTimestamp) {
            // 如果时钟回拨在可接受范围内, 等待即可
            long offset = lastTimestamp - currentTimestamp;
            if (offset <= MAX_BACKWARD_MS) {
                try {
                    //睡（lastTimestamp - currentTimestamp）ms让其追上
                    LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(offset));
                    currentTimestamp = timeGen();
                    //如果时间还小于当前时间，那么利用扩展字段加1
                    //或者是采用抛异常并上报
                    if (currentTimestamp < lastTimestamp) {

                        //服务器时钟被调整了,ID生成器停止服务.
                        throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - currentTimestamp));
                    }
                } catch (Exception e) {
                    log.error("时间回拨等待出错:{}", e);
                }
            } else {

                tryGenerateKeyOnBackup(currentTimestamp);
            }
        }

        // 如果和最后一次请求处于同一毫秒, 那么sequence+1
        if (lastTimestamp == currentTimestamp) {
            // 如果当前生成id的时间还是上次的时间，那么对sequence序列号进行+1
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                //自旋等待到下一毫秒
                currentTimestamp = waitUntilNextTime(lastTimestamp);
            }

        } else {
            // 如果是一个更近的时间戳, 那么sequence归零
            sequence = 0L;
        }
        // 更新上次生成id的时间戳
        lastTimestamp = currentTimestamp;

        // 更新map中保存的workerId对应的lastTimestamp
        workerIdLastTimeMap.put(this.workerId, lastTimestamp);

        if (log.isDebugEnabled()) {
            log.debug("{}-{}-{}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(lastTimestamp)), workerId, sequence);
        }

        // 进行移位操作生成int64的唯一ID
        //时间戳右移动23位
        long timestamp = (currentTimestamp - EPOCH) << timestampLeftShift;

        //dataCenterId 右移动(sequenceBits + workerIdBits = 17位)
        long dataCenterId = this.dataCenterId << dataCenterIdShift;

        //workerId 右移动10位
        long workerId = this.workerId << workerIdShift;
        return timestamp | dataCenterId | workerId | sequence;
    }

    /**
     * 尝试在workerId的备份workerId上生成
     * 核心优化代码在方法tryGenerateKeyOnBackup()中，BACKUP_COUNT即备份workerId数越多，
     * sequence服务避免时钟回拨影响的能力越强，但是可部署的sequence服务越少，
     * 设置BACKUP_COUNT为3，最多可以部署1024/(3+1)即256个sequence服务，完全够用，
     * 抗时钟回拨影响的能力也得到非常大的保障。
     *
     * @param currentMillis 当前时间
     */
    private long tryGenerateKeyOnBackup(long currentMillis) {
        // 遍历所有workerId(包括备用workerId, 查看哪些workerId可用)
        for (Map.Entry<Long, Long> entry : workerIdLastTimeMap.entrySet()) {
            this.workerId = entry.getKey();
            // 取得备用workerId的lastTime
            Long tempLastTime = entry.getValue();
            lastTimestamp = tempLastTime == null ? 0L : tempLastTime;

            // 如果找到了合适的workerId
            if (lastTimestamp <= currentMillis) {
                return lastTimestamp;
            }
        }
        // 如果所有workerId以及备用workerId都处于时钟回拨, 那么抛出异常
        throw new IllegalStateException("Clock is moving backwards, current time is "
                + currentMillis + " milliseconds, workerId map = " + workerIdLastTimeMap);
    }

    /**
     * 阻塞到下一个毫秒，直到获得新的时间戳
     *
     * @param lastTimestamp 上次生成ID的时间截
     * @return 当前时间戳
     */
    protected long waitUntilNextTime(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }


    /**
     * 根据机器的MAC地址获取工作进程Id，也可以使用机器IP获取工作进程Id，取最后两个段，一共10个bit
     * 极端情况下，MAC地址后两个段一样，产品的工作进程Id会一样；再极端情况下，并发不大时，刚好跨毫秒，又刚好随机出来的sequence一样的话，产品的Id会重复
     *
     * @return
     * @throws
     */
    protected long getWorkerId() {
        try {
            Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
            while (en.hasMoreElements()) {
                NetworkInterface iface = en.nextElement();
                List<InterfaceAddress> addrs = iface.getInterfaceAddresses();
                for (InterfaceAddress addr : addrs) {
                    InetAddress ip = addr.getAddress();
                    NetworkInterface network = NetworkInterface.getByInetAddress(ip);
                    if (network == null) {
                        continue;
                    }
                    byte[] mac = network.getHardwareAddress();
                    if (mac == null) {
                        continue;
                    }
                    long id = ((0x000000FF & (long) mac[mac.length - 1]) | (0x0000FF00 & (((long) mac[mac.length - 2]) << 8))) >> 11;
                    if (id > maxWorkerId) {
                        return new Random(maxWorkerId).nextInt();
                    }
                    return id;
                }
            }
            return new Random(maxWorkerId).nextInt();
        } catch (Exception e) {
            log.error("雪花算法获取workerId失败:{}", e);
        }
        return new Random(maxWorkerId).nextInt();
    }


    /**
     * 获取WorkerId
     *
     * @param dataCenterId
     * @param maxWorkerId
     * @return
     */
    protected static long getWorkerId(long dataCenterId, long maxWorkerId) {
        StringBuffer mpid = new StringBuffer();
        mpid.append(dataCenterId);
        String name = ManagementFactory.getRuntimeMXBean().getName();
        if (!name.isEmpty()) {
            // GET jvmPid
            mpid.append(name.split("@")[0]);
        }
        // MAC + PID 的 hashcode 获取16个低位
        return (mpid.toString().hashCode() & 0xffff) % (maxWorkerId + 1);
    }

    /**
     * 获取机器编码 用来做数据ID
     * 数据标识id部分 通常不建议采用下面的MAC地址方式，
     * 因为用户通过破解很容易拿到MAC进行破坏
     */
    protected static long getDataCenterId(long tempMaxDataCenterId) {
        if (tempMaxDataCenterId < 0L || tempMaxDataCenterId > maxDataCenterId) {
            tempMaxDataCenterId = maxDataCenterId;
        }
        long id = 0L;
        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            if (network == null) {
                id = 1L;
            } else {
                byte[] mac = network.getHardwareAddress();
                id = ((0x000000FF & (long) mac[mac.length - 1])
                        | (0x0000FF00 & (((long) mac[mac.length - 2]) << 8))) >> 6;
                id = id % (tempMaxDataCenterId + 1);
            }
        } catch (Exception e) {
            log.error("获取机器编码出错：{}", e);
        }
        return id;
    }

}
