package com.hotel.util;

import java.util.ArrayList;
import java.util.List;

public class DataParser {
    public static List<String> getListOfDateByInputStringList(List<String> inputStringList) {
        List<String> dayList = new ArrayList<>();
        for (String temp : inputStringList) {
            temp = temp.substring(temp.indexOf('(') + 1, temp.indexOf(')'));
            temp = temp.toUpperCase();
            if (temp.equals("MON"))
                temp += "DAY";
            if (temp.equals("TUES"))
                temp += "DAY";
            if (temp.equals("WED"))
                temp += "NESDAY";
            if (temp.equals("THUR"))
                temp += "SDAY";
            if (temp.equals("FRI"))
                temp += "DAY";
            if (temp.equals("SAT"))
                temp += "URDAY";
            if (temp.equals("SUN"))
                temp += "DAY";
            dayList.add(temp);
        }
        return dayList;
    }
}
