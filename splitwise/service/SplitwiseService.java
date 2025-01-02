package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import enums.TransactionStatus;
import models.Transaction;
import models.User;
import models.split.EqualSplit;
import models.split.ExactSplit;
import models.split.PercentageSplit;
import models.split.Split;
import models.Expense;
import models.Group;

public class SplitwiseService {
    private static SplitwiseService instance;
    private final HashMap<Integer,User> users;
    private final HashMap<Integer,Group> groups;
    private final HashMap<String,Transaction> transactions;
    private final HashMap<Integer,List<Transaction>> userTransactions;
    
    private SplitwiseService() {
        this.users = new HashMap<>();
        this.groups = new HashMap<>();
        this.transactions = new HashMap<>();
        this.userTransactions = new HashMap<>();
    }
    
    public static SplitwiseService getInstance() {
        if (instance == null) {
            synchronized (SplitwiseService.class) {
                if (instance == null){
                    instance = new SplitwiseService();
                }
            }
        }
        return instance;
    }
    
    public void addUser(User user){
        users.put(user.getId(),user);
    }

    public void printUsers(){
        for(User user: users.values()){
            System.out.println(user);
        }
    }

    public void addGroup(Group group){
        groups.put(group.getId(),group);
    }

    public void addExpense(int groupId, Expense expense) {
        Group group = groups.get(groupId);
        if (group != null) {
            List<Expense> expenses = group.getExpenses();
            expenses.add(expense);
            group.setExpenses(expenses);
            splitExpense(expense);
            updateBalances(expense);
        }
    }

    public void splitExpense(Expense expense){
        double totalAmount=expense.getAmount();
        List<Split> splits=expense.getSplits();
        int splitAmount = (int) (totalAmount/splits.size());
        for(Split split:splits){
            if(split instanceof EqualSplit){
                split.setAmount(splitAmount);
            }
            else if(split instanceof PercentageSplit percentageSplit){
                split.setAmount((int)(totalAmount*percentageSplit.getPercentage()/100));
            }
            else if (split instanceof ExactSplit exactSplit){
                split.setAmount(exactSplit.getAmount());
            }
        }
    }

    public void settleBalance(int user1Id, int user2Id){
        User user1 = users.get(user1Id);
        User user2 = users.get(user2Id);
        double amount = user1.getBalances().get(user2Id);
        user1.getBalances().put(user2Id, 0.0);
        user2.getBalances().put(user1Id, 0.0);
        Transaction transaction = new Transaction(generateTransactionId(), user1, user2, TransactionStatus.SUCCEEDED, amount);
        createTransaction(transaction);
    }

    public void updateBalances(Expense expense){
        User paidBy=expense.getPaidBy();
        for(Split split: expense.getSplits()){
            User user = split.getUser();
            double amount = split.getAmount();
            if(user.getId()!=paidBy.getId()){
                updateBalance(paidBy.getId(),user.getId(), amount);
                updateBalance(user.getId(),paidBy.getId(), -amount);
            }
        }        
    }

    public void updateBalance(int user1Id, int user2Id, double amount){
        User user1 = users.get(user1Id);
        HashMap<Integer,Double> balances1 = user1.getBalances();
        balances1.put(user2Id, balances1.getOrDefault(user2Id, 0.0)+amount);
    }

    public void createTransaction(Transaction transaction){
        transactions.put(transaction.getId(),transaction);
        int user1Id = transaction.getSender().getId();
        int user2Id = transaction.getReceiver().getId();
        userTransactions.putIfAbsent(user1Id, new ArrayList<>());
        userTransactions.get(user1Id).add(transaction);
        userTransactions.putIfAbsent(user2Id, new ArrayList<>());
        userTransactions.get(user2Id).add(transaction);
    }

    public void printBalanceSheet(int userId){
        User user = users.get(userId);
        HashMap<Integer,Double> balances = user.getBalances();
        for(int user2Id: balances.keySet()){
            double amount = balances.get(user2Id);
            if(amount!=0){
                System.out.println("User "+userId+" owes "+user2Id+" amount "+amount);
            }
        }
    }

    // public void showBalanceSheetOfUser(User user){

    //     System.out.println("---------------------------------------");

    //     System.out.println("Balance sheet of user : " + user.getId());




    // }


    public String generateTransactionId(){
       return "T" + java.util.UUID.randomUUID().toString();
    }
    
}