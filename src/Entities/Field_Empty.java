package Entities;

public class Field_Empty extends Field_Abstract {

    public Field_Empty(int fieldIndex, String fieldName) {
        super(fieldIndex, fieldName);
    }

    public int getGroup() {
        return -1;
    }


}
