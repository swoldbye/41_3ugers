package Entities;

public class Field_Tax extends Field_Abstract {

    //Attributes
    private int tax;

    //Constructor
    public Field_Tax(int fieldIndex, String fieldName, int tax) {
        super(fieldIndex, fieldName);
        this.tax = tax;
    }

    public int getOwnership() { return -1; }

    public int getGroup() {
        return -1;
    }

    public int getGroupSize() {
        return 0;
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

}
