package Entities;

public class Field_Chance extends Field_Abstract {


    //Constructor
    public Field_Chance(int fieldIndex, String fieldName) {
        super(fieldIndex, fieldName);
    }

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
