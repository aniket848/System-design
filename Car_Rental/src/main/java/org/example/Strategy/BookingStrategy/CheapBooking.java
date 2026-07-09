package org.example.Strategy.BookingStrategy;

import org.example.Enum.CarType;
import org.example.Model.Branch;
import org.example.Model.Vechicle;
import org.example.Service.BranchService;

import java.util.Comparator;
import java.util.List;

public class CheapBooking implements BookStrategy{

    private BranchService branchService;

    public CheapBooking(BranchService branchService) {
        this.branchService = branchService;
    }

    @Override
    public Vechicle getVechicle(CarType type, Branch branch) {
        List<Vechicle> vechicles = branchService.getVechicles(type, branch);

        vechicles.stream()
                .sorted(Comparator.comparingDouble(Vechicle::getBaseFare))
                .toList();

        //System.out.println(vechicles);

        for(Vechicle vechicle : vechicles){
            //System.out.println("vechicle: " + vechicle.getId() + ", Is Booked: " + vechicle.getIsBooked());
            if(vechicle.getIsBooked().compareAndSet(false, true)){
                return vechicle;
            }
        }

        //System.out.println("No reached last");
        return null;
    }
}
