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

    public int getOwnership() { return getOwnership();}

    public void setOwnership(int ownership) { }

    public int getPrice() {
        return getPrice();
    }

    public int getRent(){return getRent();}
}
