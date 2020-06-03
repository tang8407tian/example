package com.ttac.service.dao.po.metro;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * description:
 *
 * @author bang.tang
 * @date 2020/2/3--16:14
 */
//@Table(name = "police_task_police_ref")
//@Entity
//@org.hibernate.annotations.Table(appliesTo = "police_task_police_ref", comment = "警务—执行公安人员关联表")
//@Data
public class PoliceTaskPoliceRef {

    /**
     * 主键
     */
    @Id
    @Column(columnDefinition = " bigint(32) comment '主键'")
    private Long id;

    /**
     * 创建时间
     */
    @Column(columnDefinition = " datetime comment '创建时间'")
    private LocalDateTime createTime = LocalDateTime.now();

    /**
     * 警务id
     */
    @Column(columnDefinition = " bigint(32) comment '警务id'")
    private Long policeTaskId;


    /**
     * 执行公安人员id
     */
    @Column(columnDefinition = " bigint(32) comment '执行公安人员id'")
    private Long policeId;
}
