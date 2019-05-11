package com.hotel.enums;

public enum DayOfWeekEnum {
    MONDAY("Mon","Monday"), TUESDAY("Tues","Tuesday"), WEDNESDAY("Wed","Wednesday"), THURSDAY("Thur","Thursday"), FRIDAY("Fri","Friday"), SATURDAY("Sat","Saturday"), SUNDAY("Sun","Sunday");

    private String minValue;

    private String fullValue;

    DayOfWeekEnum(String value1, String value2) {
        this.minValue = value1;
        this.fullValue = value2;
    }

    public String getMinValue() {
        return minValue;
    }

    public String getFullValue() {
        return fullValue;
    }

    public static DayOfWeekEnum getEnumByValue(String value) {
        for (DayOfWeekEnum enm : DayOfWeekEnum.values()) {
            if (value.equalsIgnoreCase(enm.getMinValue())||value.equalsIgnoreCase(enm.getFullValue())) {
                return enm;
            }
        }
        return null;
    }
}
