package primocalc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AccountGoal {
    private GoalTemplate template;
    private int quantity;

    //Constructors
    public AccountGoal() {
    }
    public AccountGoal(GoalTemplate t, int q) {
        this.template = t;
        this.quantity = q;
    }

    //Getters
    
    public int getQuantity() {
        return this.quantity;
    }
    public GoalTemplate getTemplate() {
        return template;
    }

    //Setters
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setTemplate(GoalTemplate template) {
        this.template = template;
    }

    @JsonIgnore
    public int getTotalPrice() {
        return (this.template.getPrice() * quantity);
    }

    @JsonIgnore
    public String getName() {
        return this.template.getName();
    }

    @JsonIgnore
    public int getPrice() {
        return this.template.getPrice();
    }
}