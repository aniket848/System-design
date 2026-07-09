package org.example.Strategy.FareCalculation;

import org.example.Model.Vechicle;

public class DistanceBasedFare implements CalculateFare {

    @Override
    public Double calculateFare(Vechicle vechicle, int start, int end, int totalTime) {
        double distance = end - start;
        return distance * vechicle.getPerKmRate();
    }
}
