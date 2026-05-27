package app.model;

public class AccountRewardSource {
    private RewardTemplate template;
    private boolean redeemed;
    private int quantity;
    private int redeemedQuantity;

    public AccountRewardSource(RewardTemplate t, int q){
        this.template = t;
        this.quantity = q;
    }

    public void sumRedeemed(int s){
        this.redeemedQuantity += s;
    }
    public void subtractRedeemed(int s){
        this.redeemedQuantity -= s;
    }

    public void setRedeemed(boolean redeemed) {
        this.redeemed = redeemed;
    }
    public boolean isRedeemed() {
        return redeemed;
    }
    public void setRedeemedQuantity(int redeemedQuantity) {
        this.redeemedQuantity = redeemedQuantity;
    }

    public RewardTemplate getTemplate() {
        return template;
    }

    public String getName() {
        return this.template.getName();
    }
    public int getRewardAmount() {
        return this.template.getReward();
    }
    public int getTotalReward() {
        return this.template.getReward() * quantity;
    }
    public int getRemainingReward() {
        return this.getTotalReward() - (template.getReward() * this.getRemainingRedeemed());
    }
    public int getRedeemedReward() {
        return this.getRedeemedQuantity() * template.getReward();
    }

    public int getQuantity() {
        return quantity;
    }
    public int getRedeemedQuantity() {
        return redeemedQuantity;
    }
    public int getRemainingRedeemed() {
        return quantity - redeemedQuantity;
    }
}
