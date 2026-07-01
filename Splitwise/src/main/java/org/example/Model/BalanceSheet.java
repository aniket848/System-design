package org.example.Model;

import java.util.HashMap;
import java.util.List;

public class BalanceSheet {

    private HashMap<User,Double> sheets = new HashMap<>();
    private Double totalAmountPaid;
    private Double totalExpense;

    public BalanceSheet(){
        this.totalAmountPaid = 0.0;
        this.totalExpense = 0.0;
    }

    public void addBalanceForUser(User user, Double amount){
        sheets.put(user, sheets.getOrDefault(user, 0.0) + amount);
    }

    public void addTotalAmount(Double amount){
        totalAmountPaid = totalAmountPaid+amount;
    }

    public void addTotalExpense(Double amount){
        totalExpense = totalExpense+amount;
    }

    public Double getTotalAmountPaid() {
        return totalAmountPaid;
    }

    public Double getTotalExpense() {
        return totalExpense;
    }

    public HashMap<User, Double> getSheets() {
        return sheets;
    }
}
