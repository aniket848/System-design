package org.example.Model;

import org.example.Enum.SeatType;
import org.example.Enum.Status;

public abstract class Seat {

    private String seatId;
    private Status seatStatus;

    public Seat(String seatId, Status status) {
        this.seatId = seatId;
        this.seatStatus = status;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public void setSeatStatus(Status seatStatus) {
        this.seatStatus = seatStatus;
    }

    public String getSeatId() {
        return seatId;
    }

    public Status getSeatStatus() {
        return seatStatus;
    }

    public abstract SeatType getSeatType();

    public abstract Double getPrice();
}
