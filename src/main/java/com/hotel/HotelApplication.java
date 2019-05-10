package com.hotel;

import com.hotel.entity.Hotel;
import com.hotel.service.HotelFinder;
import com.hotel.util.DataInitializer;
import com.hotel.util.DataParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HotelApplication {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer noOfTestCases = Integer.parseInt(br.readLine());
        while (noOfTestCases-- > 0) {
            String input = br.readLine();
            StringTokenizer stz = new StringTokenizer(input);
            List<Hotel> hotelList = new ArrayList<>();
            List<String> dayList = new ArrayList<>();
            Hotel Lakewood = DataInitializer.setHotelDetails("Lakewood", 3);
            Hotel Bridgewood = DataInitializer.setHotelDetails("Bridgewood", 4);
            Hotel Ridgewood = DataInitializer.setHotelDetails("Ridgewood", 5);
            hotelList.add(Lakewood);
            hotelList.add(Bridgewood);
            hotelList.add(Ridgewood);
            String customerType = "";
            if (stz.hasMoreTokens()) {
                customerType = stz.nextToken().replace(":", "");
                while (stz.hasMoreTokens()) {
                    dayList.add(stz.nextToken().replace(",", ""));
                }
            }
            dayList = DataParser.getListOfDateByInputStringList(dayList);
            HotelFinder hotelFinder = new HotelFinder();
            String result = hotelFinder.findBestHotelAvailableByDate(hotelList, dayList, customerType);
            System.out.println(result);
        }
    }
}
