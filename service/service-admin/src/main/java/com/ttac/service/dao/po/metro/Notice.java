package com.ttac.service.dao.po.metro;

import com.ttac.service.dao.po.BasePO;

import javax.persistence.Column;
import java.time.LocalDateTime;

/**
 * description:
 *
 * @author bang.tang
 * @date 2020/2/4--9:32
 */
//@Table(name = "notice")
//@Entity
//@org.hibernate.annotations.Table(appliesTo = "notice", comment = "顶部消息通知")
//@Data
public class Notice  extends BasePO {

    /**
     * 交通告警ID
     */
    @Column(length = 32, columnDefinition = "bigint(32) comment '交通告警ID'")
    private Long trafficWarningId;

    /**
     * 消息
     */
    @Column(length = 220, columnDefinition = "varchar(220) comment '消息'")
    private String message;

    /**
     * 告警时间
     */
    @Column(columnDefinition = " datetime comment '告警时间'")
    private LocalDateTime alarmTime;

    /**
     * 告警站点/报警车辆
     */
    @Column(length = 100,columnDefinition = "varchar(100) comment '告警站点/报警车辆'")
    private String alarmAddress;

    /**
     * 是否查看
     * 查询的时候，tinyint字段中的0，1会自动转化成false，true存到boolean属性中
     *
     * 新增时，boolean属性false，true会自动转化成0，1存储到tinyint[1]字段中
     */
    @Column(length = 20, columnDefinition = "varchar(20) comment '是否查看'")
    private String checkStatus;

    /**
     * 第一次查看人员id
     */
    @Column(length = 32, columnDefinition = "bigint(32) comment '第一次查看人员id'")
    private Long checkPersonId;
}
