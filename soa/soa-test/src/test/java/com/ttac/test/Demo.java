package com.ttac.test;

import com.ttac.common.utils.date.CustomDateUtils;
import com.ttac.entity.admin.enums.CommonEnum;
import com.ttac.entity.admin.vo.SendDataVo;
import com.ttac.entity.admin.vo.UpdateStatusVo;
import com.ttac.entity.admin.vo.demo.Demo1;
import com.ttac.entity.base.vo.date.DateRangeVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.*;

/**
 * introduce：
 *
 * @date: 2018/10/22
 * @author: bang.tang
 * @time: 14:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Demo {

    @Test
    public void demo2() {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] ints = twoSum(nums, 9);
        log.info("ints{}", ints);
    }


    public int[] twoSum(int[] nums, int target) {
        Map<Integer, int[]> map = new HashMap<>(nums.length * nums.length - nums.length);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (i != j) {
                    int[] links = new int[2];
                    links[0] = i;
                    links[1] = j;
                    int targets = nums[i] + nums[j];
                    if (map.get(targets) == null) {
                        map.put(targets, links);
                    }
                }
            }
        }

        return map.get(target);
    }

    @Test
    public void numberTest(){
        log.info("20/2:{}", 20/2);
        log.info("20%2:{}", 20%2);
        log.info("20/20:{}", 20/20);
        log.info("20%20:{}", 20%20);
        log.info("20/200:{}", 20/200);
        log.info("20%200:{}", 20%200);
    }

    @Test
    public void intTest() {
        Demo1 demo1 = new Demo1();
        demo1.setAge(1999666);
        demo1.setBigAge(20000L);
        demo1.setName("测试1");
        Demo1 demo2 = new Demo1();
        demo2.setAge(12);
        demo2.setBigAge(123132L);
        demo2.setName("测试2");
        log.info("测试1:{}", demo1.toString());
        log.info("测试2:{}", demo2.toString());
    }

    /**
     * 自定义时间工具类测试
     */
    @Test
    public void dateTest() {
        DateRangeVo dateByDateRange = CustomDateUtils.getDateByDateRange(1480176000000L, 1541347200000L);
        LinkedHashMap<String, Object> map = dateByDateRange.getMap();
        if (null != map) {
            log.info("时间集合values：{}", map.values());
            log.info("时间集合key：{}", map.keySet());
        }
        log.info("size：{}", dateByDateRange.getDateList().size());
        log.info("自定义时间工具类测试---dateByDateRange:{}", dateByDateRange.toString());
    }

    @Test
    public void setTest() {
        HashSet<Long> longs = new HashSet<>(0);
        log.info("set集合是否为空:{}", CollectionUtils.isNotEmpty(longs));
        longs.add(1L);
        log.info("set集合是否为空:{}", CollectionUtils.isNotEmpty(longs));
        log.info("set:{}", longs);
    }

    @Test
    public void enumTest() {
        UpdateStatusVo<CommonEnum> updateStatusVo = new UpdateStatusVo<>();
        updateStatusVo.setStatus(CommonEnum.ENABLE);
        log.info("UpdateStatusVo<CommonEnum>:{}", updateStatusVo.toString());
        SendDataVo<UpdateStatusVo> sendDataVo = new SendDataVo<>();
        sendDataVo.setData(updateStatusVo);
        log.info("SendDataVo<UpdateStatusVo>:{}", sendDataVo.toString());
        UpdateStatusVo<CommonEnum> data = sendDataVo.getData();
        log.info("UpdateStatusVo<CommonEnum> data = sendDataVo.getData() :{}", data.toString());
        CommonEnum status = data.getStatus();
        log.info("status:{}、{}、{}", status, status.getCode(), status.getDescription());
    }


    /**
     * 集合排序测试
     */
    @Test
    public void sortListTest() {
        List<Demo1> list = Lists.newArrayList();
//        list.add(new Demo1(70,"张三"));
//        list.add(new Demo1(10,"李四"));
//        list.add(new Demo1(50,"王五"));
//        list.add(new Demo1(130,"赵立"));
//        list.add(new Demo1(44,"阿奇"));

        log.info("排序前集合顺序:{}", list);
        Collections.reverse(list);
        log.info("排序 reverse 集合顺序:{}", list);
        Collections.sort(list, new Comparator<Demo1>() {
            @Override
            public int compare(Demo1 o1, Demo1 o2) {
                if (o1.getAge() > o2.getAge()) {
                    return 1;
                }
                if (Objects.equals(o1.getAge(), o2.getAge())) {
                    return 0;
                }
                return -1;
            }
        });
        log.info("排序  后1  集合顺序:{}", list);
        Collections.sort(list, new Comparator<Demo1>() {
            @Override
            public int compare(Demo1 o1, Demo1 o2) {
                if (o1.getAge() > o2.getAge()) {
                    return -1;
                }
                if (Objects.equals(o1.getAge(), o2.getAge())) {
                    return 0;
                }
                return 1;
            }
        });
        log.info("排序  后2  集合顺序:{}", list);
    }

    @Test
    public void demo4Test(){
        String str = "helloo word oo";
        int i = str.codePointAt(1);
        log.info("codePointAt:{}", i);
        log.info("\"ab\".equals(new StringBuilder(\"ab\")):{}","ab".equals(new StringBuilder("ab")));
        log.info("\"ab\".contentEquals(new StringBuilder(\"ab\")):{}","ab".contentEquals(new StringBuilder("ab")));

        String replace = str.replace("o", "T");
        log.info("replace(char oldChar, char newChar)--》old：{}、new:{}", str, replace);
        String replaceFirst = str.replaceFirst("o", "R");
        log.info("replaceFirst:{}", replaceFirst);
    }

    @Test
    public void stringTimeTest(){
        int number = 100000;
        Timestamp strStart = new Timestamp(System.currentTimeMillis());
        String str = "a";
        for (int i = 0;i<= number; i++){
            str += i+"-";
        }
        Timestamp strEnd = new Timestamp(System.currentTimeMillis());
        log.info("str执行时间:{}",strEnd.getTime() - strStart.getTime());

        Timestamp bufferStart = new Timestamp(System.currentTimeMillis());
        StringBuffer stringBuffer = new StringBuffer();
        for (int i =0;i <= number;i++){
            stringBuffer.append(i).append("-");
        }
        Timestamp bufferEnd = new Timestamp(System.currentTimeMillis());
        log.info("buffer执行时间:{}",bufferEnd.getTime() - bufferStart.getTime());


        Timestamp builderStart = new Timestamp(System.currentTimeMillis());
        StringBuilder builder = new StringBuilder();
        for (int i =0;i <= number;i++){
            builder.append(i).append("-");
        }
        Timestamp builderEnd = new Timestamp(System.currentTimeMillis());
        log.info("builder执行时间:{}",builderEnd.getTime() - builderStart.getTime());
    }
}
