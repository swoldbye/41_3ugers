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

}
