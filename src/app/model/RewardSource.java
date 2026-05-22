package app.model;

public class RewardSource {
    private String name;
    private int reward;
    private boolean redeemed;

    public RewardSource(String n, int r, boolean rd){
        this.name = n;
        this.reward = r;
        this.redeemed = rd;
    }
    public RewardSource(String n, int r){
        this.name = n;
        this.reward = r;
    }

    public String getName() {
        return name;
    }
    public int getReward() {
        return reward;
    }
    
    public void setRedeemed(boolean redeemed) {
        this.redeemed = redeemed;
    }

    public boolean isRedeemed() {
        return redeemed;
    }
}
