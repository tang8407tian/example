package com.ttac.service.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * description:
 *
 * @author bang.tang
 * @date 2019/7/16--16:04
 */
@Service
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    public void set(){
        redisTemplate.expire("masrkey", 1000, TimeUnit.HOURS);
    }
}
