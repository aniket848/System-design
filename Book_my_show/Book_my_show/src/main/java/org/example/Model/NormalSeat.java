package org.example.Model;

import org.example.Enum.SeatType;
import org.example.Enum.Status;

public class NormalSeat extends Seat{
    public NormalSeat(String seatId,  Status status) {
        super(seatId,status);
    }

    @Override
    public SeatType getSeatType() {
        return SeatType.NORMAL;
    }

    @Override
    public Double getPrice() {
        return 150.0;
    }
}
