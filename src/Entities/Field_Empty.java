package Entities;

public class Field_Empty extends Field_Abstract {

    //Constructor
    public Field_Empty(int fieldIndex, String fieldName) {
        super(fieldIndex, fieldName);
    }


    public int getOwnership() { return -1; }
}
