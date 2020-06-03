package com.ttac.service.dao.po.metro;

import com.ttac.service.dao.po.BasePO;

import javax.persistence.Column;

/**
 * description:
 *
 * @author bang.tang
 * @date 2020/2/3--14:22
 */
//@Table(name = "department")
//@Entity
//@org.hibernate.annotations.Table(appliesTo = "department", comment = "部门")
//@Data
public class Department extends BasePO {

    /**
     * 外部id
     */
    @Column(length = 32, columnDefinition = "varchar(32) comment '外部id'")
    private String extendId;

    /**
     * 职务名称
     */
    @Column(length = 50, columnDefinition = "varchar(50) comment '职务名称'")
    private String name;





}
