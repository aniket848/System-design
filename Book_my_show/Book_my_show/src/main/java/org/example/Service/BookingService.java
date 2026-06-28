package org.example.Service;

import org.example.Enum.PaymentType;
import org.example.Enum.Status;
import org.example.Factory.PaymentFactory;
import org.example.Model.*;
import org.example.Repo.BookingRepository;
import org.example.Strategy.Lock.InMemoryLockStrategy;
import org.example.Strategy.Lock.LockStrategy;
import org.example.Strategy.Payment.PaymentStrategy;

import java.util.List;
import java.util.UUID;

public class BookingService {


    private BookingRepository bookingRepository = new BookingRepository();
    private LockStrategy lock = new InMemoryLockStrategy();
    private static final Long TTL = 5000L;

    public String createBooking(User user, Theatre theatre, Show show,
                              Screen screen, List<String> seatIds){

        String bookingId = UUID.randomUUID().toString();

        // check whether the seat is free or not
        for(Seat seat:screen.getSeats()){
            if(seatIds.contains(seat.getSeatId())){
                String key = show.getId()+":"+seat.getSeatId();
                if(!lock.TryLock(key, user.getUserId(),TTL)){
                    System.out.println("ERROR OCCURRED! Can't able to select all seats selected, Pls select seats again");
                    return null;
                }
            }
        }//for

        Double total=0.0;
        for(Seat seat:screen.getSeats()){
            if(seatIds.contains(seat.getSeatId())){
                total+= seat.getPrice();
            }
        }

        Booking booking = new Booking(bookingId, user.getUserId(), show.getId(), seatIds, total,
                null,Status.NEW, theatre.getId(), screen.getId());

        bookingRepository.save(booking);
        System.out.println("Booking created successfully for user =>"+ user.getName() + ", Please confirm it while paying amount :"+total);
        return bookingId;
    }


    public void confirmBooking(String bookingId, PaymentType paymentType){

        Booking booking = bookingRepository.getBookingById(bookingId);

        if(booking==null){
            //System.out.println("Booking not found "+bookingId);
            throw new Error("Booking not found "+bookingId);
        }

        for(String seatId:booking.getSeatId()){
            String key = booking.getShowId()+":"+seatId;
            if(lock.isExpired(key) || !lock.isLockedBy(key, booking.getUserId())){
                System.out.println("ERROR OCCURRED! Seats are acquired by any other user as you take too much time, Please select " +
                        "seats again");
                return;
            }
        }

        PaymentStrategy payment = PaymentFactory.createPayment(paymentType);

        booking.setPaymentType(paymentType);
        payment.pay(booking.getTotalAmount());
        booking.setStatus(Status.COMPLETED);

        for(String seatId:booking.getSeatId()){
            String key = booking.getShowId()+":"+seatId;
            lock.unlock(key);
        }

        System.out.println("Booking confirmed successfully of amount: "+booking.getTotalAmount() + ".Done by userId :"+booking.getUserId());
    }
}
