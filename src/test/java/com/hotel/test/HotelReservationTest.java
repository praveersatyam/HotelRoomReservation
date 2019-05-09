package com.hotel.test;

import com.hotel.entity.Hotel;
import com.hotel.service.DataInitializer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HotelReservationTest {

    @Test
    public void findRoomsByHotelAndDate(){
        List<Hotel> hotelList = new ArrayList<>();
        Hotel Lakewood = DataInitializer.setHotelDetails("Lakewood",3,10l);
        Hotel Bridgewood = DataInitializer.setHotelDetails("Bridgewood",4,10l);
        Hotel Ridgewood = DataInitializer.setHotelDetails("Ridgewood",5,10l);
        hotelList.add(Lakewood);
        hotelList.add(Bridgewood);
        hotelList.add(Ridgewood);
        assertEquals("Lakewood", null);
    }
}
