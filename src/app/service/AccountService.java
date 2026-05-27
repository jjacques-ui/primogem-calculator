package app.service;

import app.model.Account;
import app.model.AccountRewardSource;
import app.model.RewardTemplate;

public class AccountService {
    public AccountRewardSource findReward(Account a, RewardTemplate t) {
        for (AccountRewardSource ar : a.getRewardSources()) {
            if (ar.getTemplate() == t) {
                return ar;
            }
        }
        
        return null;
    }

    public void removeReward(Account a, AccountRewardSource r) {
        a.getRewardSources().remove(r);
    }

    public void removeReward(Account a, RewardTemplate r, int q) {
        AccountRewardSource ar = new AccountRewardSource(r, q);
        a.getRewardSources().add(ar);
    }
}
