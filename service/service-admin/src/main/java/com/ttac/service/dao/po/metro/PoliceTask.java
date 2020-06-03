package com.ttac.service.dao.po.metro;

import com.ttac.service.dao.po.BasePO;

import javax.persistence.Column;
import java.time.LocalDateTime;

/**
 * description:
 *
 * @author bang.tang
 * @date 2020/2/3--15:34
 */
//@Table(name = "police_task")
//@Entity
//@org.hibernate.annotations.Table(appliesTo = "police_task", comment = "警务")
//@Data
public class PoliceTask extends BasePO {

    /**
     * 警务外部ID
     */
    @Column(length = 32, columnDefinition = "varchar(32) comment '警务外部ID'")
    private String policeTaskId;

    /**
     * 告警类型枚举
     */
    @Column(length = 20,columnDefinition = "varchar(20) comment '告警类型枚举'")
    private String alarmType;

    /**
     * 告警来源枚举
     */
    @Column(length = 20,columnDefinition = "varchar(20) comment '告警来源枚举'")
    private String alarmSource;

    /**
     * 关联事物来源枚举
     */
    @Column(length = 20,columnDefinition = "varchar(20) comment '关联事物来源枚举'")
    private String transactionSource;

    /**
     * 关联事物id
     */
    @Column(length = 32, columnDefinition = "bigint(32) comment '关联事物id'")
    private Long transactionId;


    /**
     * 上报人id
     */
    @Column(length = 32, columnDefinition = "varchar(32) comment '上报人id'")
    private String rapporteurId;


    /**
     * 警务描述
     */
    @Column(length = 220, columnDefinition = "varchar(220) comment '警务描述'")
    private String remark;

    /**
     * 警务描述图片地址
     */
    @Column(length = 220, columnDefinition = "varchar(220) comment '警务描述图片地址多张逗号隔开'")
    private String remarkUrls;

    /**
     * 关联预案ID
     */
    @Column(length = 32, columnDefinition = "bigint(32) comment '关联预案ID'")
    private Long reservePlanId;


    /**
     * 警务查看状态
     */
    @Column(length = 20,columnDefinition = "varchar(20) comment '警务查看状态'")
    private String policeTaskCheckUpStatus;

    /**
     * 警务处理状态
     */
    @Column(length = 20,columnDefinition = "varchar(20) comment '警务处理状态'")
    private String policeTaskSolvedStatus;

    /**
     * 事务时间
     */
    @Column(columnDefinition = " datetime comment '事务时间'")
    private LocalDateTime transactionTime;

    /**
     * 告警站点/报警车辆
     */
    @Column(length = 100,columnDefinition = "varchar(100) comment '告警站点/报警车辆'")
    private String alarmAddress;

    /**
     * 事务内容
     */
    @Column(length = 220,columnDefinition = "varchar(220) comment '事务内容'")
    private String transactionMessage;

    /**
     * 处理时间
     */
    @Column(columnDefinition = " datetime comment '处理时间'")
    private LocalDateTime solvedTime;

    /**
     * 处理结果
     */
    @Column(length = 220,columnDefinition = "varchar(220) comment '处理结果'")
    private String solvedRemark;

    /**
     * 处理结果图片地址
     */
    @Column(length = 220,columnDefinition = "varchar(500) comment '处理结果图片地址多张逗号隔开'")
    private String solvedRemarkUrls;

    /**
     * 现场图片
     */
    @Column(length = 500,columnDefinition = "varchar(500) comment '现场图片多张逗号隔开'")
    private String sceneUrls;


}
