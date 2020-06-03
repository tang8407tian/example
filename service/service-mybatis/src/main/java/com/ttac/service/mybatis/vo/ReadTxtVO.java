package com.ttac.service.mybatis.vo;

import lombok.Data;

/**
 * description:
 *
 * @author bang.tang
 * @date 2019/12/16--16:13
 */
@Data
public class ReadTxtVO {

    /**
     * 商户编号 :
     * 终端编号 :
     * 商户名称 :
     * 交易日期 :
     * 交易时间 :
     * 清算日期 :
     * 交易类型 :
     *
     * 工行订单号 :
     * 商户订单号 :
     * 卡号 :
     * 交易金额 :
     * 手续费 :
     * 分期手续费 :
     * 划款金额 :
     * 授权号 :
     * 机构标识 :
     * 支付方式 :
     * 交易检索号 :
     * 备注 :
     */

    /**
     * 商户编号
     */
    private String mchNo;

    /**
     * 终端编号
     */
    private String terminalNo;

    /**
     * 商户名称
     */
    private String mchName;

    /**
     * 交易日期
     */
    private String transactionDate;

    /**
     * 交易时间
     */
    private String transactionTime;

    /**
     * 清算日期
     */
    private String dateOfLiquidation;

    /**
     * 交易类型
     */
    private String paymentType;

    /**
     * 工行订单号
     */
    private String ICBCNo;

    /**
     * 商户订单号
     */
    private String mchOrderNo;

    /**
     * 卡号
     */
    private String cardNo;

    /**
     * 交易金额
     * 元
     */
    private String paymentPrice;

    /**
     * 手续费
     * 元
     */
    private String serviceCharge;

    /**
     * 分期手续费
     * 元
     */
    private String installmentServiceCharge;

    /**
     * 划款金额
     * 元
     */
    private String drawMoney;

    /**
     * 授权号
     */
    private String authorizationNumber;

    /**
     * 机构标识
     */
    private String mechanismIdentification;

    /**
     * 支付方式
     */
    private String paymentMethod;

    /**
     * 交易检索号
     */
    private String transitionalIndex;

    /**
     * 备注
     */
    private String remark;
}
