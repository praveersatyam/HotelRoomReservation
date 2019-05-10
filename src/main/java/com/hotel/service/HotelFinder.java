package com.hotel.service;

import com.hotel.constants.Constants;
import com.hotel.constants.RateConstants;
import com.hotel.entity.Hotel;

import java.time.DayOfWeek;
import java.util.List;

public class HotelFinder {
    public String findBestHotelAvailableByDate(List<Hotel> hotelList, List<String> dayOfWeekList, String customerType){
        Double cost=0.0, resultSum = Double.MAX_VALUE;
        Integer resultRating=Integer.MAX_VALUE;
        String resultHotelName="";
        for (Hotel hotel: hotelList) {
            cost=0.0;
            for (String dayOfWeek: dayOfWeekList) {
                if(customerType.equals(Constants.REGULAR_CUSTOMER)){
                    if (DayOfWeek.SATURDAY.toString().equals(dayOfWeek) || DayOfWeek.SUNDAY.toString().equals(dayOfWeek)) {
                        if(hotel.getName().equals(Constants.LAKEWOOD)){
                            cost+= RateConstants.Weekend.RegularCustomer.LAKE_TARRIF;
                        }
                        if(hotel.getName().equals(Constants.BRIDGEWOOD)){
                            cost+=RateConstants.Weekend.RegularCustomer.BRIDGE_TARRIF;
                        }
                        if(hotel.getName().equals(Constants.RIDGEWOOD)){
                            cost+=RateConstants.Weekend.RegularCustomer.RIDGE_TARRIF;
                        }
                    }
                    else {
                        if(hotel.getName().equals(Constants.LAKEWOOD)){
                            cost+= RateConstants.Weekdays.RegularCustomer.LAKE_TARRIF;
                        }
                        if(hotel.getName().equals(Constants.BRIDGEWOOD)){
                            cost+=RateConstants.Weekdays.RegularCustomer.BRIDGE_TARRIF;
                        }
                        if(hotel.getName().equals(Constants.RIDGEWOOD)){
                            cost+=RateConstants.Weekdays.RegularCustomer.RIDGE_TARRIF;
                        }

                    }
                }
                else {
                    if(DayOfWeek.SATURDAY.toString().equals(dayOfWeek)||DayOfWeek.SUNDAY.equals(dayOfWeek)){
                        if(hotel.getName().equals(Constants.LAKEWOOD)){
                            cost+= RateConstants.Weekend.RewardsCustomer.LAKE_TARRIF;
                        }
                        if(hotel.getName().equals(Constants.BRIDGEWOOD)){
                            cost+= RateConstants.Weekend.RewardsCustomer.BRIDGE_TARRIF;
                        }
                        if(hotel.getName().equals(Constants.RIDGEWOOD)){
                            cost+= RateConstants.Weekend.RewardsCustomer.RIDGE_TARRIF;
                        }
                    }
                    else {
                        if(hotel.getName().equals(Constants.LAKEWOOD)){
                            cost+= RateConstants.Weekdays.RewardsCustomer.LAKE_TARRIF;
                        }
                        if(hotel.getName().equals(Constants.BRIDGEWOOD)){
                            cost+= RateConstants.Weekdays.RewardsCustomer.BRIDGE_TARRIF;
                        }
                        if(hotel.getName().equals(Constants.RIDGEWOOD)){
                            cost+= RateConstants.Weekdays.RewardsCustomer.RIDGE_TARRIF;
                        }
                    }
                }
            }
            if(resultSum>=cost){
                if(resultSum==cost){
                    if(hotel.getRating()<resultRating){
                        resultHotelName=hotel.getName();
                        resultRating=hotel.getRating();
                    }
                }
                else{
                    resultHotelName=hotel.getName();
                    resultSum=cost;
                    resultRating=hotel.getRating();
                }
            }
        }
        return resultHotelName;
    }
}
