package com.hotel.service;

import com.hotel.constants.Constants;
import com.hotel.entity.Hotel;
import com.hotel.enums.DayOfWeekEnum;

import java.util.List;

public class HotelFinder {
    public String findBestHotelAvailableByDate(List<Hotel> hotelList, List<DayOfWeekEnum> dayOfWeekList, String customerType) {
        Double cost = 0.0, resultSum = Double.MAX_VALUE;
        Integer resultRating = Integer.MAX_VALUE;
        String resultHotelName = "";
        for (Hotel hotel : hotelList) {
            cost = findCostForHotelByDayList(dayOfWeekList, customerType, hotel);
            if (resultSum >= cost) {
                if (resultSum == cost) {
                    if (hotel.getRating() < resultRating) {
                        resultHotelName = hotel.getName();
                        resultRating = hotel.getRating();
                    }
                } else {
                    resultHotelName = hotel.getName();
                    resultSum = cost;
                    resultRating = hotel.getRating();
                }
            }

        }
        return resultHotelName;
    }

    private Double findCostForHotelByDayList(List<DayOfWeekEnum> dayOfWeekList, String customerType, Hotel hotel) {
            Double cost=0.0;
        for (DayOfWeekEnum dayOfWeek : dayOfWeekList) {
            if (customerType.equals(Constants.REGULAR_CUSTOMER)) {
                if (DayOfWeekEnum.SATURDAY == dayOfWeek || DayOfWeekEnum.SUNDAY == dayOfWeek) {
                    cost += hotel.getRates().getRegularWeekend();
                } else {
                    cost += hotel.getRates().getRegularWeekDays();
                }
            } else {
                if (DayOfWeekEnum.SATURDAY == dayOfWeek || DayOfWeekEnum.SUNDAY == dayOfWeek) {
                    cost += hotel.getRates().getRewardsWeekend();
                } else {
                    cost += hotel.getRates().getRewardsWeekDays();
                }
            }
        }
        return cost;
    }
}
