package org.example.Service;

import org.example.Enum.CarType;
import org.example.Model.Booking;
import org.example.Model.Branch;
import org.example.Model.User;
import org.example.Model.Vechicle;
import org.example.Repo.BookingRepo;
import org.example.Strategy.BookingStrategy.BookStrategy;
import org.example.Strategy.FareCalculation.CalculateFare;
import org.example.Strategy.Payment.PaymentStrategy;

public class BookingService {

    private BookingRepo bookingRepo;
   // private BranchService branchService;

    public BookingService(BookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;
        //this.branchService = branchService;
    }

    public String createBooking(String bookingId,User user , Branch source, Branch destination,
                                CarType type, int start, int end, int totaltime, BookStrategy bookStrategy, CalculateFare calculateFare) {


        Vechicle v = bookStrategy.getVechicle(type, source);
        if(v== null){
            System.out.println("ERROR!!!");
            System.out.println("Booking failed, no available vehicle of type: " + type + " in source branch: " + source.getBranchName() + " for user :"+ user.getName());
            return null;
        }

        Double totalPrice = calculateFare.calculateFare(v, start, end , totaltime);

        Booking booking = new Booking(
                bookingId,
                v,
                totalPrice,
                source,
                destination,
                type,
                start,
                end,
                totaltime,
                user
        );

        bookingRepo.addBooking(booking);
        System.out.println("Booking successful, booking id: " + booking.getBookingId());
        System.out.println(booking);
        return booking.getBookingId();

    }


    public void confirmBooking(String bookingId, PaymentStrategy paymentStrategy) {
        Booking booking = bookingRepo.getBooking(bookingId);

        paymentStrategy.pay(booking.getTotalPrice());
        System.out.println("Payment successful for booking id: " + booking.getBookingId() + ", total price: " + booking.getTotalPrice());
    }

}
