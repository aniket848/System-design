package org.example.Service;

import org.example.Enum.SplitType;
import org.example.Factory.SplitFactory;
import org.example.Model.Expense;
import org.example.Model.Group;
import org.example.Model.Split;
import org.example.Model.User;
import org.example.Strategy.SplitStrategy;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ExpenseService {

    BalanceSheetService balanceSheetService = new BalanceSheetService();

    public void addExpense(Group group, String desc, Double amount, User paidBy, List<User> participants, Map<User,Double> metaData, SplitType splitType) {

        SplitStrategy splitStrategy = SplitFactory.createSplitStrategy(splitType);

        String id =  UUID.randomUUID().toString();

        List<Split> splits = splitStrategy.split(splitType, amount, participants, metaData);

        Expense expense = new Expense(id,desc,amount,paidBy,splits);

        group.addExpense(expense);
        balanceSheetService.updateBalanceSheet(group, paidBy, splits);

    }
}

