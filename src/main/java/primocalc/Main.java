package primocalc;

import primocalc.menu.Menu;
import primocalc.model.Game;
import primocalc.service.SaveService;

public class Main {
    public static void main(String[] args) {
        SaveService saveService = new SaveService();
        Game genshin = new Game("Genshin Impact");

        genshin.setAccounts(saveService.loadAccounts());
        genshin.setAvailableRewards(saveService.loadRewardTemplates());
        genshin.setAvailableGoals(saveService.loadGoalTemplates());

        Menu menu = new Menu(genshin);

        menu.start();

        saveService.saveAccounts(genshin.getAccounts());
        saveService.saveRewardTemplates(genshin.getAvailableRewards());
        saveService.saveGoalTemplates(genshin.getAvailableGoals());
    }
}
