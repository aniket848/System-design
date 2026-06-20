package org.example;

import org.example.Enum.Usertier;
import org.example.model.User;
import org.example.service.RateLimiterService;

import java.sql.SQLOutput;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        RateLimiterService rateLimiterService = new RateLimiterService();

        User freeUser = new User("1","Aniket", Usertier.FREE);
        User premiumUser = new User("2","Harsh", Usertier.PREMIUM);

//        System.out.println("Testing for FREE user:");
//        // for free user -> 10 req in 60 sec
//        for(int i=0;i<15;i++){
//            try{
//                boolean res = rateLimiterService.executeRequest(freeUser);
//                String status = res?"Accepted":"Denied";
//                System.out.println("Request " + (i+1) + " for free user: " + status);
//                Thread.sleep(100); // sleep for .1 seconds between requests
//            }
//            catch(Exception e){
//                System.out.println("Request denied for free user at attempt " + (i+1));
//            }
//        }


        System.out.println("Testing for PREMIUM user:");
        // for premium user -> 15 req in 60 sec
        for(int i=0;i<20;i++){
            try{
                boolean res = rateLimiterService.executeRequest(premiumUser);
                String status = res?"Accepted":"Denied";
                System.out.println("Request " + (i+1) + " for premium user: " + status);
                Thread.sleep(100); // sleep for .1 seconds between requests
            }
            catch(Exception e){
                System.out.println("Request denied for free user at attempt " + (i+1));
            }
        }

        //checkConCurrency(rateLimiterService,freeUser);
    }


    static void checkConCurrency(RateLimiterService rateLimiterService, User user) throws InterruptedException {
        System.out.println("Testing concurrent requests for FREE user:");
        //User freeUser = new User("1","Aniket", Usertier.FREE);
        //RateLimiterService rateLimiterService = new RateLimiterService();

        int threads = 20;
        ExecutorService executorService = Executors.newFixedThreadPool(threads);

        CyclicBarrier barrier = new CyclicBarrier(threads);
        CountDownLatch latch = new CountDownLatch(threads);

        for(int i=0;i < threads; i++){
            final int requestNumber = i+1;

            executorService.submit(()->{
                try{
                    barrier.await(); // Wait for all threads to be ready
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }

                // when all threads are ready to execute simultaneously, then will use rateLimiterService;
                boolean isAllowed = rateLimiterService.executeRequest(user);

                String status = isAllowed?"Accepted":"Denied";
                System.out.println("Thread Number : "+Thread.currentThread().getName() + " Request " + requestNumber + " for free user: " + status);
                latch.countDown();
            });

        }//i

        latch.await(); // Wait for all threads to finish
        executorService.shutdown();

    }
}