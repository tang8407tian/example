package com.ttac.entity.base.enums.date;

/**
 * introduce：年月周日
 *
 * @date: 2018/11/26
 * @author: bang.tang
 * @time: 17:40
 */
public enum YearMouthDayEnum {

    /**
     * 年
     */
    YEAR(365),
    /**
     * 月
     */
    MOUTH(30),
    /**
     * 周
     */
    WEEK(7),
    /**
     * 日
     */
    DAY(1);

    private int day;

    YearMouthDayEnum(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }



//--------------------------------------------内部工具方法--------------------------------------------------------------------//
    /**
     * 返回DAY枚举天数范围的最小值
     */
    private static long dayMix = 1;

    /**
     * 返回DAY枚举天数范围的最大值、返回WEEK枚举天数范围的最小值
     */
    private static long dayOrWeek = 15;

    /**
     * 返回WEEK枚举天数范围的最大值、返回MOUTH枚举天数范围的最小值
     */
    private static long weekOrMouth = 105;

    /**
     * 返回MOUTH枚举天数范围的最大值、返回YEAR枚举天数范围的最小值
     */
    private static long mouthOrYear = 405;

    /**
     * 根据输入的天数判断返回的枚举字段
     * @param days
     * @return
     */
    public static YearMouthDayEnum getYearMouthDayEnumTypeByDays(Long days){
        if (days >= dayMix && days <= dayOrWeek){
            return DAY;
        }
        if (days > dayOrWeek && days <= weekOrMouth){
            return WEEK;
        }
        if (days > weekOrMouth && days <= mouthOrYear){
            return MOUTH;
        }
        if (days > mouthOrYear){
            return YEAR;
        }
        return DAY;
    }
}
