package service;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import models.Account;
import models.Card;
import models.Transaction.Deposit;
import models.Transaction.Transaction;
import models.Transaction.Withdraw;

public class AtmService {
    private static AtmService instance;
    private Map<String, Account> accounts;
    private Map<String, Card> cards;
    private AtmService() {
        accounts = new ConcurrentHashMap<>();
        cards = new ConcurrentHashMap<>();
    }
    public static AtmService getInstance() {
        if (instance == null) {
            if(instance == null) {
                synchronized (AtmService.class) {
                    instance = new AtmService();
                }
            }
        }
        return instance;
    }

    public void createAccount(Account account) {
        // create account
        String accountId = account.getAccountNo();
        accounts.put(accountId, account);
    }

    public void createCard(Card card) {
        // create card
        String cardId = card.getCardNumber();
        cards.put(cardId, card);
    }

    public void addMoney(String accountNo, double amount) {
        // add money
        Account account = accounts.get(accountNo);
        String transactionId = generateTransactionId();
        Transaction transaction = new Deposit(transactionId, account, amount);
        processTransaction(transaction);
    }

    public void withdraw(String accountNo, double amount) {
        // withdraw money
        Account account = accounts.get(accountNo);
        String transactionId = generateTransactionId();
        Transaction transaction = new Withdraw(transactionId, account, amount);
        processTransaction(transaction);
    }

    public void authenticateUser(String cardNo, int pin) {
        // authenticate user
        Card card = cards.get(cardNo);
        if (card.getPin() != pin) {
            System.out.println("Invalid pin");
            return;
        }
        
    }

    public void displayAccountDetails(String accountNo){
        // display account details
        Account account = accounts.get(accountNo);
        String name = account.getName();
        double balance = account.getBalance();
        System.out.println("Name: " + name);
        System.out.println("Account No: " + accountNo);
        System.out.println("Balance: " + balance);
    }


    public void processTransaction(Transaction transaction) {
        // process transaction
        transaction.processTransaction(transaction.getAccount(), transaction.getAmount());
    }

    public String generateTransactionId() {
        // generate transaction id
        return "TXN" + new Random().nextInt(1000);
    }
}
