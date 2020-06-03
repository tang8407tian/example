package com.ttac.service.dao.po.metro;

import com.ttac.service.dao.po.BasePO;

import javax.persistence.Column;
/**
 * description:
 *
 * @author bang.tang
 * @date 2020/2/3--13:23
 */
//@Table(name = "traffic_vide_monitor_metro")
//@Entity
//@org.hibernate.annotations.Table(appliesTo = "traffic_vide_monitor_metro", comment = "交通视频监-地铁")
//@Data
public class TrafficVideoMonitoringMetro extends BasePO {

    /**
     * 摄像头id
     */
    @Column(length = 32, columnDefinition = "varchar(30) comment '摄像头id'")
    private String pickUpHeadId;

    /**
     * 所属站点
     */
    @Column(length = 50, columnDefinition = "varchar(50) comment '所属站点'")
    private String subordinateSite;

    /**
     * 地铁线路
     */
    @Column(length = 20,columnDefinition = "varchar(20) comment '地铁线路枚举'")
    private String metroLine;


    /**
     * 实时视频地址
     */
    @Column(length = 250,columnDefinition = "varchar(250) comment '实时视频地址'")
    private String metroLive;
}
