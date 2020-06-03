package com.ttac.service.dao.po.metro;

import com.ttac.service.dao.po.BasePO;

import javax.persistence.Column;

/**
 * description:
 *
 * @author bang.tang
 * @date 2020/2/3--15:34
 */
//@Table(name = "police_warning_situation")
//@Entity
//@org.hibernate.annotations.Table(appliesTo = "police_warning_situation", comment = "警情")
//@Data
public class PoliceWarningSituation extends BasePO {


    /**
     * 上报类容
     */
    @Column(length = 200, columnDefinition = "varchar(200) comment '上报类容'")
    private String reportMessage;


    /**
     * 上报人id
     */
    @Column(length = 32, columnDefinition = "varchar(32) comment '上报人id'")
    private String rapporteurId;


    /**
     * 上报人名称
     */
    @Column(length = 30, columnDefinition = "varchar(30) comment '上报人名称'")
    private String rapporteurName;

    /**
     * 上报人电话
     */
    @Column(length = 16, columnDefinition = "varchar(16) comment '上报人电话'")
    private String rapporteurTel;


    /**
     * 是否生成警务枚举
     */
    @Column(length = 20,columnDefinition = "tinyint(1) comment '是否生成警务枚举'")
    private Boolean policeTaskStatus;

    /**
     * 上报图片地址
     */
    @Column(length = 500,columnDefinition = "varchar(500) comment '上报图片地址(多张图片逗号隔开)'")
    private String reportPictureUrls;
}
