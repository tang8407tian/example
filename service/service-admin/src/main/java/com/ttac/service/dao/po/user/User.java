package com.ttac.service.dao.po.user;

import com.ttac.service.dao.po.BasePO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * description: 用户
 *
 * @author bang.tang
 * @date 2019/7/16--15:03
 */
@Table(name = "user")
@Entity
@org.hibernate.annotations.Table(appliesTo = "user", comment = "用户表")
@Data
public class User extends BasePO {

    /**
     * 账号
     */
    @Column(length = 30, columnDefinition = "varchar(30) comment '登录账号'")
    private String accountNumber;

    /**
     * 密码
     */
    @Column(length = 50, columnDefinition = "varchar(50) comment '密码'")
    private String password;

    /**
     * 电话号码
     */
    @Column(length = 15,columnDefinition = "varchar(15) comment '电话号码'")
    private String telephone;
}
