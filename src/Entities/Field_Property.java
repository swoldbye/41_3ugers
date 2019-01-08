package Entities;

public class Field_Property extends Field_Ownable {

    //Attributes
    private int housePrice;
    private int hotelPrice;
    private int houses;
    private int hotels;

    //Constructor
    public Field_Property(int fieldIndex, String fieldName, int price, int rent, int housePrice, int hotelPrice, int houses, int hotels) {
        super(fieldIndex, fieldName, price, rent);
        this.housePrice = housePrice;
        this.hotelPrice = hotelPrice;
        this.houses = houses;
        this.hotels = hotels;
    }


    //Getter & Setter methods
    public int getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(int housePrice) {
        this.housePrice = housePrice;
    }

    public int getHotelPrice() {
        return hotelPrice;
    }

    public void setHotelPrice(int hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    public int getHouses() {
        return houses;
    }

    public void setHouses(int houses) {
        this.houses = houses;
    }

    public int getHotels() {
        return hotels;
    }

    public void setHotels(int hotel) {
        this.hotels = hotel;
    }
}
