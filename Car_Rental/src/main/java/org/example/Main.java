package org.example;

import org.example.Enum.CarType;
import org.example.Model.Branch;
import org.example.Model.User;
import org.example.Model.Vechicle;
import org.example.Repo.BookingRepo;
import org.example.Repo.BranchRepo;
import org.example.Service.BookingService;
import org.example.Service.BranchService;
import org.example.Strategy.BookingStrategy.BookStrategy;
import org.example.Strategy.BookingStrategy.CheapBooking;
import org.example.Strategy.FareCalculation.CalculateFare;
import org.example.Strategy.FareCalculation.DistanceBasedFare;
import org.example.Strategy.Payment.CreditCartPayment;
import org.example.Strategy.Payment.PaymentStrategy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        BranchRepo  branchRepo = new BranchRepo();
        BookingRepo bookingRepo = new BookingRepo();

        BookingService  bookingService = new BookingService(bookingRepo);
        BranchService   branchService  = new BranchService(branchRepo, bookingRepo);
        PaymentStrategy paymentStrategy = new CreditCartPayment();
        BookStrategy  bookStrategy = new CheapBooking(branchService);
        CalculateFare calculateFare = new DistanceBasedFare();

        Branch branch1 = new Branch("B1", "Branch 1");
        Branch branch2 = new Branch("B2", "Branch 2");

        branchRepo.addBranch(branch1);
        branchRepo.addBranch(branch2);

        Vechicle v1 = new Vechicle("V1", "Car 1", CarType.SEDAN, 10.0, 5.0, "ABC123", 50.0);
        Vechicle v2 = new Vechicle("V2", "Car 2", CarType.SEDAN, 15.0, 3.5, "ADG165", 59.0);
        Vechicle v3 = new Vechicle("V3", "Car 3", CarType.SCORPIO, 20.0, 4.0, "XYZ789", 70.0);
        Vechicle v4 = new Vechicle("V4", "Car 4", CarType.SEDAN, 12.0, 6.0, "LMN456", 55.0);

        branch1.addVechicle(v1);
        branch1.addVechicle(v2);
        branch1.addVechicle(v3);

        branch2.addVechicle(v4);

        User user1 = new User("U1", "Aniket");
        User user2 = new User("U2", "Harsh");

        String bookingId = bookingService.createBooking("BKG1", user1, branch1, branch2, CarType.SEDAN, 10, 20, 10, bookStrategy,calculateFare);

        if(bookingId != null){
            bookingService.confirmBooking(bookingId, paymentStrategy);
        }

        bookingId = bookingService.createBooking("BKG2", user2, branch2, branch2, CarType.SCORPIO, 10, 20, 10, bookStrategy,calculateFare);

        System.out.println("------------------------ CONCURRENCY -------------------------");

        Thread t1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " :Trying to book a SEDAN from Branch 1");
            String bookingId1 = bookingService.createBooking
                    ("BKG1", user1, branch1, branch2, CarType.SCORPIO,
                            10, 20, 10,
                            bookStrategy,calculateFare);

        });

        Thread t2 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " :Trying to book a SEDAN from Branch 1");
            String bookingId1 = bookingService.createBooking
                    ("BKG1", user2, branch1, branch2, CarType.SCORPIO,
                            10, 20, 10,
                            bookStrategy,calculateFare);

        });


        t1.start();
        t2.start();


    }
}