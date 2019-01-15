package Entities;

public class FieldList { //Information Expert Class

    public FieldList() {
    }

    public static Field_Abstract[] createFieldList() {

        // Now contains the relevant strings for fields
        Field_Abstract[] fields = new Field_Abstract[40];
        int i = 0;
        int var2 = i + 1;

        //First color is fieldColor, Second color is fieldtext/name..
        fields[i] = new Field_Empty(1, "Start");
        fields[var2++] = new Field_Property(2,"Rødovrevej", 1200, 50,1,-1,2,2000,0,0, 0);
        fields[var2++] = new Field_Chance(3, "Chance");
        fields[var2++] = new Field_Property(4,"Hvidovrevej", 1200, 50,1,-1,2,2000,0,0, 0);
        fields[var2++] = new Field_Tax(5,"Skat 1",4000);
        fields[var2++] = new Field_Shipping(6,"Båd 1",4000,500,2, -1, 4);
        fields[var2++] = new Field_Property(7,"Roskildevej", 2000,150,3,-1, 3,2000,0,0, 0);
        fields[var2++] = new Field_Chance(8, "Chance");
        fields[var2++] = new Field_Property(9,"Valby Langade", 2000,100,3,-1, 3,2000,0,0, 0);
        fields[var2++] = new Field_Property(10,"Allégade",2400,150,3,-1,3,2000,0,0, 0);
        fields[var2++] = new Field_Jail(11, "På besøg");
        fields[var2++] = new Field_Property(12,"Frederikberg allé",2800, 200, 4,-1, 3,2000,0,0, 0);
        fields[var2++] = new Field_Soda(13,"Tuborg Squash", 3000,100, 5, -1, 2);
        fields[var2++] = new Field_Property(14,"Bülowsvej", 2800, 200, 4,-1,3,2000,0,0, 0);
        fields[var2++] = new Field_Property(15, "Gl. Kongevej", 3200,250, 4,-1,3,2000,0,0, 0);
        fields[var2++] = new Field_Shipping(16, "Båd 2", 4000, 500, 2, -1, 4);
        fields[var2++] = new Field_Property(17,"Bernstorffsvej",3600,300, 6,-1,3, 3000,0,0, 0);
        fields[var2++] = new Field_Chance(18,"Chance");
        fields[var2++] = new Field_Property(19,"Hellerupvej", 3600,300,6,-1,3,3000,0,0, 0);
        fields[var2++] = new Field_Property(20,"Strandvejen",4000,350,6,-1,3,3000,0,0, 0);
        fields[var2++] = new Field_Empty(21,"Parkering");
        fields[var2++] = new Field_Property(22,"Trianglen", 4400, 350, 7, -1, 3,3000,0,0, 0);
        fields[var2++] = new Field_Chance(23, "Chance");
        fields[var2++] = new Field_Property(24,"Østerbrogade",4400, 350, 7, -1, 3,3000,0,0, 0);
        fields[var2++] = new Field_Property(25,"Grønningnen",4800,400,7, -1, 3,3000,0,0, 0);
        fields[var2++] = new Field_Shipping(26,"Båd 3", 4000, 500,2,-1, 4);
        fields[var2++] = new Field_Property(27,"Bredgade", 5200, 450, 8, -1,3,3000,0,0, 0);
        fields[var2++] = new Field_Property(28,"Kgs. Nytorv", 5200, 450, 8, -1,3,3000,0,0, 0);
        fields[var2++] = new Field_Soda(29,"Coca Cola",3000, 100,5, -1, 2);
        fields[var2++] = new Field_Property(30,"Østergade",5600,500,8, -1,3,3000,0,0, 0);
        fields[var2++] = new Field_Jail(31,"Gå i fængsel");
        fields[var2++] = new Field_Property(32,"Amagertorv",6000,550,9,-1,3, 4000,0,0, 0);
        fields[var2++] = new Field_Property(33,"Vimmelskaftet",6000,500,9,-1,3, 4000,0,0, 0);
        fields[var2++] = new Field_Chance(34,"Chance");
        fields[var2++] = new Field_Property(35,"Nygade", 6400,600,9,-1,3, 4000,0,0, 0);
        fields[var2++] = new Field_Shipping(36,"Båd 4",4000,500,2, -1, 4);
        fields[var2++] = new Field_Chance(37,"Chance");
        fields[var2++] = new Field_Property(38,"Frederiksberggade",7000,700, 10, -1,2, 4000,0,0, 0);
        fields[var2++] = new Field_Tax(39,"Skat 2", 2000);
        fields[var2++] = new Field_Property(40, "Rådhuspladsen", 8000, 1000, 10, -1,2, 4000,0,0, 0);
        return fields;
    }

}
