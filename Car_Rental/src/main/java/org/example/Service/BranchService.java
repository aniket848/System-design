package org.example.Service;

import org.example.Enum.CarType;
import org.example.Model.Branch;
import org.example.Model.Vechicle;
import org.example.Repo.BookingRepo;
import org.example.Repo.BranchRepo;

import java.util.ArrayList;
import java.util.List;

public class BranchService {

    private BranchRepo branchRepo;
    private BookingRepo bookingRepo;

    public BranchService(BranchRepo branchRepo, BookingRepo bookingRepo) {
        this.branchRepo = branchRepo;
        this.bookingRepo = bookingRepo;
    }

    public List<Vechicle> getVechicles(CarType type, Branch branch) {
        List<Vechicle> res = new ArrayList<>();
        //Branch branch = branchRepo.getBranch(bra);
        //System.out.println("Branch: " + branch.getBranchName() + ", ID: " + branch.getBranchId());
        res = branch
                .getVechicles()
                .stream()
                .filter(v -> v.getType().equals(type))
                .toList();

        return res;
    }
}
