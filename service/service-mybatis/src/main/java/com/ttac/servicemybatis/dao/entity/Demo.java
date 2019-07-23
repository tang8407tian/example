package com.ttac.servicemybatis.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.util.Date;
import lombok.Data;

/**
 * @author init
 * @description 
 * @since 2019-07-23
 */
@Data
public class Demo {

    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 
     */
    private String name;
    /**
     * 
     */
    private String age;
    /**
     * 
     */
    private String tel;
    /**
     * 测试
     */
    private String test;
    /**
     * 时间
     */
    @TableField(value="create_time")
    private Timestamp createTime;

}
