package com.ttac.service;

import com.ttac.service.base.service.IdService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
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
}
