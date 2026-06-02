package primocalc.model;
import java.util.List;

public class Game {
    private String name;
    private List<Account> accounts;
    private List<GoalTemplate> availableGoals;
    private List<RewardTemplate> availableRewards;

    //Constructors
    public Game() {
    }
    public Game(String n) {
        this.name = n;
    }

    //Getters
    public String getName() {
        return this.name;
    }
    public List<Account> getAccounts() {
        return this.accounts;
    }
    public List<GoalTemplate> getAvailableGoals() {
        return this.availableGoals;
    }
    public List<RewardTemplate> getAvailableRewards() {
        return this.availableRewards;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
    public void setAvailableGoals(List<GoalTemplate> availableGoals) {
        this.availableGoals = availableGoals;
    }
    public void setAvailableRewards(List<RewardTemplate> availableRewards) {
        this.availableRewards = availableRewards;
    }
    
}