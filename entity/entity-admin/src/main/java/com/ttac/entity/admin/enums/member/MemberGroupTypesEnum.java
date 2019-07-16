package com.ttac.entity.admin.enums.member;

import com.ttac.entity.admin.util.enums.BaseConvertEnum;
import com.ttac.entity.admin.util.enums.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 会员分组枚举
 *
 *
 * 计算日期：一年内,已完成支付的订单
 * R：客户最后一次交易日期距离当前天数,取所有客户最后一次交易日期距离当前天数相加/所有客户数,假如平均值=100天,客户最后一次交易日期距今天大于等于100天的积分为0,小于100天的积分为1；
 * F：客户一年内下单次数,取所有客户一年内下单次数相加/所有客户数,假如平均值=10次,客户最近一年下单次数大于等于10次的积分为1,小于10次的积分为0；
 * M：客户一年内订单累计金额,取所有客户一年内订单累计金额相加/所有客户数,假如平均值=1000元,客户最近一年累计订单金额大于等于1000元的积分为1,小于1000元的积分为0
 * 客户划分8个组
 * 重要价值客户：R=1,F=1,M=1
 * 重要唤回客户：R=0,F=1,M=1
 * 重要深耕客户：R=1,F=0,M=1
 * 重要挽留客户：R=0,F=0,M=1
 * 潜力客户：R=1,F=1,M=0
 * 新客户：R=1,F=0,M=0
 * 一般维持客户：R=0,F=1,M=0
 * 流失客户：R=0,F=0,M=0
 *
 * @author bang.tang
 */
@AllArgsConstructor
@Getter
public enum MemberGroupTypesEnum implements BaseEnum {
    /**
     * 计算日期：一年内,已完成支付的订单
     * R：客户最后一次交易日期距离当前天数,取所有客户最后一次交易日期距离当前天数相加/所有客户数,假如平均值=100天,客户最后一次交易日期距今天大于等于100天的积分为0,小于100天的积分为1；
     * F：客户一年内下单次数,取所有客户一年内下单次数相加/所有客户数,假如平均值=10次,客户最近一年下单次数大于等于10次的积分为1,小于10次的积分为0；
     * M：客户一年内订单累计金额,取所有客户一年内订单累计金额相加/所有客户数,假如平均值=1000元,客户最近一年累计订单金额大于等于1000元的积分为1,小于1000元的积分为0
     */
    RFM_1(0, "重要价值客户", "R=1,F=1,M=1", true),
    RFM_2(1, "重要唤回客户", "R=0,F=1,M=1", true),
    RFM_3(2, "重要深耕客户", "R=1,F=0,M=1", true),
    RFM_4(3, "重要挽留客户", "R=0,F=0,M=1", true),
    RFM_5(4, "潜力客户", "R=1,F=1,M=0", true),
    RFM_6(5, "新客户", "R=1,F=0,M=0", true),
    RFM_7(6, "一般维持客户", "R=0,F=1,M=0", true),
    RFM_8(7, "流失客户", "R=0,F=0,M=0", true),
    CONDITION(8, "自定义规则分组", "", false),
    ;

    public static class Converter extends BaseConvertEnum<MemberGroupTypesEnum> {
    }

    private Integer code;
    private String description;
    private String rule;
    private boolean frm;
}

