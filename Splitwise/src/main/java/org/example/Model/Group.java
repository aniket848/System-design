package org.example.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Group {

    private String id;
    private String name;
    private List<User> members;
    private List<Expense> expenses;
    private HashMap<User,BalanceSheet> balanceSheets;

    public Group(String id, String name) {
        this.id = id;
        this.name = name;
        members = new ArrayList<>();
        expenses = new ArrayList<>();
        balanceSheets = new HashMap<>();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void addMember(User user){
        members.add(user);
        balanceSheets.putIfAbsent(user,new BalanceSheet());
    }
    public List<User> getMembers() {
        return members;
    }

    public void addExpense(Expense expense){
        expenses.add(expense);
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public BalanceSheet getBalanceSheet(User user){
        return balanceSheets.get(user);
    }


}
