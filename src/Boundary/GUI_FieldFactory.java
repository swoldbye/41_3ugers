package Boundary;

import gui_fields.*;

import java.awt.Color;

public final class GUI_FieldFactory {
    private GUI_FieldFactory() {

    }

    public static GUI_Field[] fieldInitializer() {
        // Now contains the relevant strings for fields
        GUI_Field[] fields = new GUI_Field[40];
        int i = 0;
        int var2 = i + 1;
        //First color is fieldColor, Second color is fieldtext/name.


        fields[i] = new GUI_Start("Start", "Modtag: M2$", "Modtag M2$\nNår du passerer", Color.RED, Color.BLACK);
        fields[var2++] = new GUI_Street("Rødovrevej", "Pris:  1200", "Rødovrevej", "Leje: 50", new Color(75, 155, 225), Color.BLACK);
        fields[var2++] = new GUI_Chance("?", "Chance", "Prøv lykken!", new Color(240,230,140), Color.BLACK);
        fields[var2++] = new GUI_Street("Hvidovrevej", "Pris: 1200", "Hvidovrevej", "Leje: 50", new Color(75, 155, 225), Color.BLACK);
        fields[var2++] = new GUI_Tax("Indkomstskat", "Betal 4000", "", new Color(135, 206, 250), Color.BLACK);
        fields[var2++] = new GUI_Street("Scandlines 1", "4000", "Scandlines færge", "Leje: 500 for 1, 1000 for 2", new Color(255,105,180), Color.BLACK);
        fields[var2++] = new GUI_Street("Roskildevej", "Pris: 2000", "", "Leje: 100", new Color(255,165,0), Color.BLACK);
        fields[var2++] = new GUI_Chance("?", "Chance", "Prøv lykken!", new Color(240,230,140), Color.BLACK);
        fields[var2++] = new GUI_Street("Valdby Langgade", "Pris: 2000", "", "Leje: 100", new Color(255,165,0), Color.BLACK);
        fields[var2++] = new GUI_Street("Allégade", "Pris: 2400", "", "Leje: 150", new Color(255,165,0), Color.BLACK);
        fields[var2++] = new GUI_Jail("default", "Fængsel", "Fængsel", "På besøg", new Color(125, 125, 125), Color.BLACK);
        fields[var2++] = new GUI_Street("Frederiksberg allé", "Pris: 2800", "", "Leje: 200", new Color(173,255,47), Color.BLACK);
        fields[var2++] = new GUI_Brewery("default", "Tuborg Squash", "Pris:  3000", "Tuborg Squash", "100 x [Terningslag]", new Color(220,50,50), Color.WHITE);
        fields[var2++] = new GUI_Street("Bülowsvej", "Pris: 2800", "", "Leje: 200", new Color(173,255,47), Color.BLACK);
        fields[var2++] = new GUI_Street("Gl kongevej", "Pris: 3200", "", "Leje: 250", new Color(173,255,47), Color.BLACK);
        fields[var2++] = new GUI_Street("Molslinjen", "4000", "Mols færge", "Leje: 500 for 1, 1000 for 2", new Color(255,105,180), Color.BLACK);
        fields[var2++] = new GUI_Street("Bernstorffsvej", "Pris: 3600", "", "Leje: 300", new Color(169,169,169), Color.BLACK);
        fields[var2++] = new GUI_Chance("?", "Chance", "Prøv lykken!", new Color(240,230,140), Color.BLACK);
        fields[var2++] = new GUI_Street("Hellerupvej", "Pris: 3600", "", "Leje: 300", new Color(169,169,169), Color.BLACK);
        fields[var2++] = new GUI_Street("Strandvejen", "Pris: 4000", "", "Leje: 350", new Color(169,169,169), Color.BLACK);
        fields[var2++] = new GUI_Street("Parkering", "", "", "", new Color(255,255,255), Color.BLACK);
        fields[var2++] = new GUI_Street("Trianglen", "Pris: 4400", "", "Leje: 350", new Color(220,50,50), Color.BLACK);
        fields[var2++] = new GUI_Chance("?", "Chance", "Prøv lykken!", new Color(240,230,140), Color.BLACK);
        fields[var2++] = new GUI_Street("Østerbrogade", "Pris: 4400", "", "Leje: 350", new Color(220,50,50), Color.BLACK);
        fields[var2++] = new GUI_Street("Grønningen", "Pris: 4800", "", "Leje: 400", new Color(220,50,50), Color.BLACK);
        fields[var2++] = new GUI_Street("Scandlines 2", "4000", "Scandlines færge", "Leje: 500 for 1, 1000 for 2", new Color(255,105,180), Color.BLACK);
        fields[var2++] = new GUI_Street("Bredgade", "Pris: 5200", "", "Leje: 450", new Color(255,255,255), Color.BLACK);
        fields[var2++] = new GUI_Street("Kgs. Nytorv", "Pris: 5200", "", "Leje: 450", new Color(255,255,255), Color.BLACK);
        fields[var2++] = new GUI_Brewery("default", "Coca Cola", "Pris:  3000", "Coca Cola", "100 x [Terningslag]", new Color(220,50,50), Color.WHITE);
        fields[var2++] = new GUI_Street("Østergade", "Pris: 5600", "", "Leje: 500", new Color(255,255,255), Color.BLACK);
        fields[var2++] = new GUI_Jail("default", "Du Fænglses", "Fængsel", "", new Color(0, 0, 0), Color.WHITE);
        fields[var2++] = new GUI_Street("Amagertorv", "Pris: 6000", "", "Leje: 550", new Color(255,255,51), Color.BLACK);
        fields[var2++] = new GUI_Street("Vimmelskaftet", "Pris: 6000", "", "Leje: 550", new Color(255,255,51), Color.BLACK);
        fields[var2++] = new GUI_Chance("?", "Chance", "Prøv lykken!", new Color(240,230,140), Color.BLACK);
        fields[var2++] = new GUI_Street("Nygade", "Pris: 6400", "", "Leje: 600", new Color(255,255,51), Color.BLACK);
        fields[var2++] = new GUI_Street("Scandlines 3", "4000", "Scandlines færge", "Leje: 500 for 1, 1000 for 2", new Color(255,105,180), Color.BLACK);
        fields[var2++] = new GUI_Chance("?", "Chance", "Prøv lykken!", new Color(240,230,140), Color.BLACK);
        fields[var2++] = new GUI_Street("Frederiksberggade", "Pris: 7000", "", "Leje: 700", new Color(186,85,211), Color.BLACK);
        fields[var2++] = new GUI_Tax("Ekstraordinær statsskat", "Betal 2000", "", new Color(255,255,255), Color.BLACK);
        fields[var2++] = new GUI_Street("Rådhuspladsen", "Pris: 8000", "", "Leje: 1000", new Color(186,85,211), Color.BLACK);
        return fields;
    }
}
