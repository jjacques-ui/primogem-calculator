package primocalc.model;

public class GoalTemplate{
    private String name;
    private int price;

    //Constructors
    public GoalTemplate(){
    }
    public GoalTemplate(String n, int p){
        this.name = n;
        this.price = p;
    }

    //Getters
    public int getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
    
    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}