package com.ttac.service.base.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 默认情况下,不使用这个配置
 *
 * @author yanweijin
 * @date 2017/6/2
 */
@Configuration
@Slf4j
public class ZooKeeperConfiguration {

    @Bean(destroyMethod = "close")
    CuratorFramework curator(@Value("${primus.zookeeper.url}") String zookeeperUrl) {
        log.info("zookeeper url = {}", zookeeperUrl);
        CuratorFramework client = CuratorFrameworkFactory.builder().connectString(zookeeperUrl)
                .retryPolicy(new RetryNTimes(Integer.MAX_VALUE, 1000))
                .connectionTimeoutMs(8000).build();
        client.start();
        return client;
    }


}
