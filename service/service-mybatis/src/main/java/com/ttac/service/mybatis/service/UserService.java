package com.ttac.service.mybatis.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ttac.service.mybatis.dao.entity.User;

/**
 * @author init
 * @description 用户表服务类
 * @since 2019-07-23
 */
public interface UserService extends IService<User> {

    /**
     * 修改
     * @param po
     * @return
     */
    Boolean updateBalance(User po);
}
