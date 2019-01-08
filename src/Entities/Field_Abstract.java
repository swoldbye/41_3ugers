package Entities;

public class Field_Abstract {

    protected int fieldIndex;
    protected String fieldName;

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
}
