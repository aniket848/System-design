package org.example.Model;

import org.example.Enum.SeatType;
import org.example.Enum.Status;

public class ReclinerSeat extends Seat{
    public ReclinerSeat(String seatId,Status status) {
        super(seatId, status);
    }

    @Override
    public SeatType getSeatType() {
        return SeatType.RECLINER;
    }

    @Override
    public Double getPrice() {
        return 300.0;
    }
}
