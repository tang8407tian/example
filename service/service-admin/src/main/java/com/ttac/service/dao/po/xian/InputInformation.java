package com.ttac.service.dao.po.xian;

import com.ttac.service.dao.po.BasePO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * description: 录入信息请求vo
 *
 * @author bang.tang
 * @date 2020/2/13--10:02
 */
@Table(name = "input_information")
@Entity
@org.hibernate.annotations.Table(appliesTo = "input_information", comment = "录入信息")
@Data
public class   InputInformation extends BasePO {

    @ApiModelProperty("姓名")
    @Column(length = 50, columnDefinition = " varchar(50) comment '姓名'")
    private String name;

    @ApiModelProperty("电话")
    @Column(length = 18, columnDefinition = " varchar(18) comment '电话'")
    private String tel;

    @ApiModelProperty("身份证")
    @Column(length = 20, columnDefinition = " varchar(20) comment '身份证'")
    private String IDCard;

    @ApiModelProperty("家庭住址")
    @Column(length = 300, columnDefinition = " varchar(300) comment '家庭住址'")
    private String homeAddress;

    @ApiModelProperty("公司名称")
    @Column(length = 300, columnDefinition = " varchar(300) comment '公司名称'")
    private String companyName;

    /**
     * 线路包括：15、14、10（1）、8、6（2）、5（1）、2（2）、1（3），按数字由大到小排序
     */
    @ApiModelProperty("线路")
    @Column(length = 6, columnDefinition = " varchar(6) comment '线路'")
    private String line;

    /**
     * 标段包括：SG1、SG2、SG3、SG4、JL1、JL2、JL3、JL4、SJ1、SJ2、SJ3、SJ4、其他
     */
    @ApiModelProperty("标段")
    @Column(length = 6, columnDefinition = " varchar(6) comment '标段'")
    private String bidSection;


    /**
     * 工区默认隐藏，当标段选择SG1~SG4时，工区显示，选项内容包括工区1、工区2……工区8
     */
    @ApiModelProperty("工区")
    @Column(length = 10, columnDefinition = " varchar(10) comment '工区'")
    private String workArea;

    @ApiModelProperty("工地名称")
    @Column(length = 200, columnDefinition = " varchar(200) comment '工地名称'")
    private String companyAddress;


    @ApiModelProperty("岗位性质")
    @Column(length = 80, columnDefinition = " varchar(80) comment '岗位性质'")
    private String postNature;

    /**
     * 您14天内是否到达或途径湖北省、南阳市、 温州市、广州市、深圳市、杭州市等严控城市
     */
    @ApiModelProperty("行程信息-是否经过严控城市")
    @Column(length = 1, columnDefinition = " tinyint(1) comment '是否经过严控城市'")
    private Boolean goByControlCity;

    @ApiModelProperty("那各城市返回西安-来源省份")
    @Column(length = 50, columnDefinition = " varchar(50) comment '来源省份'")
    private String sourceProvince;

    @ApiModelProperty("那各城市返回西安-来源城市")
    @Column(length = 50, columnDefinition = " varchar(50) comment '来源城市'")
    private String sourceCity;

    @ApiModelProperty("返回西安时间")
    @Column(columnDefinition = " datetime comment '返回西安时间'")
    private LocalDateTime returnXiAnTime;

    @ApiModelProperty("返回的交通工具:BULLET_TRAIN(0,\"高铁\"),\n" +
            "    ORDINARY_TRAIN(1,\"普铁\"),\n" +
            "    AIRCRAFT(2,\"飞机\"),\n" +
            "    METRO(3,\"地铁\"),\n" +
            "    CAR(4,\"汽车\"),\n" +
            "    TAXI(5,\"出租车\"),\n" +
            "    ISOLATION_CAR(6,\"隔离专车\"),\n" +
            "    OTHER(7,\"其他\"),")
    @Column(length = 50, columnDefinition = " varchar(50) comment '返回的交通工具'")
    private String vehicles;

    @ApiModelProperty("接送车牌号")
    @Column(length = 70, columnDefinition = " varchar(70) comment '接送车牌号'")
    private String licensePlateNumber;

    @ApiModelProperty("高速收费站")
    @Column(length = 100, columnDefinition = " varchar(100) comment '高速收费站'")
    private String highSpeedStation;

    @ApiModelProperty("往返西安详细行程")
    @Column(length = 500, columnDefinition = " varchar(500) comment '往返西安详细行程'")
    private String goThereAndBackAddress;

    @ApiModelProperty("隔离信息-是否隔离")
    @Column(length = 1, columnDefinition = " tinyint(1) comment '是否隔离'")
    private Boolean quarantineStatus;

    @ApiModelProperty("隔离类型:COMPULSORY_ISOLATION(0,\"强制隔离\"),\n" +
            "    SELF_ISOLATION(1,\"自行隔离\"),")
    @Column(length = 60, columnDefinition = " varchar(60) comment '隔离类型'")
    private String quarantineType;

    @ApiModelProperty("隔离开始时间")
    @Column(columnDefinition = " datetime comment '隔离开始时间'")
    private LocalDateTime quarantineStartTime;

    @ApiModelProperty("隔离结束时间")
    @Column(columnDefinition = " datetime comment '隔离结束时间'")
    private LocalDateTime quarantineEndTime;

    @ApiModelProperty("是否有健康证明")
    @Column(length = 1, columnDefinition = " tinyint(1) comment '是否有健康证明'")
    private Boolean medicalCertificateStatus;


    @ApiModelProperty("返岗时间")
    @Column(columnDefinition = " datetime comment '返岗时间'")
    private LocalDateTime returnWorkTime;

    @ApiModelProperty("第一次体温")
    @Column(length = 6, columnDefinition = " varchar(6) comment '第一次体温'")
    private String firstTemperature;

    @ApiModelProperty("上岗后住址")
    @Column(length = 200, columnDefinition = " varchar(200) comment '上岗后住址'")
    private String returnAddress;

    @ApiModelProperty("施工单位监督人")
    @Column(length = 60, columnDefinition = " varchar(60) comment '施工单位监督人'")
    private String supervisor;

    @ApiModelProperty("施工单位监督人电话")
    @Column(length = 18, columnDefinition = " varchar(18) comment '施工单位监督人电话'")
    private String supervisorTel;

    @ApiModelProperty("监理-监督人")
    @Column(length = 60, columnDefinition = " varchar(60) comment '监理-监督人'")
    private String engineeringSupervisor;

    @ApiModelProperty("监理-监督人电话")
    @Column(length = 18, columnDefinition = " varchar(18) comment '监理-监督人电话'")
    private String engineeringSupervisorTel;

    @ApiModelProperty("核酸检测结果， true：阳性， false：阴性")
    @Column(length = 1, columnDefinition = " tinyint(1) comment '核酸检测结果， true：阳性， false：阴性'")
    private Boolean checkStatus;

    @ApiModelProperty("核酸检测时间")
    @Column(columnDefinition = " datetime comment '核酸检测时间'")
    private LocalDateTime checkTime;

    @ApiModelProperty("核酸检测单位")
    @Column(length = 200, columnDefinition = " varchar(200) comment '核酸检测单位'")
    private String checkCompany;





}
