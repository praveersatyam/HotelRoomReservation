package com.hotel.util;

import com.hotel.enums.DayOfWeekEnum;

import java.util.ArrayList;
import java.util.List;

public class DataParser {
    public static List<DayOfWeekEnum> getListOfDateByInputStringList(List<String> inputStringList) {
        List<DayOfWeekEnum> dayList = new ArrayList<>();
        for (String temp : inputStringList) {
            temp = temp.substring(temp.indexOf('(') + 1, temp.indexOf(')'));
            temp = temp.toUpperCase();
            dayList.add(DayOfWeekEnum.getEnumByValue(temp));
        }
        return dayList;
    }
}
