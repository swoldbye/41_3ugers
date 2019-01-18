package Entities;

public class
Field_Ownable extends Field_Abstract{

    //Attributes
    protected int price;
    protected int rent;
    protected int group; // 1=blue, 2=docks, 3=green, 4=orange, 5=gray etc...
    protected int ownership;
    protected int groupSize;


    //Constructor
    public Field_Ownable(int fieldIndex, String fieldName, int price, int rent, int group, int ownership, int groupSize) {
        super(fieldIndex, fieldName);
        this.price = price;
        this.rent = rent;
        this.group = group;
        this.ownership = ownership;
        this.groupSize = groupSize;

    }

    //Getter & Setter methods
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRent() { return rent; }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getGroup() { return group; }

    public void setGroup(int group) { this.group = group; }

    public int getOwnership() { return ownership; }

    public void setOwnership(int ownership) { this.ownership = ownership; }

    public int getGroupSize() {
        return groupSize;
    }

    public int getHotels() {
        return 0;
    }

    public int getHouses() {
        return 0;
    }

    public void setHouses(int houseAmount) {

    }

    public int setHotels() {
        return 0;
    }

    public int getHousePrice() {
        return 0;
    }

    public void setGroupSize(int groupsize) {
        this.groupSize = groupSize;
    }


}
