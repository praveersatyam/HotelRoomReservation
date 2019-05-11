package com.hotel.util;

import com.hotel.constants.Constants;
import com.hotel.constants.RateConstants;
import com.hotel.entity.Booking;
import com.hotel.entity.Hotel;
import com.hotel.entity.Rates;
import com.hotel.entity.Room;

import java.util.ArrayList;
import java.util.List;

public class DataInitializer {
    public static Hotel setHotelDetails(String hotelName, Integer rating){
        Hotel hotel = new Hotel();
        hotel.setName(hotelName);
        hotel.setRating(rating);
        List<Room> roomList = new ArrayList<>();
        hotel.setRoomList(roomList);
        Rates rates = assignRates(hotel);
        hotel.setRates(rates);
        return hotel;
    }

    public static Rates assignRates(Hotel hotel){
        Rates rates = new Rates();
        if(hotel.getName().equals(Constants.LAKEWOOD)){
            rates.setRegularWeekDays(RateConstants.Weekdays.RegularCustomer.LAKE_TARRIF);
            rates.setRewardsWeekDays(RateConstants.Weekdays.RewardsCustomer.LAKE_TARRIF);
            rates.setRegularWeekend(RateConstants.Weekend.RegularCustomer.LAKE_TARRIF);
            rates.setRewardsWeekend(RateConstants.Weekend.RewardsCustomer.LAKE_TARRIF);
        }
        if(hotel.getName().equals(Constants.BRIDGEWOOD)){
            rates.setRegularWeekDays(RateConstants.Weekdays.RegularCustomer.BRIDGE_TARRIF);
            rates.setRewardsWeekDays(RateConstants.Weekdays.RewardsCustomer.BRIDGE_TARRIF);
            rates.setRegularWeekend(RateConstants.Weekend.RegularCustomer.BRIDGE_TARRIF);
            rates.setRewardsWeekend(RateConstants.Weekend.RewardsCustomer.BRIDGE_TARRIF);
        }
        if(hotel.getName().equals(Constants.RIDGEWOOD)){
            rates.setRegularWeekDays(RateConstants.Weekdays.RegularCustomer.RIDGE_TARRIF);
            rates.setRewardsWeekDays(RateConstants.Weekdays.RewardsCustomer.RIDGE_TARRIF);
            rates.setRegularWeekend(RateConstants.Weekend.RegularCustomer.RIDGE_TARRIF);
            rates.setRewardsWeekend(RateConstants.Weekend.RewardsCustomer.RIDGE_TARRIF);
        }
        return rates;
    }
}
