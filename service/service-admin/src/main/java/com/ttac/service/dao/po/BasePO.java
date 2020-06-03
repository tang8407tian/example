package com.ttac.service.dao.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * description: 基础po
 * @MappedSuperclass: 这个注解表示在父类上面的，用来标识父类
 * 标注为@MappedSuperclass的类将不是一个完整的实体类，他将不会映射到数据库表，但是他的属性都将映射到其子类的数据库字段中。
 * 标注为@MappedSuperclass的类不能再标注@Entity或@Table注解，也无需实现序列化接口。
 *
 * @MappedSuperclass: 使用场景
 *     当我们进行开发项目时，我们经常会用到实体映射到数据库表的操作，此时我们经常会发现在我们需要隐射的几个实体类中，
 *         有几个共同的属性，例如编号ID，创建者，创建时间，修改者，修改时间，备注等。遇到这种情况，我们可能会想到把这些属性抽象出来当成一个父类，
 *         然后再以不同的实体类来继承这个父类。
 *     那么，我们便可以使用@MappedSuperclass注解，通过这个注解，我们可以将该实体类当成基类实体，它不会隐射到数据库表，
 *         但继承它的子类实体在隐射时会自动扫描该基类实体的隐射属性，添加到子类实体的对应数据库表中。
 *
 *   数据库 boolean
 *      查询的时候，tinyint字段中的0，1会自动转化成false，true存到boolean属性中
 *      新增时，boolean属性false，true会自动转化成0，1存储到 tinyint[1]字段中
 *
 * @author bang.tang
 * @date 2019/7/16--15:04
 */
@Data
@MappedSuperclass
public class BasePO {

    /**
     * 主键
     */
    @Id
    @Column(columnDefinition = " bigint(32) comment '主键'")
    private Long id;

    /**
     * 创建时间
     */
//    @Column(name = "created_time")
    @Column(columnDefinition = " datetime comment '创建时间'")
    protected LocalDateTime createdTime = LocalDateTime.now();

    /**
     * 更新时间
     */
//    @Column(name = "updated_time")
    @Column(columnDefinition = " datetime comment '创建时间'")
    protected LocalDateTime updatedTime = LocalDateTime.now();

    /**
     * 创建人
     */
//    @Column(name = "creator")
    @Column(length = 32, columnDefinition = " varchar(32) comment '创建人名称'")
    protected String creator;

    /**
     * 创建人id
     */
//    @Column(name = "creator_id")
    @Column(length = 32, columnDefinition = " varchar(32) comment '创建人id'")
    protected Long creatorId;

    /**
     * 最后操作人
     */
//    @Column(name = "last_operator")
    @Column(length = 32, columnDefinition = " varchar(32) comment '最后操作人'")
    protected String lastOperator;

    /**
     * 最后操作人id
     */
//    @Column(name = "last_operator_id")
    @Column(length = 32, columnDefinition = " varchar(32) comment '最后操作人id'")
    protected Long lastOperatorId;

    /**
     * 逻辑删除
     */
//    @Column(name = "is_deleted")
    @Column(length = 1,columnDefinition = " tinyint(1) comment '逻辑删除'")
    protected Boolean deleted = false;









//    /**
//     * 创建时间
//     */
//    @Column(columnDefinition = " datetime comment '创建时间'")
//    private LocalDateTime createTime = LocalDateTime.now();
//
//    /**
//     * 创建人id
//     */
//    @Column(length = 32, columnDefinition = " bigint(32) comment '创建人id'")
//    private Long createById;
//
//    /**
//     * 创建人名称
//     */
//    @Column(length = 20, columnDefinition = " varchar(20) comment '创建人名称'")
//    private String createByName;
//
//    /**
//     * 修改时间
//     */
//    @Column(columnDefinition = " datetime comment '修改时间'")
//    private LocalDateTime updateTime;
//
//    /**
//     * 修改人id
//     */
//    @Column(length = 32, columnDefinition = " bigint(32) comment '修改人id'")
//    private Long updateById;
//
//    @Column(length = 20,columnDefinition = " varchar(20) comment '修改人名称'")
//    private String updateByName;
//
//    @Column(length = 2,columnDefinition = " varchar(2) comment '是否逻辑删除(0:否,1:是)'")
//    private Integer isDel;

}
