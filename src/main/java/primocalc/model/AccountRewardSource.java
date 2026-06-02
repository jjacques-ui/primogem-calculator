package primocalc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AccountRewardSource {
    private RewardTemplate template;
    private boolean redeemed;
    private int quantity;
    private int redeemedQuantity;

    //Constructors
    public AccountRewardSource() {
    }
    public AccountRewardSource(RewardTemplate t, int q){
        this.template = t;
        this.quantity = q;
    }

    //Methods
    public void sumRedeemed(int s){
        this.redeemedQuantity += s;
    }
    public void subtractRedeemed(int s){
        this.redeemedQuantity -= s;
    }
    
    @JsonIgnore
    public int getRedeemedReward() {
        return this.getRedeemedQuantity() * template.getReward();
    }
    @JsonIgnore
    public int getRemainingRedeemed() {
        return quantity - redeemedQuantity;
    }
    @JsonIgnore
    public int getTotalReward() {
        return this.template.getReward() * quantity;
    }
    @JsonIgnore
    public int getRemainingReward() {
        return this.getTotalReward() - (template.getReward() * this.getRemainingRedeemed());
    }

    //Getters
    public RewardTemplate getTemplate() {
        return template;
    }
    public boolean isRedeemed() {
        return redeemed;
    }
    public int getQuantity() {
        return quantity;
    }
    public int getRedeemedQuantity() {
        return redeemedQuantity;
    }

    //Setters
    public void setTemplate(RewardTemplate template) {
        this.template = template;
    }
    public void setRedeemed(boolean redeemed) {
        this.redeemed = redeemed;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setRedeemedQuantity(int redeemedQuantity) {
        this.redeemedQuantity = redeemedQuantity;
    }

    @JsonIgnore
    public String getName() {
        return this.template.getName();
    }

    @JsonIgnore
    public int getRewardAmount() {
        return this.template.getReward();
    }
}