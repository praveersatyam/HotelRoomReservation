package com.hotel.util;

import com.hotel.entity.Booking;
import com.hotel.entity.Hotel;
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
        return hotel;
    }
}
