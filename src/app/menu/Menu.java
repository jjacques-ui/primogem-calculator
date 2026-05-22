package app.menu;

import app.model.Account;
import app.model.Game;
import app.model.RewardSource;
import app.model.Goal;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    private Game game;
    

    public Menu(Game g){
        this.game = g;
    }

    public void start() {
        int option;

        do {
            showGameMenu();

            option = sc.nextInt();

            switch(option) {

                case 1:
                    showMainMenu();
                    break;

                case 0:
                System.out.println("Closing...");
                break;

            default:
                System.out.println("Invalid option!");
                break;
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
            System.out.println("\n=== PRIMO CALC ===");
            System.out.println("\n1)Check accounts");
            System.out.println("2)Config game");
            System.out.println("0)Back");
            System.out.println("Select: ");

            option = sc.nextInt();

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
                System.out.println("Invalid option!");
                break;
            }

        } while(option != 0);
    }

    private void gameConfigMenu(){
        int option;

        do {
            System.out.println("\n=== GAME CONFIG ===");
            System.out.println("Game: "+game.getName());
            System.out.println("\n1)Add new reward source");
            System.out.println("2)Add new pulling goal");
            System.out.println("3)Add new account");
            System.out.println("0)Back");
            System.out.println("Select: ");

            option = sc.nextInt();

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
                System.out.println("Invalid option!");
                break;
                
            }

        } while(option != 0);
    }

    private void createRewardSource(){
        int option;

        do {
            System.out.println("Name the reward source: ");
            String name = sc.nextLine();

            System.out.println("Reward amount: ");
            int reward = sc.nextInt();

            RewardSource rS = new RewardSource(name, reward);

            game.getAvailableRewards().add(rS);

            System.out.println("\nReward created!");
            System.out.println(name+" - "+reward+"✦");
            System.out.println("\nDo you want to add another reward source?");
            System.out.println("1) Yes - 2) No");
            System.out.println("Select: ");

            option = sc.nextInt();

            switch(option) {

                case 1:
                    System.out.println("\nRepitindo processo!\n");
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
                
            }
        } while(option != 2);
    }
    private void createGoal(){
        int option;

        do {
            System.out.println("Name the reward source: ");
            String name = sc.nextLine();

            System.out.println("Goal price: ");
            int price = sc.nextInt();

            Goal g = new Goal(name, price);

            game.getAvailableGoals().add(g);

            System.out.println("\nGoal created!");
            System.out.println(name+" - "+price+"✦");
            System.out.println("\nDo you want to add another pulling goal?");
            System.out.println("1) Yes - 2) No");
            System.out.println("Select: ");

            option = sc.nextInt();

            switch(option) {

                case 1:
                    System.out.println("\nRepitindo processo!\n");
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
                
            }

        } while(option != 2);
    }
    private void createAccount(){
        int option;

        do {
            System.out.println("Account's username: ");
            String username = sc.nextLine();

            System.out.println("Current primogem balance: ");
            int balance = sc.nextInt();

            System.out.println("Current banner pity: ");
            int pity = sc.nextInt();

            Account a = new Account(username, balance, pity);

            game.getAccounts().add(a);

            System.out.println("\nAccount created!");
            System.out.println(username+" - "+balance+"✦ - Pity: "+pity);
            System.out.println("\nDo you want to add another account?");
            System.out.println("1) Yes - 2) No");
            System.out.println("Select: ");

            option = sc.nextInt();

            switch(option) {

                case 1:
                    System.out.println("\nRepitindo processo!\n");
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
                
            }

        } while(option != 2);
    }

    private void checkAccountsMenu(){
        int option;
        ArrayList<Account> accounts = game.getAccounts();

        do {
            System.out.println("\n=== CHECK ACCOUNTS ===");
            System.out.println("Game: "+game.getName()+"\n");
            for(int i = 0; i < accounts.size(); i++) {
                System.out.println((i+1)+") "+accounts.get(i).getUsername());
            }
            System.out.println("0) Back");
            System.out.println("Select: ");

            option = sc.nextInt();

            if(option > 0 && option <= accounts.size()) {
                
                Account selected = accounts.get(option-1);
                accountMenu(selected);
            } else if (option == 0) {
                break;
            } else {
                System.out.println("Invalid option!");
                break;
            }

        } while(option != 0);  
    }
    private void accountMenu(Account a){
        int option;

        do {
            System.out.println("\n=== ACCOUNT: "+a.getUsername()+" ===");
            System.out.println("Game: "+game.getName()+"\n");
            System.out.println("1) Check reward sources list");
            System.out.println("2) Check progress");
            System.out.println("3) Set account's values");
            System.out.println("0) Back");
            System.out.println("Select: ");

            option = sc.nextInt();

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
                System.out.println("Invalid option!");
                break;
                
            }

        } while(option != 0);
    }
    private void rewardSourceListMenu(Account a){
        int option;
        ArrayList<RewardSource> rSources = a.getRewardSources();

        do {
            System.out.println("\n=== ACCOUNT: "+a.getUsername()+" ===");
            System.out.println("Game: "+game.getName()+"\n");

            for(int i = 0; i < rSources.size(); i++) {
                if(!rSources.get(i).isRedeemed()){
                    System.out.println((i+1)+") "+rSources.get(i).getName());
                }
            }

            System.out.println("0) Back");
            System.out.println("Select: ");

            option = sc.nextInt();

            if(option > 0 && option <= rSources.size()) {
                
                RewardSource selected = rSources.get(option-1);
                rewardSourceMenu(selected, a);
            } else if (option == 0) {
                break;
            } else {
                System.out.println("Invalid option!");
                break;
            }

        } while(option != 0);
    }
    private void rewardSourceMenu(RewardSource r, Account a){
        int option;

        do {
            System.out.println("\n=== SOURCE: "+r.getName()+" ===");
            System.out.println("Game: "+game.getName()+"\n");

            System.out.println(r.getName()+" - "+r.getReward());

            if (r.isRedeemed()) {
                System.out.println("\n1)Unmark as redeemed");
            } else {            
                System.out.println("\n1)Mark as redeemed");
            }
            System.out.println("0) Back");
            System.out.println("Select: ");

            option = sc.nextInt();

            switch(option) {

                case 1:
                    redeemUnredeem(r, a);
                    break;
                case 0: 
                    break;
                default:
                System.out.println("Invalid option!");
                break;
            }
        } while(option != 0);
    }

    private void redeemUnredeem(RewardSource r, Account a){
        int option;

            System.out.println("Does this affect your balance?");
            System.out.println("1) Yes - 2) No");
            System.out.println("Select: ");

            option = sc.nextInt();

            if (r.isRedeemed()) {
                r.setRedeemed(false);
            } else {            
                r.setRedeemed(true);
            }

            switch (option) {
                case 1:
                    if (r.isRedeemed()) {
                        a.sum(r.getReward());
                    } else {            
                        a.subtract(r.getReward());
                    }
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
    }
    private void progressMenu(Account a){
        int option;
        int remain = a.getCurrentGoal().getPrice() - a.getBalance() - (a.getPity() * 160);

        do {
            System.out.println("\n=== ACCOUNT: "+a.getUsername()+" ===");
            System.out.println("Game: "+game.getName()+"\n");
            System.out.println("Progress - "+a.getProgressPercentage()+"%");
            System.out.println("Balance: "+a.getBalance()+"✦("+toWishes(a.getBalance())+"wishes)");
            System.out.println("Goal: "+a.getCurrentGoal().getPrice()+"✦("+toWishes(a.getCurrentGoal().getPrice())+"wishes)");
            System.out.println("\nRemaining: "+remain+"✦("+toWishes(remain)+"wishes)");
            System.out.println("\nAvaiable rewards: "+a.getAllRewards()+"✦("+toWishes(a.getAllRewards())+"wishes)");

            System.out.println("0) Back");
            System.out.println("Select: ");

            option = sc.nextInt();

            if(option == 0){
                break;
            } else {
                System.out.println("Invalid option!");
                break;
            }           

        } while(option != 0);
    }

    private void editAccountMenu(Account a) {
        int option;

        do {
            System.out.println("\n=== ACCOUNT: "+a.getUsername()+" ===");
            System.out.println("\n1)Set currency balance");
            System.out.println("2)Set current pity");
            System.out.println("3)Set current objective");
            System.out.println("0)Back");
            System.out.println("Select: ");

            option = sc.nextInt();

            switch(option) {

                case 1:
                    System.out.println("Current balance: ");
                    int b = sc.nextInt();
                    a.setBalance(b);
                    break;
                case 2:
                    System.out.println("Current pity: ");
                    int p = sc.nextInt();
                    a.setPity(p);
                    break;
                case 3:
                    pickCurrentGoal(a);
                    break;
                case 0:
                    break;
                default:
                System.out.println("Invalid option!");
                break;
            }

        } while(option != 0);
    }

    private void pickCurrentGoal(Account a){
        int option;
        ArrayList<Goal> goals = game.getAvailableGoals();

        do {
            System.out.println("\n=== AVAIABLE GOALS ===");
            System.out.println("Game: "+game.getName()+"\n");
            for(int i = 0; i < goals.size(); i++) {
                System.out.println((i+1)+") "+goals.get(i).getName());
            }
            System.out.println("0) Back");
            System.out.println("Select: ");

            option = sc.nextInt();

            if(option > 0 && option <= goals.size()) {
                a.setCurrentGoal(goals.get(option-1));
            } else if (option == 0) {
                break;
            } else {
                System.out.println("Invalid option!");
                break;
            }
        } while(option != 0);  
    }

    private int toWishes(int p){
        return (int) p / 160;
    }
}