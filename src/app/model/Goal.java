package app.model;

public class Goal{
    private String name;
    private int price;

    public Goal(String n, int p){
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