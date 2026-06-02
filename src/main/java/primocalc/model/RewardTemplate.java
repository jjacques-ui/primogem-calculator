package primocalc.model;

public class RewardTemplate {
    private String name;
    private int reward;
    

    //Constructors
    public RewardTemplate(){
    }
    public RewardTemplate(String n, int r, boolean rd){
        this.name = n;
        this.reward = r;
    }
    public RewardTemplate(String n, int r){
        this.name = n;
        this.reward = r;
    }

    //Getters
    public String getName() {
        return name;
    }
    public int getReward() {
        return reward;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setReward(int reward) {
        this.reward = reward;
    }
}