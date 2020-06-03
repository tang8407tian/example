package com.ttac.service.dao.po.metro;

import com.ttac.service.dao.po.BasePO;

import javax.persistence.Column;
import java.time.LocalDateTime;

/**
 * description:交通告警
 *
 * @author bang.tang
 * @date 2020/2/3--16:21
 */
//@Table(name = "traffic_warning")
//@Entity
//@org.hibernate.annotations.Table(appliesTo = "traffic_warning", comment = "交通告警")
//@Data
public class TrafficWarning extends BasePO {

    /**
     * 是否生成警务
     */
    @Column(length = 1, columnDefinition = "tinyint(1) comment '是否生成警务'")
    private Boolean createTask;

    /**
     * 告警事务ID
     */
    @Column(length = 32, columnDefinition = "varchar(32) comment '告警事务ID'")
    private String trafficWarningId;

    /**
     * 告警来源枚举
     */
    @Column(length = 20,columnDefinition = "varchar(20) comment '告警来源枚举'")
    private String alarmSource;

    /**
     * 告警站点/报警车辆
     */
    @Column(length = 100,columnDefinition = "varchar(100) comment '告警站点/报警车辆'")
    private String alarmAddress;


    /**
     * 告警大类枚举
     */
    @Column(length = 20,columnDefinition = "varchar(20) comment '告警大类枚举'")
    private String alarmLargeType;


    /**
     * 告警子类枚举
     */
    @Column(length = 20,columnDefinition = "varchar(20) comment '告警子类枚举'")
    private String alarmSubtype;

    /**
     * 告警内容
     */
    @Column(length = 220,columnDefinition = "varchar(220) comment '告警内容'")
    private String remark;


    /**
     * 告警时间
     */
    @Column(columnDefinition = " datetime comment '告警时间'")
    private LocalDateTime alarmTime;

    /**
     * 抓取图片地址,多张逗号隔开
     */
    @Column(length = 500,columnDefinition = "varchar(500) comment '抓取图片地址,多张逗号隔开'")
    private String grabPicturesUrls;

    /**
     * 监控视频
     */
    @Column(length = 220,columnDefinition = "varchar(220) comment '监控视频'")
    private String surveillanceVideoUrl;

    /**
     * 摄像头外部id
     */
    @Column(length = 32, columnDefinition = "varchar(32) comment '摄像头外部id'")
    private String pickUpHeadId;


    /**
     * 处理状态枚举
     */
    @Column(length = 2,columnDefinition = "int(2) comment '处理状态枚举'")
    private String handleStatus;

    /**
     * 处理时间
     */
    @Column(columnDefinition = " datetime comment '处理时间'")
    private LocalDateTime handleTime;

    /**
     * 处理人
     */
    @Column(length = 40,columnDefinition = "varchar(40) comment '处理人'")
    private String handler;

    /**
     *
     * 处理人ID
     */
    @Column(length = 32,columnDefinition = "varchar(32) comment '处理人ID'")
    private String handlerId;

    /**
     *
     * 处理人电话
     */
    @Column(length = 16,columnDefinition = "varchar(16) comment '处理人电话'")
    private String handlerTel;

    /**
     *
     * 处理结果信息
     */
    @Column(length = 220,columnDefinition = "varchar(220) comment '处理结果信息'")
    private String handleMessage;

    /**
     *
     * 处理结果信息图片url,多张图片逗号隔开
     */
    @Column(length = 500,columnDefinition = "varchar(500) comment '处理结果信息图片url,多张图片逗号隔开'")
    private String handleMessageUrls;
}
