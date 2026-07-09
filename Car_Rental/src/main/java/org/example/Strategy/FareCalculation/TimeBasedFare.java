package org.example.Strategy.FareCalculation;

import org.example.Model.Vechicle;

public class TimeBasedFare implements CalculateFare {


    @Override
    public Double calculateFare(Vechicle vechicle, int start, int end, int totalTime) {

        return totalTime * vechicle.getHourRate();
    }
}
