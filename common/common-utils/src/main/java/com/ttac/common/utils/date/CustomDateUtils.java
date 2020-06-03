//package com.ttac.common.utils.date;
//
//
//import com.google.common.collect.Lists;
//import com.ttac.entity.base.enums.date.YearMouthDayEnum;
//import com.ttac.entity.base.vo.date.DateRangeVo;
//import org.springframework.util.Assert;
//
//import java.time.*;
//import java.time.temporal.WeekFields;
//import java.util.LinkedHashMap;
//import java.util.List;
//
///**
// * introduce：自定义日期工具类
// *
// * @date: 2018/11/27
// * @author: bang.tang
// * @time: 9:32
// */
//public class CustomDateUtils {
//
//    /**
//     * 根据时间范围,以给定标准截取时间段
//     * @param startDate
//     * @param endDate
//     * @return
//     */
//    public static DateRangeVo getDateByDateRange(Long startDate, Long endDate){
//        boolean nullFlag = !(null == startDate || null == endDate);
//        Assert.isTrue(nullFlag,"开始时间或结束时间不能为空!");
//        Instant startInstant = Instant.ofEpochMilli(startDate);
//        Instant endInstant = Instant.ofEpochMilli(endDate);
//        // 获取系统默认时区
//        ZoneId zoneId = ZoneId.systemDefault();
//        LocalDate startLocalDate = LocalDateTime.ofInstant(startInstant, zoneId).toLocalDate();
//        LocalDate endLocalDate = LocalDateTime.ofInstant(endInstant, zoneId).toLocalDate();
//        List<String> dateList = Lists.newArrayList();
//        LinkedHashMap<String, Object> map = new LinkedHashMap<>() ;
//
//        // 获取时间段内相隔天数
//        long rangeDays = endLocalDate.toEpochDay() - startLocalDate.toEpochDay();
//        YearMouthDayEnum yearMouthDayEnum = YearMouthDayEnum.getYearMouthDayEnumTypeByDays(rangeDays);
//        // 开始时间是否超过结束时间
//        boolean flag = endLocalDate.isAfter(startLocalDate);
//        // 周时间段
//        List<String> weekDateList = Lists.newArrayList();
//        switch (yearMouthDayEnum) {
//            case YEAR:
//                // 第一个日期
//                dateList.add(String.valueOf(startLocalDate.getYear()));
//                map.put(String.valueOf(startLocalDate.getYear()), 0);
//                while (flag){
//                    startLocalDate = startLocalDate.plusYears(1);
//                    flag = endLocalDate.isAfter(startLocalDate);
//                    if (flag){
//                        dateList.add(String.valueOf(startLocalDate.getYear()));
//                        map.put(String.valueOf(startLocalDate.getYear()), 0);
//                    }else {
//                        dateList.add(String.valueOf(endLocalDate.getYear()));
//                        map.put(String.valueOf(endLocalDate.getYear()), 0);
//                    }
//                }
//                break;
//            case MOUTH:
//                // 第一个日期
//                dateList.add(new StringBuilder().append(startLocalDate.getYear()).append("-").append(startLocalDate.getMonthValue()).toString());
//                map.put(new StringBuilder().append(startLocalDate.getYear()).append(startLocalDate.getMonthValue()).toString(), 0);
//                while (flag){
//                    startLocalDate = startLocalDate.plusMonths(1);
//                    flag = endLocalDate.isAfter(startLocalDate);
//                    if (flag){
//                        int year = startLocalDate.getYear();
//                        int month = startLocalDate.getMonthValue();
//                        dateList.add(new StringBuilder().append(year).append("-").append(month).toString());
//                        map.put(new StringBuilder().append(year).append(month).toString(), 0);
//                    }else {
//                        int endYear = endLocalDate.getYear();
//                        int endMonth = endLocalDate.getMonthValue();
//                        dateList.add(new StringBuilder().append(endYear).append("-").append(endMonth).toString());
//                        map.put(new StringBuilder().append(endYear).append(endMonth).toString(), 0);
//                    }
//                }
//                break;
//            case WEEK:
//                WeekFields weekFields = WeekFields.ISO;
//                int firstWeek = startLocalDate.get(weekFields.weekOfWeekBasedYear());
//                // 第一个日期
//                dateList.add(new StringBuilder().append(startLocalDate.getYear()).append("年:第").append(firstWeek).append("周").toString());
//                map.put(new StringBuilder().append(startLocalDate.getYear()).append(firstWeek).toString(), 0);
//                while (flag){
//                    startLocalDate = startLocalDate.plusWeeks(1);
//                    flag = endLocalDate.isAfter(startLocalDate);
//                    int week = startLocalDate.get(weekFields.weekOfWeekBasedYear());
//                    int endWeek = endLocalDate.get(weekFields.weekOfWeekBasedYear());
//                    if (flag){
//                        dateList.add(new StringBuilder().append(startLocalDate.getYear()).append("年:第").append(week).append("周").toString());
//                        // 提供默认值为0
//                        map.put(new StringBuilder().append(startLocalDate.getYear()).append(week).toString(), 0);
//                    }else if (week < endWeek){
//                        dateList.add(new StringBuilder().append(endLocalDate.getYear()).append("年:第").append(week).append("周").toString());
//                        map.put(new StringBuilder().append(endLocalDate.getYear()).append(week).toString(), 0);
//                    }
//                }
//                break;
//            case DAY:
//                // 第一个日期
//                dateList.add(String.valueOf(startLocalDate.toString()));
//                map.put(startLocalDate.toString(), 0);
//                while (flag){
//                    startLocalDate = startLocalDate.plusDays(1);
//                    flag = endLocalDate.isAfter(startLocalDate);
//                    String date = true == flag ? startLocalDate.toString() : endLocalDate.toString();
//                    dateList.add(date);
//                    map.put(date, 0);
//                }
//                break;
//            default: break;
//        }
//        return DateRangeVo.builder().dateList(dateList).yearMouthDay(yearMouthDayEnum).map(map).build();
//    }
//
//    /**
//     * 获取当前时间所属年份的周数
//     * @return
//     */
//    public static int getNowWeek(){
//        LocalDate now = LocalDate.now();
//        WeekFields weekFields = WeekFields.ISO;
//        int firstWeek = now.get(weekFields.weekOfWeekBasedYear());
//        return Integer.valueOf(new StringBuilder().append(now.getYear()).append(firstWeek).toString());
//    }
//
//    /**
//     * 指定时间戳时间范围内返回时间枚举
//     * @param start
//     * @param end
//     * @return
//     */
//    public static YearMouthDayEnum getYearMouthDayEnum(Long start, Long end){
//        Assert.notNull(start, "开始时间的时间戳不能为空!");
//        Assert.notNull(end, "结束时间的时间戳不能为空!");
//        Instant startInstant = Instant.ofEpochMilli(start);
//        Instant endInstant = Instant.ofEpochMilli(end);
//        // 获取系统默认时区
//        ZoneId zoneId = ZoneId.systemDefault();
//        LocalDate startLocalDate = LocalDateTime.ofInstant(startInstant, zoneId).toLocalDate();
//        LocalDate endLocalDate = LocalDateTime.ofInstant(endInstant, zoneId).toLocalDate();
//
//        // 获取时间段内相隔天数
//        long rangeDays = endLocalDate.toEpochDay() - startLocalDate.toEpochDay();
//        return YearMouthDayEnum.getYearMouthDayEnumTypeByDays(rangeDays);
//    }
//
//    /**
//     * 根据date日期获取当前时间所属年月(2018-10)
//     * @param date
//     * @return
//     */
//    public static String getYearMouthByDate(java.sql.Date date){
//        if (null != date){
//            LocalDate localDate = date.toLocalDate();
//            return new StringBuilder().append(localDate.getYear()).append("-").append(localDate.getMonthValue()).toString();
//        }
//        return null;
//    }
//    /**
//     * 根据date日期获取当前时间所属年 周
//     * @param date
//     * @return
//     */
//    public static String getYearWeekByDate(java.sql.Date date){
//        LocalDate source = date.toLocalDate();
//        WeekFields weekFields = WeekFields.ISO;
//        int week = source.get(weekFields.weekOfWeekBasedYear());
//        return new StringBuilder().append(source.getYear()).append("年:第").append(week).append("周").toString();
//    }
//
//    /**
//     * LocalDateTime 获取 时间戳
//     * @param localDateTime
//     * @return
//     */
//    public static Long getMillisByLocalDateTime(LocalDateTime localDateTime){
//        return localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
//    }
//    /**
//     * LocalDate 获取 时间戳
//     * @param localDate
//     * @return
//     */
//    public static Long getMillisByLocalDate(LocalDate localDate){
//        return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
//    }
//
//    /**
//     * 根据时间戳获取 LocalDate类型 当前时间，
//     * @param times
//     * @return
//     */
//    public static LocalDate getLocalDateByLongTime(Long times){
//        Instant instant = Instant.ofEpochMilli(times);
//        // 获取系统默认时区
//        ZoneId zoneId = ZoneId.systemDefault();
//        LocalDate localDate = LocalDateTime.ofInstant(instant, zoneId).toLocalDate();
//        return localDate;
//    }
//    /**
//     * 根据时间戳获取 LocalDateTime类型 当前时间，
//     * @param timestamp
//     * @return
//     */
//    public static LocalDateTime getLocalDateTimeByLongTime(Long timestamp){
//        LocalDateTime localDateTime = Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDateTime();
//        return localDateTime;
////        Instant instant = Instant.ofEpochMilli(times);
////        // 获取系统默认时区
////        ZoneId zoneId = ZoneId.systemDefault();
////        LocalDate localDate = LocalDateTime.ofInstant(instant, zoneId).toLocalDate();
////        return localDate;
//    }
//
//
//}
