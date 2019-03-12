package com.ttac.test;

import com.ttac.common.utils.date.CustomDateUtils;
import com.ttac.entity.admin.enums.CommonEnum;
import com.ttac.entity.admin.vo.SendDataVo;
import com.ttac.entity.admin.vo.UpdateStatusVo;
import com.ttac.entity.admin.vo.demo.Demo1;
import com.ttac.entity.base.vo.date.DateRangeVo;
import com.ttac.service.base.service.IdService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

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

    @Autowired
    private IdService idService;

    @Test
    public void demo1() {
        long nextId = idService.getNextId();
        log.info("生成id:{}", nextId);
    }

    @Test
    public void demo2() {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] ints = twoSum(nums, 9);
        log.info("ints{}", ints);
    }




    public int[] twoSum(int[] nums, int target) {
        Map<Integer, int[]> map = new HashMap<>(nums.length * nums.length - nums.length);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
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
    public void intTest(){
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
    public void dateTest(){
        DateRangeVo dateByDateRange = CustomDateUtils.getDateByDateRange(1480176000000L, 1541347200000L);
        LinkedHashMap<String, Object> map = dateByDateRange.getMap();
        if (null != map){
            log.info("时间集合values：{}", map.values());
            log.info("时间集合key：{}", map.keySet());
        }
        log.info("size：{}",dateByDateRange.getDateList().size());
        log.info("自定义时间工具类测试---dateByDateRange:{}", dateByDateRange.toString());
    }

    @Test
    public void setTest(){
        HashSet<Long> longs = new HashSet<>(0);
        log.info("set集合是否为空:{}", CollectionUtils.isNotEmpty(longs));
        longs.add(1L);
        log.info("set集合是否为空:{}", CollectionUtils.isNotEmpty(longs));
        log.info("set:{}",longs);
    }

    @Test
    public void enumTest(){
        UpdateStatusVo<CommonEnum> updateStatusVo = new UpdateStatusVo<>();
        updateStatusVo.setStatus(CommonEnum.ENABLE);
        log.info("UpdateStatusVo<CommonEnum>:{}", updateStatusVo.toString());
        SendDataVo<UpdateStatusVo> sendDataVo = new SendDataVo<>();
        sendDataVo.setData(updateStatusVo);
        log.info("SendDataVo<UpdateStatusVo>:{}", sendDataVo.toString());
        UpdateStatusVo<CommonEnum> data = sendDataVo.getData();
        log.info("UpdateStatusVo<CommonEnum> data = sendDataVo.getData() :{}", data.toString());
        CommonEnum status = data.getStatus();
        log.info("status:{}、{}、{}",status, status.getCode(), status.getDescription());
    }
}
