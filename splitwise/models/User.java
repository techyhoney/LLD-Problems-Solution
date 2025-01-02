package models;
import java.util.HashMap;

public class User {
    private int id;
    private String name;
    private String email;
    private HashMap<Integer, Double> balances;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.balances = new HashMap<>();
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public HashMap<Integer, Double> getBalances() {
        return balances;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setBalances(HashMap<Integer, Double> balances) {
        this.balances = balances;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", balances=" + balances +
                '}';
    }
}