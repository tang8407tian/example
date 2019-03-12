package com.ttac.entity.admin.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * introduce：
 *
 * @date: 2019/2/21
 * @author: bang.tang
 * @time: 14:23
 */
@Data
public class UpdateStatusVo<T> implements Serializable {

    /**
     * id
     */
    private String id;

    /**
     * 状态
     */
    private T status;
}
