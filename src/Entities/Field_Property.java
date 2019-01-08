package Entities;

public class Field_Property extends Field_Abstract{

    //Attributes
    protected int price;
    protected int rent;

    //Constructor
    public Field_Property(int fieldIndex, String fieldName, int price, int rent, int house, int hotel) {
        super(fieldIndex, fieldName);
        this.price = price;
        this.rent = rent;
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

}
