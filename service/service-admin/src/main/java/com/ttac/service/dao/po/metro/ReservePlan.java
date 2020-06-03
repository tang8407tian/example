package com.ttac.service.dao.po.metro;

import com.ttac.service.dao.po.BasePO;

import javax.persistence.Column;

/**
 * description:
 *
 * @author bang.tang
 * @date 2020/2/3--14:22
 */
//@Table(name = "reserve_plan")
//@Entity
//@org.hibernate.annotations.Table(appliesTo = "reserve_plan", comment = "预案")
//@Data
public class ReservePlan extends BasePO {


    /**
     * 预案描述
     */
    @Column(length = 200, columnDefinition = "varchar(200) comment '预案描述'")
    private String remark;

    /**
     * 选择预案图片url
     */
    @Column(length = 200, columnDefinition = "varchar(200) comment '选择预案图片url'")
    private String pictureUrl;





}
