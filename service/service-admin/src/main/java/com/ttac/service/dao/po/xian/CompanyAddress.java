package com.ttac.service.dao.po.xian;

import com.ttac.service.dao.po.BasePO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * description:
 *
 * @author bang.tang
 * @date 2020/2/13--13:09
 */
@Table(name = "company_address")
@Entity
@org.hibernate.annotations.Table(appliesTo = "company_address", comment = "工地地址信息")
@Data
public class CompanyAddress extends BasePO {

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
}
