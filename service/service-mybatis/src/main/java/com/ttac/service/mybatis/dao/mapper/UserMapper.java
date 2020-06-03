package com.ttac.service.mybatis.dao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ttac.service.mybatis.dao.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author init
 * @description 用户表
 * @since 2019-07-23
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 修改
     * @param po
     * @return
     */
    Boolean updateBalance(@Param("po") User po);
}