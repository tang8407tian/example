package com.ttac.service.mybatis.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ttac.service.mybatis.dao.entity.User;
import com.ttac.service.mybatis.dao.mapper.UserMapper;
import com.ttac.service.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author init
 * @description 用户表 服务实现类
 * @since 2019-07-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;


    /**
     * 修改
     *
     * @param po
     * @return
     */
    @Override
    public Boolean updateBalance(User po) {
        userMapper.updateBalance(po);
        return null;
    }
}
