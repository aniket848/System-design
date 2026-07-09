package org.example.Strategy.BookingStrategy;

import org.example.Enum.CarType;
import org.example.Model.Branch;
import org.example.Model.Vechicle;
import org.example.Service.BranchService;

public interface BookStrategy {

    public Vechicle getVechicle(CarType type, Branch branch);
}
