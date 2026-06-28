package org.example.Model;

import org.example.Enum.PaymentType;
import org.example.Enum.SeatType;
import org.example.Enum.Status;

import java.util.List;

public class Booking {

    private String bookingId;
    private String userId;
    private String showId;
    private String theatreId;
    private String screenId;
    private List<String> seatId;
    private Double totalAmount;
    private PaymentType paymentType;
    private Status status;

    public Booking(String bookingId, String userId, String showId, List<String> seatId, Double totalAmount, PaymentType paymentType, Status status,
                   String theatreId, String screenId) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.showId = showId;
        this.seatId = seatId;
        this.totalAmount = totalAmount;
        this.paymentType = paymentType;
        this.status = status;
        this.theatreId = theatreId;
        this.screenId = screenId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public String getShowId() {
        return showId;
    }

    public List<String> getSeatId() {
        return seatId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public Status getStatus() {
        return status;
    }

    public String getTheatreId() {
        return theatreId;
    }

    public String getScreenId() {
        return screenId;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
