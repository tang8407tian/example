package com.ttac.service.dao.po.metro;

import com.ttac.service.dao.po.BasePO;

import javax.persistence.Column;

/**
 * description:
 *
 * @author bang.tang
 * @date 2020/2/3--14:22
 */
//@Table(name = "traffic_staff_metro")
//@Entity
//@org.hibernate.annotations.Table(appliesTo = "traffic_staff_metro", comment = "交通人员-地铁")
//@Data
public class TrafficStaffMetro extends BasePO {


    /**
     * 交通地铁人员外部ID
     */
    @Column(length = 32, columnDefinition = "varchar(32) comment '交通地铁人员外部ID'")
    private String trafficStaffMetroExtendId;

    /**
     * 姓名
     */
    @Column(length = 50, columnDefinition = "varchar(50) comment '姓名'")
    private String name;

    /**
     * 性别枚举:0:女，1:男
     */
    @Column(length = 20, columnDefinition = "varchar(20) comment '性别枚举'")
    private String gender;

    /**
     * 手机号
     */
    @Column(length = 16, columnDefinition = "varchar(16) comment '手机号'")
    private String tel;

    /**
     * 站点
     */
    @Column(length = 60, columnDefinition = "varchar(60) comment '站点'")
    private String site;

    /**
     * 职务枚举
     */
    @Column(length = 20, columnDefinition = "varchar(20) comment '职务枚举'")
    private String post;

    /**
     * 部门id
     */
    @Column(length = 32, columnDefinition = "varchar(32) comment '部门id'")
    private String departmentId;


    /**
     * 部门名称
     */
    @Column(length = 30, columnDefinition = "varchar(30) comment '部门名称'")
    private String departmentName;

    /**
     * 机构枚举
     */
    @Column(length = 32, columnDefinition = "varchar(32) comment '机构枚举'")
    private String mechanism;


    /**
     * 公司id
     */
    @Column(length = 32, columnDefinition = "varchar(32) comment '公司id'")
    private String companyId;


    /**
     * 公司名称
     */
    @Column(length = 30, columnDefinition = "varchar(30) comment '公司名称'")
    private String companyName;


    /**
     * 设备id
     * equipment
     */
    @Column(length = 32, columnDefinition = "varchar(32) comment '设备id'")
    private String equipmentId;



}
