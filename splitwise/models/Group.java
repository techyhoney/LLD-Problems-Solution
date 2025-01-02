package models;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Group {
    private int id;
    private String name;
    private User owner;
    private List<Expense> expenses;
    private List<User> users;

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
        this.users = new CopyOnWriteArrayList<>();
        this.expenses = new CopyOnWriteArrayList<>();
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public User getOwner() {
        return owner;
    }
    public List<Expense> getExpenses() {
        return expenses;
    }
    public List<User> getUsers() {
        return users;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }
    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addMember(User user) {
        users.add(user);
    }
    
    public void addExpense(Expense expense) {
        expenses.add(expense);
    }
}