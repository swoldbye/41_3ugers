package Boundary;

import gui_fields.GUI_Brewery;
import gui_fields.GUI_Chance;
import gui_fields.GUI_Field;
import gui_fields.GUI_Jail;
import gui_fields.GUI_Refuge;
import gui_fields.GUI_Shipping;
import gui_fields.GUI_Start;
import gui_fields.GUI_Street;
import gui_fields.GUI_Tax;
import java.awt.Color;

public final class GUI_FieldFactory {
    private GUI_FieldFactory() {

    }

    public static GUI_Field[] fieldInitializer() {
        // Now contains the relevant strings for fields
        GUI_Field[] fields = new GUI_Field[41];
        int i = 0;
        int var2 = i + 1;
        //First color is fieldColor, Second color is fieldtext/name.





        fields[i] = new GUI_Start("Start", "Modtag: M2$", "Modtag M2$\nNår du passerer", Color.RED, Color.BLACK);
        fields[var2++] = new GUI_Street("Burgerbaren", "Pris:  M1$", "Burgerbaren", "Leje: M1$", new Color(210, 105, 30), Color.BLACK);
        fields[var2++] = new GUI_Street("Pizzariaet", "Pris: M1$", "Pizzariaet", "Leje: M1$", new Color(210, 105, 30), Color.BLACK);
        fields[var2++] = new GUI_Chance("?", "Chance", "Prøv lykken!", new Color(75, 155, 225), Color.BLACK);
        fields[var2++] = new GUI_Street("Slikbutikken", "Pris: M1$", "Slikbutikken", "Leje: M1$", new Color(135, 206, 250), Color.BLACK);
        fields[var2++] = new GUI_Street("Iskiosken", "Pris: M1$", "Iskiosken", "Leje: M1$", new Color(135, 206, 250), Color.BLACK);
        fields[var2++] = new GUI_Jail("default", "Fængsel", "Fængsel", "På besøg", new Color(125, 125, 125), Color.BLACK);
        fields[var2++] = new GUI_Street("Museet", "Pris: M2$", "Museet", "Leje: M2$", new Color(221, 160, 221), Color.BLACK);
        fields[var2++] = new GUI_Street("Biblioteket", "Pris: M2$", "Biblioteket", "Leje: M2$", new Color(221, 160, 221), Color.BLACK);
        fields[var2++] = new GUI_Chance("?", "Chance", "Prøv lykken!", new Color(75, 155, 225), Color.BLACK);
        fields[var2++] = new GUI_Street("Skaterparken", "Pris: M2$", "Skaterparken", "Leje: M2$", new Color(255, 255, 102), Color.BLACK);
        fields[var2++] = new GUI_Street("Swimmingpoolen", "Pris: M2$", "Swimmingpoolen", "Leje: M2$", new Color(255, 255, 102), Color.BLACK);
        fields[var2++] = new GUI_Refuge("default", "Gratis Parkering", "Gratis parkering", "Ta' en pause", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Street("Spillehallen", "Pris: M3$", "Spillehallen", "Leje: M3$", new Color(255, 0, 0), Color.BLACK);
        fields[var2++] = new GUI_Street("Biografen", "Pris: M3$", "Biografen", "Leje: M3$", new Color(255, 0, 0), Color.BLACK);
        fields[var2++] = new GUI_Chance("?", "Chance", "Prøv lykken!", new Color(75, 155, 225), Color.BLACK);
        fields[var2++] = new GUI_Street("Legetøjsbutikken", "Pris: M3$", "Legetøjsbutikken", "Leje: M3$", new Color(255, 255, 0), Color.BLACK);
        fields[var2++] = new GUI_Street("Dyrehandleren", "Pris: M3$", "Dyrehandleren", "Leje: M3$", new Color(255, 255, 0), Color.BLACK);
        fields[var2++] = new GUI_Jail("default", "Gå i fængsel", "Gå i fængsel", "Du fængsles\n", new Color(125, 125, 125), Color.BLACK);
        fields[var2++] = new GUI_Street("Bowlinghallen", "Pris: M4$", "Bowlinghallen", "Leje: M4$", new Color(34, 139, 34), Color.BLACK);
        fields[var2++] = new GUI_Street("Zoo", "Pris: M4$", "Zoo", "Leje: M4$", new Color(34, 139, 34), Color.BLACK);
        fields[var2++] = new GUI_Chance("?", "Chance", "Prøv lykken!", new Color(75, 155, 225), Color.BLACK);
        fields[var2++] = new GUI_Street("Vandlandet", "Pris: M4$", "Vandlandet", "Leje: M4$", new Color(0, 191, 255), Color.BLACK);
        fields[var2++] = new GUI_Street("Strandpromenaden", "Pris: M4$", "Strandpromenaden", "Leje: M4$", new Color(0, 191, 255), Color.BLACK);
        fields[var2++] = new GUI_Street("Burgerbaren", "Pris:  M1$", "Burgerbaren", "Leje: M1$", new Color(210, 105, 30), Color.BLACK);
        fields[var2++] = new GUI_Street("Pizzariaet", "Pris: M1$", "Pizzariaet", "Leje: M1$", new Color(210, 105, 30), Color.BLACK);
        fields[var2++] = new GUI_Chance("?", "Chance", "Prøv lykken!", new Color(75, 155, 225), Color.BLACK);
        fields[var2++] = new GUI_Street("Slikbutikken", "Pris: M1$", "Slikbutikken", "Leje: M1$", new Color(135, 206, 250), Color.BLACK);
        fields[var2++] = new GUI_Street("Iskiosken", "Pris: M1$", "Iskiosken", "Leje: M1$", new Color(135, 206, 250), Color.BLACK);
        fields[var2++] = new GUI_Jail("default", "Fængsel", "Fængsel", "På besøg", new Color(125, 125, 125), Color.BLACK);
        fields[var2++] = new GUI_Street("Museet", "Pris: M2$", "Museet", "Leje: M2$", new Color(221, 160, 221), Color.BLACK);
        fields[var2++] = new GUI_Street("Biblioteket", "Pris: M2$", "Biblioteket", "Leje: M2$", new Color(221, 160, 221), Color.BLACK);
        fields[var2++] = new GUI_Chance("?", "Chance", "Prøv lykken!", new Color(75, 155, 225), Color.BLACK);
        fields[var2++] = new GUI_Street("Skaterparken", "Pris: M2$", "Skaterparken", "Leje: M2$", new Color(255, 255, 102), Color.BLACK);
        fields[var2++] = new GUI_Street("Swimmingpoolen", "Pris: M2$", "Swimmingpoolen", "Leje: M2$", new Color(255, 255, 102), Color.BLACK);
        fields[var2++] = new GUI_Refuge("default", "Gratis Parkering", "Gratis parkering", "Ta' en pause", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Street("Spillehallen", "Pris: M3$", "Spillehallen", "Leje: M3$", new Color(255, 0, 0), Color.BLACK);
        fields[var2++] = new GUI_Street("Biografen", "Pris: M3$", "Biografen", "Leje: M3$", new Color(255, 0, 0), Color.BLACK);
        fields[var2++] = new GUI_Chance("?", "Chance", "Prøv lykken!", new Color(75, 155, 225), Color.BLACK);
        fields[var2++] = new GUI_Street("Legetøjsbutikken", "Pris: M3$", "Legetøjsbutikken", "Leje: M3$", new Color(255, 255, 0), Color.BLACK);
        fields[var2++] = new GUI_Street("Dyrehandleren", "Pris: M3$", "Dyrehandleren", "Leje: M3$", new Color(255, 255, 0), Color.BLACK);

        return fields;
    }
}
