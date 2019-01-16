package Entities;

public class Field_Jail extends Field_Abstract {


    //Constructor
    public Field_Jail(int fieldIndex, String fieldName) {
        super(fieldIndex, fieldName);
    }

    public int getOwnership() { return -1; }

    public int getGroup() {
        return 0;
    }


}
