package com.ttac.entity.base.vo.date;

import com.ttac.entity.base.enums.date.YearMouthDayEnum;
import lombok.Builder;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * introduce：时间段vo
 *
 * @date: 2018/11/26
 * @author: bang.tang
 * @time: 20:16
 */
@Data
@Builder
public class DateRangeVo {

    /**
     * 时间段集合
     */
    private List<String> dateList;

    /**
     * 时间-属性
     */
    private LinkedHashMap<String, Object> map;

    /**
     * 所属年月周日
     */
    private YearMouthDayEnum yearMouthDay;
}
