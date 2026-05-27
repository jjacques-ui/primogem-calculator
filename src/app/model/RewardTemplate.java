package app.model;

public class RewardTemplate {
    private String name;
    private int reward;
    

    public RewardTemplate(String n, int r, boolean rd){
        this.name = n;
        this.reward = r;
    }
    public RewardTemplate(String n, int r){
        this.name = n;
        this.reward = r;
    }

    public String getName() {
        return name;
    }
    public int getReward() {
        return reward;
    }
}
