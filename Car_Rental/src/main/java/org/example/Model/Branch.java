package org.example.Model;

import java.util.ArrayList;
import java.util.List;

public class Branch {

    private String branchName;
    private String branchId;
    private List<Vechicle> vechicles;

    public Branch(String branchName, String branchId) {
        this.branchName = branchName;
        this.branchId = branchId;
        vechicles = new ArrayList<>();
    }

    public void addVechicle(Vechicle vechicle) {
        vechicles.add(vechicle);
    }

    public String getBranchName() {
        return branchName;
    }

    public String getBranchId() {
        return branchId;
    }

    public List<Vechicle> getVechicles() {
        return vechicles;
    }


}
