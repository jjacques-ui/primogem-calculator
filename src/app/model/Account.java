package app.model;
import java.util.List;

public class Account {
    private String username;
    private int balance;
    private int pity;
    private AccountGoal currentGoal;
    private List<AccountRewardSource> rewardSources;

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

    public void setCurrentGoal(AccountGoal currentGoal) {
        this.currentGoal = currentGoal;
    }

    public AccountGoal getCurrentGoal() {
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

    public int getRemainingAmount(){
        return this.getCurrentGoal().getTotalPrice() - this.getBalance() - (this.getPity() * 160);
    }

    public List<AccountRewardSource> getRewardSources() {
        return rewardSources;
    }

    public double getProgressPercentage() {
        return ((double) (this.balance + (this.pity * 160)) / currentGoal.getTotalPrice()) * 100;
    }

    public int getAllRewards(){
        int total = 0;
        for(int i = 0; i < rewardSources.size(); i++) {
            if (!rewardSources.get(i).isRedeemed()) {
                total += rewardSources.get(i).getRewardAmount();
            }
        }
        return total;
    }
}