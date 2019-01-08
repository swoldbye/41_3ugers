package Entities;

public class Field_Property extends Field_Abstract{

    private int price;
    private int rent;
    private int house;
    private int hotel;

    //Constructor
    public Field_Property(int fieldIndex, String fieldName, int price, int rent, int house, int hotel) {
        super(fieldIndex, fieldName);
        this.price = price;
        this.rent = rent;
        this.house = house;
        this.hotel = hotel;
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

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getHotel() {
        return hotel;
    }

    public void setHotel(int hotel) {
        this.hotel = hotel;
    }
}
