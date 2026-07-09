package org.example.Model;

import org.example.Enum.CarType;

public class Booking {

    private String bookingId;
    private Vechicle vechicle;
    private Double totalPrice;
    private Branch sourceBranch;
    private Branch destinationBranch;
    private CarType  carType;
    private int start;
    private int end;
    private int totalTime;
    private User user;

    public Booking(String bookingId, Vechicle vechicle, Double totalPrice, Branch sourceBranch, Branch destinationBranch, CarType carType, int start, int end, int totalTime, User user) {
        this.bookingId = bookingId;
        this.vechicle = vechicle;
        this.totalPrice = totalPrice;
        this.sourceBranch = sourceBranch;
        this.destinationBranch = destinationBranch;
        this.carType = carType;
        this.user = user;
        this.start = start;
        this.end = end;
        this.totalTime = totalTime;
    }

    public String getBookingId() {
        return bookingId;
    }

    public Vechicle getVechicle() {
        return vechicle;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Branch getSourceBranch() {
        return sourceBranch;
    }

    public Branch getDestinationBranch() {
        return destinationBranch;
    }

    public CarType getCarType() {
        return carType;
    }

    public User getUser() {
        return user;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getTotalTime() {
        return totalTime;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", vechicle=" + vechicle +
                ", totalPrice=" + totalPrice +
                ", sourceBranch=" + sourceBranch +
                ", destinationBranch=" + destinationBranch +
                ", carType=" + carType +
                ", start=" + start +
                ", end=" + end +
                ", totalTime=" + totalTime +
                ", user=" + user +
                '}';
    }
}
