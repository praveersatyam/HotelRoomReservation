package com.hotel.test;

import com.hotel.entity.Hotel;
import com.hotel.service.DataInitializer;
import com.hotel.service.HotelFinder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HotelReservationTest {

    @Test
    public void findRoomsByHotelAndDate(){
        List<Hotel> hotelList = new ArrayList<>();
        List<String> dayList = new ArrayList<>();
        Hotel Lakewood = DataInitializer.setHotelDetails("Lakewood",3);
        Hotel Bridgewood = DataInitializer.setHotelDetails("Bridgewood",4);
        Hotel Ridgewood = DataInitializer.setHotelDetails("Ridgewood",5);
        hotelList.add(Lakewood);
        hotelList.add(Bridgewood);
        hotelList.add(Ridgewood);
        String day1 = "MONDAY";
        String day2 = "TUESDAY";
        String day3 = "WEDNESDAY";
        dayList.add(day1);
        dayList.add(day2);
        dayList.add(day3);
        HotelFinder hotelFinder = new HotelFinder();
        String result = hotelFinder.findBestHotelAvailableByDate(hotelList, dayList, "Regular");
        assertEquals("Lakewood", result);
    }
}
