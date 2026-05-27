package app.model;
import java.util.List;

public class Game {
    private String name;
    private List<Account> accounts;
    private List<GoalTemplate> availableGoals;
    private List<RewardTemplate> availableRewards;

    public Game(String n){
        this.name = n;
    }

    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<RewardTemplate> getAvailableRewards() {
        return availableRewards;
    }

    public List<GoalTemplate> getAvailableGoals() {
        return availableGoals;
    }
}
