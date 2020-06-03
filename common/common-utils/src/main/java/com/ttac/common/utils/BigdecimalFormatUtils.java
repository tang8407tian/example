package com.ttac.common.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * description: Bigdecimal工具类
 *
 * @author bang.tang
 * @date 2019/12/25--14:43
 */
public class BigdecimalFormatUtils {


    public static String formatePrice(BigDecimal bigDecimal){
        DecimalFormat df = new DecimalFormat("0.00");
        String format = df.format(bigDecimal);
        return format;
    }
}
