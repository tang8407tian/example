package com.ttac.servicemybatis.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ttac.servicemybatis.dao.entity.Demo;
import com.ttac.servicemybatis.dao.mapper.DemoMapper;
import com.ttac.servicemybatis.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author init
 * @description  服务实现类
 * @since 2019-07-23
 */
@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, Demo> implements DemoService {

    @Autowired
    private DemoMapper demoMapper;


}
