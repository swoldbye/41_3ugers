package Entities;

public abstract class Field_Abstract {

    //Attributes
    protected int fieldIndex;
    protected String fieldName;

    //Abstract constructor
    public Field_Abstract(int fieldIndex, String fieldName) {
        this.fieldIndex = fieldIndex;
        this.fieldName = fieldName;
    }


    //Getter & Setter methods
    public int getFieldIndex() {
        return fieldIndex;
    }

    public void setFieldIndex(int fieldIndex) {
        this.fieldIndex = fieldIndex;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public int getOwnership() // OBS !!!! Hvis der er 6 spillere sker der en stackoverflow error når den første spiller krydser start
    { return getOwnership(); }
    // Fejlen referer tilbage til denne get metode???

    public void setOwnership(int ownership) { }

    public int getPrice() {
        return getPrice();
    }

    public int getRent(){return getRent();}

    public abstract int getGroup();

    public abstract int getGroupSize();

    public abstract int getHotels();

    public abstract int getHouses();

    public abstract void setHouses(int houseAmount);

    public abstract int setHotels();

    public abstract int getHousePrice();

}
