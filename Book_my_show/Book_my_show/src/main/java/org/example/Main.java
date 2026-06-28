package org.example;

import org.example.Enum.PaymentType;
import org.example.Enum.Status;
import org.example.Model.*;
import org.example.Service.BookingService;
import org.example.Service.MovieService;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        BookingService bookingService = new BookingService();
        MovieService movieService = new MovieService();

        Movie movie1 = new Movie("M-101","Hum aapke hai kaun","3.5 hr");
        Movie movie2 = new Movie("M-102","Hum saath saath hai","3.8 hr");
        Movie movie3 = new Movie("M-103","Dhurandhar","4.2 hr");

        movieService.save(movie1);
        movieService.save(movie2);
        movieService.save(movie3);

        Seat seat1= new NormalSeat("1OP", Status.NEW);
        Seat seat2= new NormalSeat("11P", Status.NEW);
        Seat seat3= new ReclinerSeat("1OS", Status.NEW);
        Seat seat4= new NormalSeat("17P", Status.NEW);
        Seat seat5= new ReclinerSeat("18S", Status.NEW);

        Screen screen = new Screen("001","Screen-1", List.of(seat1,seat2,seat3,seat4,seat5));

        Theatre theatre = new Theatre("T-23","Phenoix",List.of(screen));
        Show show = new Show("S-111",movie1,theatre);

        System.out.println("============  FIND MOVIES WITH TITLE 'Hum'=================");
        List<Movie> list = movieService.findByTitle("Hum");
        for (Movie m : list) {
            System.out.println(m);
        }

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("========== CONFIRM BOOKING USE CASE ====================");
        User user1 = new User("U-573","Aniket");

        String bookingId = bookingService.createBooking(user1, theatre,show,screen,
                List.of(seat1.getSeatId(), seat3.getSeatId()));

        bookingService.confirmBooking(bookingId, PaymentType.UPI);

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("============== BOOKING FAILED USE CASE AS OTHER USER ALREADY SELECTED SEATS ============");

        User user2 = new User("U-543","Harsh");
        User user3 = new User("U-546","Aastha");

        String bookingId2 = bookingService.createBooking(user2, theatre,show,screen,
                List.of(seat1.getSeatId()));

        String bookingId3 = bookingService.createBooking(user3, theatre,show,screen,
                List.of(seat1.getSeatId(),seat2.getSeatId()));

        System.out.println();
        System.out.println();
        System.out.println();


        System.out.println("============== BOOKING FAILED USE CASE WHILE DOING PAYMENT AFTER 5 SEC ============");

        String bookingId4 = bookingService.createBooking(user2, theatre,show,screen,
                List.of(seat4.getSeatId(), seat5.getSeatId()));

        Thread.sleep(6000);

        String bookingId5 = bookingService.createBooking(user3, theatre,show,screen,
                List.of(seat4.getSeatId(),seat5.getSeatId()));

        bookingService.confirmBooking(bookingId4, PaymentType.CARD);
        bookingService.confirmBooking(bookingId5, PaymentType.CARD);

    }
}