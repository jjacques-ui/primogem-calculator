package primocalc.service;

import primocalc.model.Account;
import primocalc.model.AccountRewardSource;
import primocalc.model.RewardTemplate;

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

    public void addReward(Account a, RewardTemplate r, int q) {
        AccountRewardSource ar = new AccountRewardSource(r, q);
        a.getRewardSources().add(ar);
    }
}