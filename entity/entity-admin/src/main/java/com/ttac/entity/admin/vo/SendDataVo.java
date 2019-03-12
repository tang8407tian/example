package com.ttac.entity.admin.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * introduce：微服务间传递vo
 *
 * @date: 2018/6/11
 * @author: fish
 * @time: 18:06
 */
@Data
public class SendDataVo<T> implements Serializable{

    private static final long serialVersionUID = 4291902248625067081L;
    /**
     * 用户名
     */
    private String userName;

    /**
     * 单个数据
     */
    private T data;

    /**
     * 集合数据
     */
    private  List<T> listData;

    /**
     * 数据vo无参构造
     */
    public SendDataVo() {
    }
    /**
     * 单条数据带参构造
     */

    public SendDataVo(String userName, T data) {
        this.userName = userName;
        this.data = data;
    }

    /**
     * 集合数据
     * @param userName
     * @param listData
     */
    public SendDataVo(String userName, List<T> listData) {
        this.userName = userName;
        this.listData = listData;
    }

    /**
     * 单条、集合数据
     * @param userName
     * @param data
     * @param listData
     */
    public SendDataVo(String userName, T data, List<T> listData) {
        this.userName = userName;
        this.data = data;
        this.listData = listData;
    }
}
