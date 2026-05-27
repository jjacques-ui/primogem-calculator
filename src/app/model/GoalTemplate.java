package app.model;

public class GoalTemplate{
    private String name;
    private int price;

    public GoalTemplate(String n, int p){
        this.name = n;
        this.price = p;
    }

    public int getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
}