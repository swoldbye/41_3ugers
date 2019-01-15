package GameLogic;
import Entities.Field_Abstract;
import Entities.PlayerArchetype;
import java.util.ArrayList;

public class L_PropertyManagement {

    public int[] ownsGroup(ArrayList<PlayerArchetype> playerArr, Field_Abstract[] fieldArr, int playerID){

        int g1 = 0;
        int g2 = 0;
        int g3 = 0;
        int g4 = 0;
        int g5 = 0;
        int g6 = 0;
        int g7 = 0;
        int g8 = 0;
        int g9 = 0;
        int g10 = 0;

        for (Field_Abstract field: fieldArr)
        {

            if (playerID == field.getOwnership())
            {
                switch (field.getGroup())
                {
                    case 1:
                        g1++;
                        break;

                    case 2:
                        g2++;
                        break;

                    case 3:
                        g3++;
                        break;

                    case 4:
                        g4++;
                        break;

                    case 5:
                        g5++;
                        break;

                    case 6:
                        g6++;
                        break;

                    case 7:
                        g7++;
                        break;

                    case 8:
                        g8++;
                        break;

                    case 9:
                        g9++;
                        break;

                    case 10:
                        g10++;
                        break;
                }

            }

        }

        int[] ideal = new int[]{2,4,3,3,2,3,3,3,3,2};
        int[] real = new int[]{g1,g2,g3,g4,g5,g6,g7,g8,g9,g10};


        int counter=0;
        for (int i = 0; i<10; i++)
        {
            if (real[i] == ideal[i])
            {
                counter++;

            }

        }

        int[] actuallyOwnedGroups = new int[counter];



        int numberOfGroups;

        int[] ownedGroups = new int[10];
        return ownedGroups;
    }
}
