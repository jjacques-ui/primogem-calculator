package app.model;
import java.util.ArrayList;

public class Account {
    private String username;
    private int balance;
    private int pity;
    private Goal currentGoal;
    private ArrayList<RewardSource> rewardSources;

    public Account(String u, int b, int p){
        this.username = u;
        this.balance = b;
        this.pity = p;
    }

    public void sum(int s){
        this.balance += s;
    }
    public void subtract(int s){
        this.balance -= s;
    }

    public void setCurrentGoal(Goal currentGoal) {
        this.currentGoal = currentGoal;
    }

    public Goal getCurrentGoal() {
        return currentGoal;
    }

    public String getUsername() {
        return username;
    }

    public int getBalance() {
        return balance;
    }
    
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getPity() {
        return pity;
    }
    public void setPity(int pity) {
        this.pity = pity;
    }

    public ArrayList<RewardSource> getRewardSources() {
        return rewardSources;
    }

    public double getProgressPercentage() {
        return ((double) balance / currentGoal.getPrice()) * 100;
    }

    public int getAllRewards(){
        int total = 0;
        for(int i = 0; i < rewardSources.size(); i++) {
            if (!rewardSources.get(i).isRedeemed()) {
                total += rewardSources.get(i).getReward();
            }
        }
        return total;
    }
}