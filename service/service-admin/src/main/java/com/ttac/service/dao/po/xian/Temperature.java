package com.ttac.service.dao.po.xian;

import com.ttac.service.dao.po.BasePO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * description:
 *
 * @author bang.tang
 * @date 2020/2/14--19:20
 */
@Table(name = "temperature")
@Entity
@org.hibernate.annotations.Table(appliesTo = "temperature", comment = "体温")
@Data
public class Temperature extends BasePO {

    @Column(length = 50, columnDefinition = " varchar(50) comment '姓名'")
    private String name;

    @Column(length = 10, columnDefinition = " varchar(10) comment '性别'")
    private String gender;

    @Column(length = 16, columnDefinition = " varchar(16) comment '手机号'")
    private String tel;

    @Column(length = 20, columnDefinition = " varchar(20) comment '身份证'")
    private String IdCard;

    @Column(length = 14, columnDefinition = " varchar(14) comment '测温年月日'")
    private String day;

    @Column(columnDefinition = " datetime comment '测量体温时间'")
    private Timestamp checkUpTime;

    @Column(length = 6, columnDefinition = " varchar(6) comment '温度'")
    private String temperature;
}
