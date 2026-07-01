package org.example.Model;

import org.example.Enum.SplitType;
import org.example.Factory.SplitFactory;
import org.example.Strategy.SplitStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Expense {

    private String id;
    private String description;
    private Double totalAmount;
    private User paidBy;
    private List<Split> splits = new ArrayList<>();

    public Expense(String id, String description, Double totalAmount, User paidBy, List<Split> splits) {
        this.id = id;
        this.description = description;
        this.totalAmount = totalAmount;
        this.paidBy = paidBy;
        this.splits = splits;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }
}
