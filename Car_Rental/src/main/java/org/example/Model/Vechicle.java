package org.example.Model;

import org.example.Enum.CarType;

import java.util.concurrent.atomic.AtomicBoolean;

public class Vechicle {

    private String id;
    private String name;
    private CarType type;
    private Double hourRate;
    private Double perKmRate;
    private String numberPlate;
    private int noOfBookings;
    private Double baseFare;
    private AtomicBoolean isBooked = new AtomicBoolean(false);

    public Vechicle(String id, String name, CarType type, Double hourRate, Double perKmRate, String numberPlate, Double baseFare) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.hourRate = hourRate;
        this.perKmRate = perKmRate;
        this.numberPlate = numberPlate;
        this.noOfBookings = 0;
        this.baseFare = baseFare;
        this.isBooked.set(false);

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CarType getType() {
        return type;
    }

    public Double getHourRate() {
        return hourRate;
    }

    public Double getPerKmRate() {
        return perKmRate;
    }

    public void incrementNoOfBookings() {
        this.noOfBookings += 1;
    }

    public int getNoOfBookings() {
        return noOfBookings;
    }

    public AtomicBoolean getIsBooked() {
        return isBooked;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public Double getBaseFare() {
        return baseFare;
    }
}
