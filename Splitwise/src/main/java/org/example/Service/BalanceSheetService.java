package org.example.Service;

import org.example.Model.BalanceSheet;
import org.example.Model.Group;
import org.example.Model.Split;
import org.example.Model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalanceSheetService {

    public void updateBalanceSheet(Group group, User paidBy, List<Split> splits){

        Double totalSum = splits.stream().map(Split::getAmount).reduce(0.0, Double::sum);
        group.getBalanceSheet(paidBy).addTotalAmount(totalSum);

        for(Split split: splits){
            User user = split.getUser();
            Double amount = split.getAmount();

            group.getBalanceSheet(user).addTotalExpense(amount);

            if(!paidBy.equals(user)){
                group.getBalanceSheet(paidBy).addBalanceForUser(user,amount);
                group.getBalanceSheet(user).addBalanceForUser(paidBy,-amount);
            }
        }

    }

    public void showBalanceSheet(Group group){

        List<User> members = group.getMembers();

        for(User user: members){

            System.out.println("------------------------------------------");
            System.out.println("------------------------------------------");
            System.out.println("Balance Sheet for User: " + user.getName());

            BalanceSheet balanceSheet = group.getBalanceSheet(user);

            int owe=0,getBack=0;
            System.out.println("Total Amount Paid: " + balanceSheet.getTotalAmountPaid());
            System.out.println("Total Expense: " + balanceSheet.getTotalExpense());

            for(Map.Entry<User,Double> entry: balanceSheet.getSheets().entrySet()){
                User otherUser = entry.getKey();
                Double amount = entry.getValue();

                if(amount>0){
                    System.out.println("You will get back " + amount + " from " + otherUser.getName());
                    getBack+=amount;
                }else if(amount<0){
                    System.out.println("You owe " + (-amount) + " to " + otherUser.getName());
                    owe+= (-amount);
                }
            }

            System.out.println("Total Amount to get back: " + getBack);
            System.out.println("Total Amount to owe: " + owe);
            System.out.println("------------------------------------------");
            System.out.println("------------------------------------------");

        }

    }

}
