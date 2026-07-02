package org.example.Repo;

import org.example.Model.Booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookingRepo {

    private HashMap<String, Booking> bookingList = new HashMap<>();

    public Booking getBooking(String id){
        return bookingList.get(id);
    }

    public void saveBooking(Booking booking){
        bookingList.put(booking.getBookingId(),booking);
    }

    public void removeBooking(Booking booking){
        bookingList.remove(booking.getBookingId());
    }

    public List<Booking> getAllBookingByDoctor(String doctorId){
        List<Booking> bookings = new ArrayList<>();

        for(Booking booking : bookingList.values()){
            //System.out.println("booking.getDoctorId() = " + booking.getDoctorId());
            if(booking.getDoctorId().equals(doctorId)){
                bookings.add(booking);
            }
        }
        return bookings;
    }
}
