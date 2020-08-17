package com.ttac.mqlisten.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * description:
 *
 * @author bang.tang
 * @date 2020/8/15--12:30
 */
@Getter
@AllArgsConstructor
public enum RabbitMqEnum {
    ROUTING_KEY("ttac.top"),
    QUEUE_NAME("ttac.top.queue"),
    EXCHANGE_NAME("ttac")
    ;
    private String desc;


}
