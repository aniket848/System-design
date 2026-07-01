package org.example.Service;

import org.example.Enum.SplitType;
import org.example.Model.Expense;
import org.example.Model.Group;
import org.example.Model.User;
import org.example.Repository.GroupRepo;

import java.util.List;
import java.util.Map;

public class GroupService {

    private ExpenseService expenseService;
    private BalanceSheetService balanceSheetService;
    private GroupRepo groupRepo;

    public GroupService(){
        expenseService = new ExpenseService();
        balanceSheetService = new BalanceSheetService();
        groupRepo = new GroupRepo();
    }

    public void addGroup(Group group){
        groupRepo.addGroup(group);
    }

    public void showGroups(){
        groupRepo.showAllGroups();
    }

    public void addExpense(String groupId, String desc, Double amount, User paidBy, List<User> participants, Map<User,Double> metaData, SplitType splitType){
        Group group = get(groupId);
        expenseService.addExpense(group, desc, amount, paidBy, participants, metaData, splitType);
    }

    public void showBalanceSheet(String groupId){
        Group group = get(groupId);
        balanceSheetService.showBalanceSheet(group);
    }

    private Group get(String groupId){
        return groupRepo.getGroup(groupId);
    }

    public void showAllExpenses(String groupId){
        Group group = get(groupId);
        for(Expense expense : group.getExpenses()){
            System.out.println("Expense ID: " + expense.getId() + ", Description: " + expense.getDescription() + ", Amount: " + expense.getTotalAmount() + ", Paid By: " + expense.getPaidBy().getName());
        }
    }
}
