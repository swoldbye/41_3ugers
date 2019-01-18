package Entities;

public class Field_Empty extends Field_Abstract {

    public Field_Empty(int fieldIndex, String fieldName) {
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
