package org.example.Repo;

import org.example.Model.Booking;

import java.util.HashMap;
import java.util.Map;

public class BookingRepository {

    private Map<String, Booking> bookingMap = new HashMap<>();

    public void save(Booking booking){
        String id = booking.getBookingId();
        bookingMap.put(id,booking);
    }

    public Booking getBookingById(String id){
        return bookingMap.getOrDefault(id,null);
    }


}
