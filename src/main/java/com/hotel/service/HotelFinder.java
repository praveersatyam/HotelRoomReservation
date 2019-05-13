package com.hotel.service;

import com.hotel.entity.Hotel;
import com.hotel.enums.DayOfWeekEnum;

import java.util.List;

import static com.hotel.constants.Constants.REGULAR_CUSTOMER;

public class HotelFinder {
    public static Double totalCost, maxTotalCostValueTillNow;
    public static Integer bestRatingTillNow;
    public static String bestHotelName;


    public String findBestHotelAvailableByDate(List<Hotel> hotelList, List<DayOfWeekEnum> dayOfWeekList, String customerType) {
        totalCost = 0.0;
        maxTotalCostValueTillNow = Double.MAX_VALUE;
        bestRatingTillNow = Integer.MIN_VALUE;
        bestHotelName = "";
        for (Hotel hotel : hotelList) {
            totalCost = findCostForHotelByDayList(dayOfWeekList, customerType, hotel);
            if (isMaxAmountTillNowGreaterThanCurrentAmount(totalCost, maxTotalCostValueTillNow)) {
                if (isMaxAmountTillNowEqualToCurrentAmount(totalCost, maxTotalCostValueTillNow)) {
                    if (isCurrentRatingGreater(bestRatingTillNow, hotel)) {
                        updateCheapestHotelCostAndRating(hotel);
                    }
                } else {
                    updateCheapestHotelCostAndRating(hotel);
                }
            }

        }
        return bestHotelName;
    }

    private void updateCheapestHotelCostAndRating(Hotel hotel) {
        bestHotelName = hotel.getName();
        maxTotalCostValueTillNow = totalCost;
        bestRatingTillNow = hotel.getRating();
    }

    private boolean isCurrentRatingGreater(Integer bestRatingTillNow, Hotel hotel) {
        return hotel.getRating() > bestRatingTillNow;
    }

    private boolean isMaxAmountTillNowEqualToCurrentAmount(Double totalCost, Double maxTotalCostValueTillNow) {
        return maxTotalCostValueTillNow == totalCost;
    }

    private boolean isMaxAmountTillNowGreaterThanCurrentAmount(Double totalCost, Double maxTotalCostValueTillNow) {
        return maxTotalCostValueTillNow >= totalCost;
    }

    private Double findCostForHotelByDayList(List<DayOfWeekEnum> dayOfWeekList, String customerType, Hotel hotel) {
        Double cost=0.0;
        for (DayOfWeekEnum dayOfWeek : dayOfWeekList) {
            cost = addRatesForCustomer(customerType, hotel, cost, dayOfWeek);
        }
        return cost;
    }

    private Double addRatesForCustomer(String customerType, Hotel hotel, Double cost, DayOfWeekEnum dayOfWeek) {
        if (customerType.equals(REGULAR_CUSTOMER)) {
            cost = addRatesForRegularCustomer(hotel, cost, dayOfWeek);
        } else {
            cost = addRatesForRewardsCustomer(hotel, cost, dayOfWeek);
        }
        return cost;
    }

    private Double addRatesForRewardsCustomer(Hotel hotel, Double cost, DayOfWeekEnum dayOfWeek) {
        if (isWeekend(dayOfWeek)) {
            cost += hotel.getRates().getRewardsWeekend();
        } else {
            cost += hotel.getRates().getRewardsWeekDays();
        }
        return cost;
    }

    private Double addRatesForRegularCustomer(Hotel hotel, Double cost, DayOfWeekEnum dayOfWeek) {
        if (isWeekend(dayOfWeek)) {
            cost += hotel.getRates().getRegularWeekend();
        } else {
            cost += hotel.getRates().getRegularWeekDays();
        }
        return cost;
    }

    private boolean isWeekend(DayOfWeekEnum dayOfWeek) {
        return DayOfWeekEnum.SATURDAY == dayOfWeek || DayOfWeekEnum.SUNDAY == dayOfWeek;
    }
}
