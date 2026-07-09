package org.example.Strategy.FareCalculation;

import org.example.Model.Vechicle;

public interface CalculateFare {

    public Double calculateFare(Vechicle vechicle, int start, int end, int totalTime);

}
