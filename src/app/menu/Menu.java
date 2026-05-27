package app.menu;

import app.model.Account;
import app.model.AccountGoal;
import app.model.AccountRewardSource;
import app.model.Game;
import app.model.RewardTemplate;
import app.model.GoalTemplate;
import app.service.AccountService;
import app.service.RewardService;

import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    private Game game;
    private RewardService rewardService;
    private AccountService accountService;

    public Menu(Game g) {
        this.game = g;
        this.rewardService = new RewardService();
        this.accountService = new AccountService();
    }

    public void start() {
        int option;

        do {
            clearScreen();
            showGameMenu();

            option = readInt();

            switch(option) {

                case 1:
                    showMainMenu();
                    break;

                case 0:
                System.out.println("Closing...");
                break;

            default:
                invalidOption();
            }

        } while(option != 0);
    }

    private void showGameMenu() {
        System.out.println("\n=== PRIMO CALC ===");
        System.out.println("\nSelect game");
        System.out.println("\n1)"+game.getName());
        System.out.println("0)Close");
        System.out.println("Select: ");
    }

    private void showMainMenu() {
        int option;

        do {
        clearScreen();
            System.out.println("\n=== PRIMO CALC ===");
            System.out.println("\n1)Check accounts");
            System.out.println("2)Config game");
            System.out.println("0)Back");
            System.out.println("Select: ");

            option = readInt();

            switch(option) {

                case 1:
                    checkAccountsMenu();
                    break;
                case 2:
                    gameConfigMenu();
                    break;
                case 0:
                    break;
                default:
                invalidOption();
            }

        } while(option != 0);
    }

    private void gameConfigMenu() {
        int option;

        do {
        clearScreen();
            System.out.println("\n=== GAME CONFIG ===");
            System.out.println("Game: " + game.getName());
            System.out.println("\n1)Add new reward source");
            System.out.println("2)Add new pulling goal");
            System.out.println("3)Add new account");
            System.out.println("0)Back");
            System.out.println("Select: ");

            option = readInt();

            switch(option) {

                case 1:
                    createRewardSource();
                    break;
                case 2:
                    createGoal();
                    break;
                case 3:
                    createAccount();
                    break;
                case 0: 
                    break;
                default:
                invalidOption();                
            }

        } while(option != 0);
    }

    private void createRewardSource() {
        do {
            clearScreen();
            System.out.println("Name the reward source: ");
            String name = readString();

            System.out.println("Reward amount: ");
            int reward = readInt();

            RewardTemplate rS = new RewardTemplate(name, reward);

            game.getAvailableRewards().add(rS);

            System.out.println("\nReward created!");
            System.out.println(name + " - " + reward + "✦");

        } while(askRepeat("reward source"));
    }
    private void createGoal() {
        do {
            clearScreen();
            System.out.println("Name the goal: ");
            String name = readString();

            System.out.println("Goal price: ");
            int price = readInt();;

            GoalTemplate g = new GoalTemplate(name, price);

            game.getAvailableGoals().add(g);

            System.out.println("\nGoal created!");
            System.out.println(name + " - " + price + "✦");

        } while(askRepeat("pulling goal"));
    }
    private void createAccount(){
        do {
            clearScreen();
            System.out.println("Account's username: ");
            String username = readString();

            System.out.println("Current primogem balance: ");
            int balance = readInt();

            System.out.println("Current banner pity: ");
            int pity = readInt();

            Account a = new Account(username, balance, pity);

            game.getAccounts().add(a);

            System.out.println("\nAccount created!");
            System.out.println(username + " - " + balance + "✦ - Pity: " + pity);

        } while(askRepeat("account"));
    }

    private void checkAccountsMenu(){
        clearScreen();
        int option;
        List<Account> accounts = game.getAccounts();

        do {
            System.out.println("\n=== CHECK ACCOUNTS ===");
            System.out.println("Game: "+game.getName()+"\n");
            for(int i = 0; i < accounts.size(); i++) {
                System.out.println((i+1)+") "+accounts.get(i).getUsername());
            }
            System.out.println("0) Back");
            System.out.println("Select: ");

            option = readInt();

            if(option > 0 && option <= accounts.size()) {
                
                Account selected = accounts.get(option-1);
                accountMenu(selected);
            } else if (option == 0) {
                break;
            } else {
                invalidOption();
            }

        } while(option != 0);  
    }
    private void accountMenu(Account a){
        clearScreen();
        int option;

        do {
            printAccountHeader(a);
            System.out.println("1) Check reward sources list");
            System.out.println("2) Check progress");
            System.out.println("3) Set account's values");
            System.out.println("0) Back");
            System.out.println("Select: ");

            option = readInt();

            switch(option) {

                case 1:
                    rewardSourceListMenu(a);
                    break;
                case 2:
                    progressMenu(a);
                    break;
                case 3:
                    editAccountMenu(a);
                    break;
                case 0: 
                    break;
                default:
                invalidOption();
            }

        } while(option != 0);
    }
    private void rewardSourceListMenu(Account a){
        clearScreen();
        int option;
        List<AccountRewardSource> rSources = a.getRewardSources();

        do {
            printAccountHeader(a);
            for(int i = 0; i < rSources.size(); i++) {
                if(!rSources.get(i).isRedeemed()){
                    System.out.println((i+1) + ") "+rSources.get(i).getName() + "x" + rSources.get(i).getQuantity() + " - " + rSources.get(i).getRewardAmount() + "✦");
                }
            }

            System.out.println("0) Back");
            System.out.println("Select: ");

            option = readInt();

            if(option > 0 && option <= rSources.size()) {
                AccountRewardSource selected = rSources.get(option-1);
                rewardSourceMenu(selected, a);
                break;
            } else if (option == 0) {
                break;
            } else {
                invalidOption();
            }
        } while(option != 0);
    }
    private void rewardSourceMenu(AccountRewardSource r, Account a){
        clearScreen();
        int option;

        do {
            printAccountHeader(a);
            System.out.println(r.getName() + "x" + r.getQuantity() + " - " + r.getRewardAmount() + "✦");
            System.out.println("Redeemed: " + r.getRedeemedQuantity() + "; Remaining - " + r.getRemainingRedeemed());
            System.out.println("Total primogems - " + r.getTotalReward());

            if (!r.isRedeemed()) {
                System.out.println("\n1) Mark as redeemed");
            }
            if (r.getRedeemedQuantity() > 0) {
                System.out.println("\n2) Unmark as redeemed");
            }
            if (r.getQuantity() > 1 && !r.isRedeemed()) {
                System.out.println("3) Mark all as redeemed");
            }
            if (r.getQuantity() > 1 && r.getRedeemedQuantity() > 0) {
                System.out.println("4) Unmark all as redeemed");
            }
            System.out.println("0) Back");
            System.out.println("Select: ");

            option = readInt();

            switch(option) {
                case 1:
                    rewardService.addRewardQuantity(r, a);
                    break;
                case 2:
                    rewardService.remRewardQuantity(r, a);
                    break;
                case 3:
                    rewardService.markAllRewards(r, a);
                    break;
                case 4:
                    rewardService.unmarkAllRewards(r, a);
                    break;
                case 0: 
                    break;
                default:
                invalidOption();
            }
        } while(option != 0);
    }

    private void progressMenu(Account a){
        clearScreen();
        int option;

        do {
            printAccountHeader(a);
            System.out.println("Progress - " + a.getProgressPercentage() + "% / 100%");
            System.out.println("Balance: " + a.getBalance() + "✦ (" + toWishes(a.getBalance()) + " wishes)");
            System.out.println("Goal: " + a.getCurrentGoal().getName() + " - " + a.getCurrentGoal().getTotalPrice() + "✦ (" + toWishes(a.getCurrentGoal().getPrice()) + " wishes)");
            System.out.println("\nRemaining: " + a.getRemainingAmount() + "✦ (" + toWishes(a.getRemainingAmount()) + " wishes)");
            System.out.println("\nAvaiable rewards: " + a.getAllRewards() + "✦ (" + toWishes(a.getAllRewards()) + " wishes)");

            System.out.println("0) Back");
            System.out.println("Select: ");

            option = readInt();

            if(option == 0){
                break;
            } else {
                invalidOption();
            }           

        } while(option != 0);
    }

    private void editAccountMenu(Account a) {
        clearScreen();
        int option;

        do {
            printAccountHeader(a);
            System.out.println("\n1)Set currency balance");
            System.out.println("2)Set current pity");
            System.out.println("3)Set current objective");
            System.out.println("4)Set avaiable rewards");
            System.out.println("0)Back");
            System.out.println("Select: ");

            option = readInt();

            switch(option) {

                case 1:
                    System.out.println("Current balance: ");
                    int b = readInt();
                    a.setBalance(b);
                    break;
                case 2:
                    System.out.println("Current pity: ");
                    int p = readInt();
                    a.setPity(p);
                    break;
                case 3:
                    pickCurrentGoal(a);
                    break;
                case 4:
                    setRewardList(a);
                    break;
                case 0:
                    break;
                default:
                invalidOption();
            }

        } while(option != 0);
    }

    private void pickCurrentGoal(Account a){
        clearScreen();
        int option;
        List<GoalTemplate> goals = game.getAvailableGoals();

        do {
            printAccountHeader(a);
            System.out.println("\n=== AVAIABLE GOALS ===");

            for(int i = 0; i < goals.size(); i++) {
                System.out.println((i+1)+") " + goals.get(i).getName());
            }
            System.out.println("0) Back");
            System.out.println("Select: ");

            option = readInt();

            if(option > 0 && option <= goals.size()) {
                System.out.println("How many ones? ");

                int quantity = readInt();
                AccountGoal selected = new AccountGoal(goals.get(option-1), quantity);

                a.setCurrentGoal(selected);
            } else if (option == 0) {
                break;
            } else {
                invalidOption();
            }
        } while(option != 0);  
    }

    private void setRewardList(Account a){
        clearScreen();
        int option;
        List<RewardTemplate> templates = game.getAvailableRewards();

        do {
            printAccountHeader(a);
            System.out.println("=== REWARD TEMPLATES ===");

            for(int i = 0; i < templates.size(); i++) {

                RewardTemplate t = templates.get(i);
                AccountRewardSource existing = accountService.findReward(a, t);

                if(existing != null) {
                    System.out.println((i + 1) + ") [+] " + templates.get(i).getName() + "x"+existing.getQuantity()+" - " + templates.get(i).getReward() + "✦");
                } else {
                    System.out.println((i + 1) + ") [-] " + templates.get(i).getName() + " - " + templates.get(i).getReward() + "✦");
                }
            }

            System.out.println("0) Back");
            System.out.println("Select to toggle: ");

            option = readInt();

            if(option > 0 && option <= templates.size()) {
                RewardTemplate selected = templates.get(option-1);
                AccountRewardSource existing = accountService.findReward(a, selected);

                if (existing != null) {
                    accountService.removeReward(a, existing);
                } else {
                    System.out.println("How many: ");
                    int quantity = readInt();
                    accountService.addReward(a, selected, quantity);
                }
                break;
            } else if (option == 0) {
                break;
            } else {
                invalidOption();
            }
        } while(option != 0);
    }

    private int toWishes(int p) {
        return (int) p / 160;
    }

    private void invalidOption() {
        System.out.println("Invalid option!");
    }

    private boolean askRepeat(String entity) {
        System.out.println("\nDo you want to add another "+entity+"?");
        System.out.println("1) Yes - 2) No\n");
        System.out.println("Select: ");

        int option = readInt();

        return option == 1;
    }

    private int readInt() {
        int value = sc.nextInt();
        sc.nextLine();

        return value;
    }

    private String readString() {
        return sc.nextLine().trim();
    }

    private void clearScreen() {
        for(int i = 0; i < 40; i++) {
            System.out.println();
        }
    }

    private void printAccountHeader(Account a){
        System.out.println("\n=== ACCOUNT: " + a.getUsername()+" ===");
        System.out.println("Game: "+game.getName() + "\n");
    }
}