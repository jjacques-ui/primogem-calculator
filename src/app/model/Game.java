package app.model;
import java.util.ArrayList;

public class Game {
    private String name;
    private ArrayList<Account> accounts;
    private ArrayList<Goal> availableGoals;
    private ArrayList<RewardSource> availableRewards;

    public Game(String n){
        this.name = n;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public ArrayList<RewardSource> getAvailableRewards() {
        return availableRewards;
    }

    public ArrayList<Goal> getAvailableGoals() {
        return availableGoals;
    }
}
