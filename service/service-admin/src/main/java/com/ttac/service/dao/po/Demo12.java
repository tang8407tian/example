package com.ttac.service.dao.po;

import javax.persistence.Column;
import java.time.LocalDateTime;

/**
 * description:
 *
 * @author bang.tang
 * @date 2020/2/3--13:04
 */
//@Entity
//@Table(name = "demo12")
//@Data
public class Demo12 extends BasePO {

    private Long aLong;

    @Column(length = 50)
    private String dst;

    private LocalDateTime localDateTime;
}
