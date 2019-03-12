package com.ttac.common.utils;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * introduce：string类型相关操作工具类
 *
 * @date: 2018/6/11
 * @author: fish
 * @time: 11:11
 */
public class CustomStringUtils {

    /**
     * 获取全模糊搜索参数
     * @param param
     * @return
     */
    public static String getLikeParam(String param){
        return new StringBuilder().append("%").append(param).append("%").toString();
    }

    /**
     * 分页参数拼接
     * @param sql
     * @param page
     * @param pageSize
     */
    public static void getPageSearch(StringBuilder sql, Integer page, Integer pageSize){
        page = null != page ? Math.max(page, 1) -1 : 0;
        pageSize  =  null != pageSize ? Math.max(pageSize, 1) : 1;
        sql.append(" limit ").append(page * pageSize).append(",").append(pageSize);
    }



    /**
     * Object转String
     * @param obj
     * @return
     */
    public static String ObjectToString(Object obj) {
        return obj == null ? null : String.valueOf(obj);
    }

    /**
     * object转long
     * @param obj
     * @return
     */
    public static Long ObjectToLong(Object obj) {
        return obj == null ? 0L : Long.parseLong(String.valueOf(obj));
    }

    /**
     * object转 Integer
     * @param obj
     * @return
     */
    public static Integer ObjectToInteger(Object obj) {
        return obj == null ? 0 : Integer.parseInt(String.valueOf(obj));
    }

    /**
     * object转 BigDecimal
     * @param obj
     * @return
     */
    public static BigDecimal ObjectToBigdecimal(Object obj) {
        return obj == null ? new BigDecimal("0") : new BigDecimal(String.valueOf(obj));
    }

    /**
     * Object 转 Timestamp
     * @param obj
     * @return
     */
    public static Timestamp objectToTimestamp(Object obj) {
        return obj == null ? null : (Timestamp) obj;
    }

    /**
     * Object转Date
     * @param obj
     * @return
     */
    public static Date objectToDate(Object obj) {
        return obj == null ? null : (Date) obj;
    }


}
