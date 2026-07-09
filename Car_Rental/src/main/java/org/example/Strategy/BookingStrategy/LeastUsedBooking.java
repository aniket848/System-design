package org.example.Strategy.BookingStrategy;

import org.example.Enum.CarType;
import org.example.Model.Branch;
import org.example.Model.Vechicle;
import org.example.Service.BranchService;

import java.util.Comparator;
import java.util.List;

public class LeastUsedBooking implements BookStrategy {

    private BranchService branchService;

    public LeastUsedBooking(BranchService branchService) {
        this.branchService = branchService;
    }

    @Override
    public Vechicle getVechicle(CarType type, Branch branch) {
        List<Vechicle> vechicles = branchService.getVechicles(type, branch);

        vechicles.stream()
                .sorted(Comparator.comparingInt(Vechicle::getNoOfBookings))
                .toList();

        for(Vechicle vechicle : vechicles){
            if(vechicle.getIsBooked().compareAndExchange(false, true)){
                return vechicle;
            }
        }

        return null;

    }
}
