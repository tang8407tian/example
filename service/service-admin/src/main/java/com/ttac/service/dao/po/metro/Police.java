package com.ttac.service.dao.po.metro;

import com.ttac.service.dao.po.BasePO;

import javax.persistence.Column;

/**
 * description:
 *
 * @author bang.tang
 * @date 2020/2/3--14:22
 */
//@Table(name = "police")
//@Entity
//@org.hibernate.annotations.Table(appliesTo = "police", comment = "公安人员")
//@Data
public class Police extends BasePO {


    /**
     * 公安人员外部ID(预留)
     */
    @Column(length = 32, columnDefinition = "varchar(32) comment '公安人员外部ID(预留)'")
    private String policeExtendId;

    /**
     * 姓名
     */
    @Column(length = 50, columnDefinition = "varchar(50) comment '姓名'")
    private String name;

    /**
     * 性别枚举:0:女，1:男
     */
    @Column(length = 2, columnDefinition = "varchar(2) comment '性别枚举:0:女，1:男'")
    private String gender;

    /**
     * 手机号 账号
     */
    @Column(length = 16, columnDefinition = "varchar(16) comment '手机号(账号)'")
    private String tel;

    /**
     * 密码
     */
    @Column(length = 220, columnDefinition = "varchar(220) comment '密码'")
    private String password;

    /**
     * 所属分组id
     *
     */
    @Column(length = 16, columnDefinition = "varchar(16) comment '所属分组id'")
    private Long policeGroupId;

    /**
     * 设备id
     * equipment
     */
    @Column(length = 32, columnDefinition = "varchar(32) comment '设备id'")
    private String equipmentId;

    /**
     * 是否关联设备枚举
     */
    @Column(length = 1, columnDefinition = "tinyint(1) comment '是否关联设备枚举'")
    private Boolean associatedEquipmentStatus;
}
