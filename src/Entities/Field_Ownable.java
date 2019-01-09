package Entities;

public class Field_Ownable extends Field_Abstract{

    //Attributes
    protected int price;
    protected int rent;
    protected int group; // 1=blue, 2=docks, 3=green, 4=orange, 5=gray etc...
    protected String ownership; //

    //Constructor
    public Field_Ownable(int fieldIndex, String fieldName, int price, int rent, int group, String ownership) {
        super(fieldIndex, fieldName);
        this.price = price;
        this.rent = rent;
        this.group = group;
        this.ownership = ownership;
    }

    //Getter & Setter methods
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getGroup() { return group; }

    public void setGroup(int group) { this.group = group; }

    public String getOwnership() { return ownership; }

    public void setOwnership(String ownership) { this.ownership = ownership; }
}
