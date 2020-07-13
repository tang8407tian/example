package com.ttac.servicesimpledemo.util;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * introduce：时间格式化工具类型
 *
 * @date: 2018/7/20
 * @author: bang.tang
 * @time: 10:19
 */
public class DateFormatUtils {

    /**
     * Timestamp时间格式化
     * @param timestamp
     * @return
     */
    public static String dataTime(Timestamp timestamp){
        if (null == timestamp){
            return "";
        }
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        return dataTime(localDateTime);
    }

    /**
     * dateTime时间格式化
     * @param dateTime
     * @return
     */
    public static String dataTime(LocalDateTime dateTime){
        if (null == dateTime){
            return "";
        }
        String format = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return format;
    }

    public static String getYearAndMouth(LocalDate localDate){
        if (null != localDate){
            String format = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM"));
            return format;
        }
        return null;

    }

    public static String localDateTimeFormatter(LocalDateTime dateTime, String pattren){
        if (null == dateTime){
            return "";
        }
        if (StringUtils.isBlank(pattren)){
            return null;
        }
        String format = dateTime.format(DateTimeFormatter.ofPattern(pattren));
        return format;
    }

    /**
     * dateTime时间格式化
     * @param time
     * @return
     */
    public static LocalDateTime stringTimeToLocalDateTime(String time){
        if (StringUtils.isNotBlank(time)){
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(time, formatter);
        return localDateTime;
    }



    /**
     *
     * @param data
     * @return
     */
    public static Timestamp stringFormatTimestamp(String data){
        if (StringUtils.isBlank(data)){
            return null;
        }
        return Timestamp.valueOf(data);
    }
}
