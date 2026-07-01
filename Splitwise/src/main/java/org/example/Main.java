package org.example;

import org.example.Enum.SplitType;
import org.example.Model.Group;
import org.example.Model.User;
import org.example.Service.GroupService;

import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        User user1 = new User("101", "Aniket");
        User user2 = new User("102", "Anamta");
        User user3 = new User("103", "Harsh");
        User user4 = new User("104", "Saurabh");
        User user5 = new User("105", "Harshit");

        GroupService groupService = new GroupService();

        Group group1 = new Group("G-123","Nanital Trip");
        Group group2 = new Group("G-892","Jaipur Trip");

        groupService.addGroup(group1);
        groupService.addGroup(group2);

        group1.addMember(user1);
        group1.addMember(user2);
        group1.addMember(user3);

        group2.addMember(user1);
        group2.addMember(user4);
        group2.addMember(user5);


        System.out.println(user1.getName() + " pays 3000.0 Rs for Hotel expense with equal strategy");
        groupService.addExpense("G-123", "Hotel", 3000.0, user1, List.of(user1,user2,user3), Map.of(), SplitType.EQUAL);

        System.out.println(user2.getName() + " pays 1500.0 Rs for Food expense with equal strategy");
        groupService.addExpense("G-123", "Food", 1500.0, user2, List.of(user2,user3), Map.of(), SplitType.EQUAL);

        System.out.println(user1.getName() + " pays 900.0 Rs for Drink expense with percentage strategy");
        groupService.addExpense("G-123", "Drink", 900.0, user1, List.of(user1,user2,user3), Map.of(user1, 20.0, user2, 65.0, user3, 15.0), SplitType.PERCENTAGE);

        System.out.println();
        System.out.println();

        System.out.println("Total expenses list of group "+group1.getName());
        groupService.showAllExpenses("G-123");
        System.out.println("---------------------------------------------------");

        System.out.println("Show all balances of "+group1.getName());
        groupService.showBalanceSheet("G-123");

    }
}