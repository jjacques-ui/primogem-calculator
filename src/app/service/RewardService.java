package app.service;

import app.model.Account;
import app.model.AccountRewardSource;

public class RewardService {

    public void addRewardQuantity(AccountRewardSource reward, Account account) {
        if(reward.getRedeemedQuantity() >= reward.getQuantity()) {
            reward.setRedeemed(true);
        }

            reward.sumRedeemed(1);
            account.sum(reward.getRewardAmount());
    }

    public void remRewardQuantity(AccountRewardSource reward, Account account) {
        if(reward.getRedeemedQuantity() < reward.getQuantity()) {
            reward.setRedeemed(false);
        }

            reward.subtractRedeemed(1);
            account.subtract(reward.getRewardAmount());
    }
    
    public void markAllRewards(AccountRewardSource reward, Account account) {
            reward.setRedeemed(true);

            reward.setRedeemedQuantity(reward.getQuantity());
            account.sum(reward.getRemainingReward());
    }

    public void unmarkAllRewards(AccountRewardSource reward, Account account) {
            reward.setRedeemed(false);

            account.subtract(reward.getRedeemedReward());
            reward.setRedeemedQuantity(0);
    }

    public void toggleReward(AccountRewardSource reward, Account account) {
        if (reward.isRedeemed()) {
            reward.setRedeemed(false);
            reward.setRedeemedQuantity(0);
        } else {
            reward.setRedeemed(true);
            reward.setRedeemedQuantity(reward.getQuantity());
        }
    }
}