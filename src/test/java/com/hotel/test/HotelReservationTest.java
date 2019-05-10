package com.hotel.test;

import com.hotel.entity.Hotel;
import com.hotel.util.DataInitializer;
import com.hotel.service.HotelFinder;
import com.hotel.util.DataParser;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HotelReservationTest {

    @Test
    public void findRoomsByHotelAndDateTest01(){
        List<Hotel> hotelList = new ArrayList<>();
        List<String> dayList = new ArrayList<>();
        Hotel Lakewood = DataInitializer.setHotelDetails("Lakewood",3);
        Hotel Bridgewood = DataInitializer.setHotelDetails("Bridgewood",4);
        Hotel Ridgewood = DataInitializer.setHotelDetails("Ridgewood",5);
        hotelList.add(Lakewood);
        hotelList.add(Bridgewood);
        hotelList.add(Ridgewood);
        String date1 = "16Mar2009(mon)";
        String date2 = "17Mar2009(tues)";
        String date3 = "18Mar2009(wed)";
        dayList.add(date1);
        dayList.add(date2);
        dayList.add(date3);
        dayList = DataParser.getListOfDateByInputStringList(dayList);
        HotelFinder hotelFinder = new HotelFinder();
        String result = hotelFinder.findBestHotelAvailableByDate(hotelList, dayList, "Regular");
        assertEquals("Lakewood", result);
    }

    @Test
    public void findRoomsByHotelAndDateTest02(){
        List<Hotel> hotelList = new ArrayList<>();
        List<String> dayList = new ArrayList<>();
        Hotel Lakewood = DataInitializer.setHotelDetails("Lakewood",3);
        Hotel Bridgewood = DataInitializer.setHotelDetails("Bridgewood",4);
        Hotel Ridgewood = DataInitializer.setHotelDetails("Ridgewood",5);
        hotelList.add(Lakewood);
        hotelList.add(Bridgewood);
        hotelList.add(Ridgewood);
        String date1 = "20Mar2009(fri)";
        String date2 = "21Mar2009(sat)";
        String date3 = "22Mar2009(sun)";
        dayList.add(date1);
        dayList.add(date2);
        dayList.add(date3);
        dayList = DataParser.getListOfDateByInputStringList(dayList);
        HotelFinder hotelFinder = new HotelFinder();
        String result = hotelFinder.findBestHotelAvailableByDate(hotelList, dayList, "Regular");
        assertEquals("Bridgewood", result);
    }

    @Test
    public void findRoomsByHotelAndDateTest03(){
        List<Hotel> hotelList = new ArrayList<>();
        List<String> dayList = new ArrayList<>();
        Hotel Lakewood = DataInitializer.setHotelDetails("Lakewood",3);
        Hotel Bridgewood = DataInitializer.setHotelDetails("Bridgewood",4);
        Hotel Ridgewood = DataInitializer.setHotelDetails("Ridgewood",5);
        hotelList.add(Lakewood);
        hotelList.add(Bridgewood);
        hotelList.add(Ridgewood);
        String date1 = "26Mar2009(thur)";
        String date2 = "27Mar2009(fri)";
        String date3 = "28Mar2009(sat)";
        dayList.add(date1);
        dayList.add(date2);
        dayList.add(date3);
        dayList = DataParser.getListOfDateByInputStringList(dayList);
        HotelFinder hotelFinder = new HotelFinder();
        String result = hotelFinder.findBestHotelAvailableByDate(hotelList, dayList, "Rewards");
        assertEquals("Ridgewood", result);
    }

    @Test
    public void findRoomsByHotelAndDateTestForOptimizedRatingAndCost(){
        List<Hotel> hotelList = new ArrayList<>();
        List<String> dayList = new ArrayList<>();
        Hotel Lakewood = DataInitializer.setHotelDetails("Lakewood",3);
        Hotel Bridgewood = DataInitializer.setHotelDetails("Bridgewood",4);
        hotelList.add(Lakewood);
        hotelList.add(Bridgewood);
        String date1 = "27Mar2009(fri)";
        String date2 = "28Mar2009(sat)";
        dayList.add(date1);
        dayList.add(date2);
        dayList = DataParser.getListOfDateByInputStringList(dayList);
        HotelFinder hotelFinder = new HotelFinder();
        String result = hotelFinder.findBestHotelAvailableByDate(hotelList, dayList, "Rewards");
        assertEquals("Bridgewood", result);
    }

}
