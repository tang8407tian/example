package com.ttac.service.myabtis.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Data;

/**
 * @author init
 * @description 用户表
 * @since 2019-07-23
 */
@Data
public class User {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 创建人id
     */
    @TableField(value="create_by_id")
    private Long createById;
    /**
     * 创建人名称
     */
    @TableField(value="create_by_name")
    private String createByName;
    /**
     * 创建时间
     */
    @TableField(value="create_time")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 修改人id
     */
    @TableField(value="update_by_id")
    private Long updateById;
    /**
     * 修改人名称
     */
    @TableField(value="update_by_name")
    private String updateByName;
    /**
     * 修改时间
     */
    @TableField(value="update_time")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 账号
     */
    @TableField(value="account_number")
    private String accountNumber;
    /**
     * 密码
     */
    private String password;
    /**
     * 电话号码
     */
    private String telephone;

}
