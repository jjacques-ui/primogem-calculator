package app.model;

public class AccountGoal {
    private GoalTemplate template;
    private int quantity;

    public AccountGoal(GoalTemplate t, int q) {
        this.template = t;
        this.quantity = q;
    }

    public String getName() {
        return template.getName();
    }
    public int getPrice() {
        return template.getPrice();
    }
    public int getTotalPrice() {
        return template.getPrice() * quantity;
    }
    public int getQuantity() {
        return quantity;
    }
}
