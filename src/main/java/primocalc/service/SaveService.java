package primocalc.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import primocalc.model.Account;
import primocalc.model.GoalTemplate;
import primocalc.model.RewardTemplate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaveService {
    private final ObjectMapper mapper = new ObjectMapper();

    //JSON file handeling
    public void saveAccounts(List<Account> accounts) {

        try {
            mapper.writerWithDefaultPrettyPrinter()
            .writeValue(new File("accounts.json"), accounts);
            System.out.println("Accounts saved!");

        } catch (IOException e) {
            System.out.println("Error while saving accounts.");
            e.printStackTrace();
        }
    }

    public List<Account> loadAccounts() {

        try {
            return Arrays.asList(
                mapper.readValue(new File("accounts.json"), Account[].class)
            );

        } catch (IOException e) {
            System.out.println("Could not load accounts.");
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void saveRewardTemplates(List<RewardTemplate> rewardTemplates) {

        try {
            mapper.writerWithDefaultPrettyPrinter()
            .writeValue(new File("rewardTemplates.json"), rewardTemplates);
            System.out.println("Reward templates saved!");

        } catch (IOException e) {
            System.out.println("Error while saving reward templates.");
            e.printStackTrace();
        }
    }

    public List<RewardTemplate> loadRewardTemplates() {

        try {
            return Arrays.asList(
                mapper.readValue(new File("rewardTemplates.json"), RewardTemplate[].class)
            );

        } catch (IOException e) {
            System.out.println("Could not load reward templates.");
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void saveGoalTemplates(List<GoalTemplate> goalTemplates) {

        try {
            mapper.writerWithDefaultPrettyPrinter()
            .writeValue(new File("goalTemplates.json"), goalTemplates);
            System.out.println("Goal templates saved!");

        } catch (IOException e) {
            System.out.println("Error while saving goal templates.");
            e.printStackTrace();
        }
    }

    public List<GoalTemplate> loadGoalTemplates() {

        try {
            return Arrays.asList(
                mapper.readValue(new File("goalTemplates.json"), GoalTemplate[].class)
            );

        } catch (IOException e) {
            System.out.println("Could not load goal templates.");
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}