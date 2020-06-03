package com.ttac.service.mybatis.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ttac.service.mybatis.dao.entity.Demo;
import com.ttac.service.mybatis.dao.mapper.DemoMapper;
import com.ttac.service.mybatis.service.DemoService;
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
