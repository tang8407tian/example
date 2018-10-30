package com.ttac.service.base.config;



import com.ttac.service.base.service.IdService;
import com.ttac.service.base.service.IdxFactory;
import com.ttac.service.base.service.ZooKeeperIdxFactory;
import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @author yanweijin
 * @date 2017/9/11
 */
@Configuration
@Component
@Import({
        ZooKeeperConfiguration.class,
})
public class BaseConfiguration {


    @Autowired
    private CuratorFramework curatorFramework;

    @Bean
    IdxFactory idxFactory() {
        return new ZooKeeperIdxFactory(curatorFramework);
    }

    @Bean
    IdService idService() {
        return new IdService(idxFactory());
    }


}
