package com.ttac.service.dao.po.metro;

import com.ttac.service.dao.po.BasePO;

import javax.persistence.Column;

/**
 * description:
 *
 * @author bang.tang
 * @date 2020/2/3--13:23
 */
//@Table(name = "traffic_vide_monitor_taxi")
//@Entity
//@org.hibernate.annotations.Table(appliesTo = "traffic_vide_monitor_taxi", comment = "交通视频监-出租车")
//@Data
public class TrafficVideoMonitoringTaxi extends BasePO {

    /**
     * 摄像头id
     */
    @Column(length = 32, columnDefinition = "varchar(30) comment '摄像头id'")
    private String pickUpHeadId;

    /**
     * 出租车车牌号
     */
    @Column(length = 50, columnDefinition = "varchar(50) comment '出租车车牌号'")
    private String taxiLicensePlateNumber;


    /**
     * 实时视频地址
     */
    @Column(length = 250,columnDefinition = "varchar(250) comment '实时视频地址'")
    private String taxiLive;
}
