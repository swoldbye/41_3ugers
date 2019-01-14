package Controllers;

import Entities.ChCardsArchetype;
import Entities.ChCardsList;

public class ChCardController {

    ChCardsList deck = new ChCardsList();
    ChCardsArchetype[] cardList = deck.createChCardList();


}
