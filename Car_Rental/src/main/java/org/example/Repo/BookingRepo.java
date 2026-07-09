package org.example.Repo;

import org.example.Model.Booking;

import java.util.HashMap;
import java.util.Map;

public class BookingRepo {

    private Map<String, Booking> bookingsList = new HashMap<>();

    public void addBooking(Booking booking) {
        bookingsList.put(booking.getBookingId(),booking);
    }

    public Booking getBooking(String bookingId) {
        return bookingsList.get(bookingId);
    }

}
