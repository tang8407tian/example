package com.ttac.service.dao.po.metro;

import com.ttac.service.dao.po.BasePO;

import javax.persistence.Column;

/**
 * description:
 *
 * @author bang.tang
 * @date 2020/2/3--14:22
 */
//@Table(name = "police_group")
//@Entity
//@org.hibernate.annotations.Table(appliesTo = "police_group", comment = "公安人员-分组")
//@Data
public class PoliceGroup extends BasePO {


    /**
     * 分组名称
     */
    @Column(length = 60, columnDefinition = "varchar(60) comment '分组名称'")
    private String name;
}
