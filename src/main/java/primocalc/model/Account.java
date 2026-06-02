package primocalc.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Account {
    private String username;
    private int balance;
    private int pity;
    private AccountGoal currentGoal;
    private List<AccountRewardSource> rewardSources = new ArrayList<>();

    //Constructors
    public Account(){
    }
    public Account(String u, int b, int p){
        this.username = u;
        this.balance = b;
        this.pity = p;
    }

    //Methods
    public void sum(int s){
        this.balance += s;
    }
    public void subtract(int s){
        this.balance -= s;
    }

    @JsonIgnore
    public int getRemainingAmount(){
        return this.getCurrentGoal().getTotalPrice() - this.getBalance() - (this.getPity() * 160);
    }
    @JsonIgnore
    public double getProgressPercentage() {
        return ((double) (this.balance + (this.pity * 160)) / this.currentGoal.getTotalPrice()) * 100;
    }
    @JsonIgnore
    public double getAchievableProgressPercentage() {
        return ((double) (this.balance + (this.pity * 160) + this.getAllRewards()) / this.currentGoal.getTotalPrice()) * 100;
    }
    @JsonIgnore
    public int getAllRewards(){
        int total = 0;
        for(int i = 0; i < this.rewardSources.size(); i++) {
            if (!this.rewardSources.get(i).isRedeemed()) {
                total += this.rewardSources.get(i).getRewardAmount();
            }
        }
        return total;
    }

    //Getters
    public String getUsername() {
        return username;
    }
    public int getBalance() {
        return balance;
    }
    public int getPity() {
        return pity;
    }
    public AccountGoal getCurrentGoal() {
        return currentGoal;
    }
    public List<AccountRewardSource> getRewardSources() {
        return rewardSources;
    }

    //Setters
    public void setUsername(String username) {
        this.username = username;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public void setPity(int pity) {
        this.pity = pity;
    }
    public void setCurrentGoal(AccountGoal currentGoal) {
        this.currentGoal = currentGoal;
    }
    public void setRewardSources(List<AccountRewardSource> rewardSources) {
        this.rewardSources = rewardSources;
    }
}