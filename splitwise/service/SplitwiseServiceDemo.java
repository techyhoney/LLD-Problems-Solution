package service;

import java.util.ArrayList;
import java.util.List;
import models.Expense;
import models.Group;
import models.SplitFactory;
import models.User;
import models.split.Split;

public class SplitwiseServiceDemo {
    public static void run() {
        System.out.println("Splitwise Service");
        SplitwiseService splitwiseService = SplitwiseService.getInstance();

        // Create users
        User user1 = new User(1, "Alice", "alice@gmail.com");
        User user2 = new User(2, "Bob", "bob@gmail.com");
        User user3 = new User(3, "Charlie", "charlie@gmail.com");
        splitwiseService.addUser(user1);
        splitwiseService.addUser(user2);
        splitwiseService.addUser(user3);

        splitwiseService.printUsers();
        // Create group
        Group group1 = new Group(1, "The Three Musketeers");
        group1.addMember(user1);
        group1.addMember(user2);
        group1.addMember(user3);
        splitwiseService.addGroup(group1);

        // Test 1: Equal Split
        Expense expense1 = new Expense(1, 99, "Christmas Party", user2);
        List<Split> equalSplits = new ArrayList<>();
        try {
            equalSplits.add(SplitFactory.createSplit(user1, "EQUAL"));
            equalSplits.add(SplitFactory.createSplit(user2, "EQUAL"));
            equalSplits.add(SplitFactory.createSplit(user3, "EQUAL"));
        } catch (Exception e) {
            System.err.println("Invalid split type: " + e.getMessage());
        }
        expense1.setSplits(equalSplits);
        splitwiseService.addExpense(group1.getId(), expense1);

        // Test 2: Exact Split
        // Expense expense2 = new Expense(2, 1000, "House Rent", user1);
        // List<Split> exactSplits = new ArrayList<>();
        // try {
        //     exactSplits.add(SplitFactory.createSplit(user1, "EXACT", 400.0));
        //     exactSplits.add(SplitFactory.createSplit(user2, "EXACT", 400.0));
        //     exactSplits.add(SplitFactory.createSplit(user3, "EXACT", 200.0));
        // } catch (Exception e) {
        //     System.err.println("Invalid split type: " + e.getMessage());
        // }
        // expense2.setSplits(exactSplits);
        // splitwiseService.addExpense(group1.getId(), expense2);

        // Test 3: Percentage Split
        // Expense expense3 = new Expense(3, 1200, "Weekend Trip", user3);
        // List<Split> percentageSplits = new ArrayList<>();
        // try {
        //     percentageSplits.add(SplitFactory.createSplit(user1, "PERCENT", 40.0));
        //     percentageSplits.add(SplitFactory.createSplit(user2, "PERCENT", 40.0));
        //     percentageSplits.add(SplitFactory.createSplit(user3, "PERCENT", 20.0));
        // } catch (Exception e) {
        //     System.err.println("Invalid split type: " + e.getMessage());
        // }
        // expense3.setSplits(percentageSplits);
        // splitwiseService.addExpense(group1.getId(), expense3);

        // Print balances for all users
        System.out.println("\nFinal Balances:");
        splitwiseService.printBalanceSheet(user1.getId());
        splitwiseService.printBalanceSheet(user2.getId());
        splitwiseService.printBalanceSheet(user3.getId());

    }
}