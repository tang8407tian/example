package com.ttac.test.api;

import lombok.extern.slf4j.Slf4j;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ValueRange;
import java.time.temporal.WeekFields;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * introduce：线程
 *
 * @date: 2018/11/24
 * @author: bang.tang
 * @time: 11:40
 */
@Slf4j
public class ThreadTest {



    public void threadDemo(){
        Thread thread = new Thread();

    }


    public void Thread(){

    }


    public static void main(String[] args){
//        String number = "9988779.00000";
//        Long valueOf = Long.valueOf(number);
//        long parseLong = Long.parseLong(number);
//        log.info("{}-{}","valueOf", valueOf);
//        log.info("{}-{}","parseLong", parseLong);
        dateLocal(1541865600000L, 1543218681000L);


    }


    public static void dateLocal(Long startDate, Long endDate){
        Instant instants = Instant.ofEpochMilli(startDate);
        log.info("instant:{}", instants);
        ZoneId zoneId = ZoneId.systemDefault();
        log.info("zoneId:{}", zoneId);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instants, zoneId);
        int dayOfMonth = localDateTime.getDayOfMonth();
        int dayOfYear = localDateTime.getDayOfYear();
        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        LocalDate localDate = localDateTime.toLocalDate();
        ValueRange range = localDate.range(ChronoField.DAY_OF_YEAR);
        int year = localDate.getYear();
        Month month = localDate.getMonth();
        int monthValue = localDate.getMonthValue();
        int dayOfMonth1 = localDate.getDayOfMonth();
        int dayOfYear1 = localDate.getDayOfYear();
        WeekFields weekFields = WeekFields.ISO;
        int i = localDate.get(weekFields.weekOfWeekBasedYear());
        log.info("localDate:{}", localDate);
        log.info("localDateTime:{}", localDateTime);
    }





}
