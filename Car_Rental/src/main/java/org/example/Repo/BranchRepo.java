package org.example.Repo;

import org.example.Model.Branch;

import java.util.HashMap;
import java.util.Map;

public class BranchRepo {

    private Map<String, Branch> branches = new HashMap<>();

    public Branch getBranch(String branchId) {
        return branches.get(branchId);
    }

    public void addBranch(Branch branch) {
        branches.put(branch.getBranchId(),branch);
    }
}
