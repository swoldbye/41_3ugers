package Entities;

public class FieldList { //Information Expert Class

    public static int[][] createGroupIndexes(){
        int groupIndexes[][] = new int[10][];
        groupIndexes[0] = new int[2];
        groupIndexes[1] = new int[4];
        groupIndexes[2] = new int[3];
        groupIndexes[3] = new int[3];
        groupIndexes[4] = new int[2];
        groupIndexes[5] = new int[3];
        groupIndexes[6] = new int[3];
        groupIndexes[7] = new int[3];
        groupIndexes[8] = new int[3];
        groupIndexes[9] = new int[2];

        groupIndexes[0][0]=1; groupIndexes[0][1]=3;
        groupIndexes[1][0]=5; groupIndexes[1][1]=15; groupIndexes[1][2]=25; groupIndexes[1][3]=35;
        groupIndexes[2][0]=6; groupIndexes[2][1]=8; groupIndexes[2][2]=9;
        groupIndexes[3][0]=11; groupIndexes[3][1]=13; groupIndexes[3][2]=14;
        groupIndexes[4][0]=12; groupIndexes[4][1]=28;
        groupIndexes[5][0]=16; groupIndexes[5][1]=18; groupIndexes[5][2]=19;
        groupIndexes[6][0]=21; groupIndexes[6][1]=23; groupIndexes[6][2]=24;
        groupIndexes[7][0]=26; groupIndexes[7][1]=27; groupIndexes[7][2]=29;
        groupIndexes[8][0]=31; groupIndexes[8][1]=32; groupIndexes[8][2]=34;
        groupIndexes[9][0]=37; groupIndexes[9][1]=39;
        return groupIndexes;
    }


    public static Field_Abstract[] createFieldList() {

        // Now contains the relevant strings for fields
        Field_Abstract[] fields = new Field_Abstract[40];
        int i = 0;
        int var2 = i + 1;

        //First color is fieldColor, Second color is fieldtext/name..
        fields[i] = new Field_Empty(1, "Start");
        fields[var2++] = new Field_Property(2,"Rødovrevej", 1200, 50,0,-1,2,1000,0,0, 0);
        fields[var2++] = new Field_Chance(3, "Chance");
        fields[var2++] = new Field_Property(4,"Hvidovrevej", 1200, 50,0,-1,2,1000,0,0, 0);
        fields[var2++] = new Field_Tax(5,"Skat 1",4000);
        fields[var2++] = new Field_Shipping(6,"Båd 1",4000,500,1, -1, 4);
        fields[var2++] = new Field_Property(7,"Roskildevej", 2000,150,2,-1, 3,1000,0,0, 0);
        fields[var2++] = new Field_Chance(8, "Chance");
        fields[var2++] = new Field_Property(9,"Valby Langade", 2000,100,2,-1, 3,1000,0,0, 0);
        fields[var2++] = new Field_Property(10,"Allégade",2400,150,2,-1,3,1000,0,0, 0);
        fields[var2++] = new Field_Jail(11, "På besøg");
        fields[var2++] = new Field_Property(12,"Frederikberg allé",2800, 200, 3,-1, 3,2000,0,0, 0);
        fields[var2++] = new Field_Soda(13,"Tuborg Squash", 3000,100, 4, -1, 2);
        fields[var2++] = new Field_Property(14,"Bülowsvej", 2800, 200, 3,-1,3,2000,0,0, 0);
        fields[var2++] = new Field_Property(15, "Gl. Kongevej", 3200,250, 3,-1,3,2000,0,0, 0);
        fields[var2++] = new Field_Shipping(16, "Båd 2", 4000, 500, 1, -1, 4);
        fields[var2++] = new Field_Property(17,"Bernstorffsvej",3600,300, 5,-1,3, 2000,0,0, 0);
        fields[var2++] = new Field_Chance(18,"Chance");
        fields[var2++] = new Field_Property(19,"Hellerupvej", 3600,300,5,-1,3,2000,0,0, 0);
        fields[var2++] = new Field_Property(20,"Strandvejen",4000,350,5,-1,3,2000,0,0, 0);
        fields[var2++] = new Field_Empty(21,"Parkering");
        fields[var2++] = new Field_Property(22,"Trianglen", 4400, 350, 6, -1, 3,3000,0,0, 0);
        fields[var2++] = new Field_Chance(23, "Chance");
        fields[var2++] = new Field_Property(24,"Østerbrogade",4400, 350, 6, -1, 3,3000,0,0, 0);
        fields[var2++] = new Field_Property(25,"Grønningnen",4800,400,6, -1, 3,3000,0,0, 0);
        fields[var2++] = new Field_Shipping(26,"Båd 3", 4000, 500,1,-1, 4);
        fields[var2++] = new Field_Property(27,"Bredgade", 5200, 450, 7, -1,3,3000,0,0, 0);
        fields[var2++] = new Field_Property(28,"Kgs. Nytorv", 5200, 450, 7, -1,3,3000,0,0, 0);
        fields[var2++] = new Field_Soda(29,"Coca Cola",3000, 100,4, -1, 2);
        fields[var2++] = new Field_Property(30,"Østergade",5600,500,7, -1,3,3000,0,0, 0);
        fields[var2++] = new Field_Jail(31,"Gå i fængsel");
        fields[var2++] = new Field_Property(32,"Amagertorv",6000,550,8,-1,3, 4000,0,0, 0);
        fields[var2++] = new Field_Property(33,"Vimmelskaftet",6000,500,8,-1,3, 4000,0,0, 0);
        fields[var2++] = new Field_Chance(34,"Chance");
        fields[var2++] = new Field_Property(35,"Nygade", 6400,600,8,-1,3, 4000,0,0, 0);
        fields[var2++] = new Field_Shipping(36,"Båd 4",4000,500,1, -1, 4);
        fields[var2++] = new Field_Chance(37,"Chance");
        fields[var2++] = new Field_Property(38,"Frederiksberggade",7000,700, 9, -1,2, 4000,0,0, 0);
        fields[var2++] = new Field_Tax(39,"Skat 2", 2000);
        fields[var2++] = new Field_Property(40, "Rådhuspladsen", 8000, 1000, 9, -1,2, 4000,0,0, 0);
        return fields;
    }
}
