package Entities;
import Entities.ChCardsArchetype;
import gui_fields.GUI_Chance;


public class ChCardsList {
    public ChCardsList() {
    }


    public static ChCardsArchetype[] createChCardList() {
        // Now contains the relevant strings for fields
        ChCardsArchetype[] cards = new ChCardsArchetype[40];
        int i = 0;





        cards[i++] = new ChCardsArchetype("Chance", "De har vundet i klasse lotteriet. Modtag kr. 500", 1, 500);
        cards[i++] = new ChCardsArchetype("Chance", "Deres præmieobligation er udtrukket. de modtager kr. 1000 af banken.", 1, 1000);
        cards[i++] = new ChCardsArchetype("Chance", "De havde en række med elleve rigtige i tipning. Modtag kr. 1000.", 1, 1000);
        cards[i++] = new ChCardsArchetype("Chance", "Deres præmieobligation er udtrukket. De modtager kr. 1000 af banken.", 1, 1000);
        cards[i++] = new ChCardsArchetype("Chance", "De har vundet i Klasseloterriet. Modtag kr. 500.", 1, 500);
        cards[i++] = new ChCardsArchetype("Chance", "Modtag udbytte af Deres aktier - kr. 1000.", 1, 1000);
        cards[i++] = new ChCardsArchetype("Chance", "Betal for vognvask og smøring kr. 300", 1, -300);
        cards[i++] = new ChCardsArchetype("Chance", "Betal kr.200 for levering af 2 kasser øl.", 1, -200);
        cards[i++] = new ChCardsArchetype("Chance", "Værdien af egen fra nyttehaven udgør kr. 200, som De modtager af banken.", 1, 200);
        cards[i++] = new ChCardsArchetype("Chance", "Betal kr. 3000 for reparation af Deres vogn.", 1, -3000);
        cards[i++] = new ChCardsArchetype("Chance", "Betal Deres bilforsikring kr. 1000", 1, -1000);
        cards[i++] = new ChCardsArchetype("Chance", "De har solgt nogle gamle møbler på auktion. Modtag kr. 1000 af banken.", 1, 1000);
        cards[i++] = new ChCardsArchetype("Chance", "De modtager Deres aktieudbytte, modtag kr. 1000 af banken.", 1, 1000);
        cards[i++] = new ChCardsArchetype("Chance", "Grundet dyrtiden har de fået gageforhøjelse. modtag kr. 1000", 1, 1000);
        cards[i++] = new ChCardsArchetype("Chance", "De har købt 4 nye dæk til deres vogn. betal kr. 1000", 1, 1000);
        cards[i++] = new ChCardsArchetype("Chance", "Kommunen har eftergivet et kvartals skat. Hæv i banken kr. 3000", 1, 3000);
        cards[i++] = new ChCardsArchetype("Chance", "Modtag udbytte af Deres aktier - kr. 1000", 1, 1000);
        cards[i++] = new ChCardsArchetype("Chance", "De har fået en parkeringsbøde. betal kr. 200 i bøde", 1, -200);
        cards[i++] = new ChCardsArchetype("Chance", "Betal kr. 3000 for reparation af Deres vogn.", 1, 3000);
        cards[i++] = new ChCardsArchetype("Chance", "De har været en tur i udlandet og haft for mange cigaretter med hjem. Betal told kr. 200", 1, 200);
        cards[i++] = new ChCardsArchetype("Chance", "De har modtaget Deres tandlægeregning. Betal kr. 2000", 1, 2000);
        cards[i++] = new ChCardsArchetype("Chance", "De har kørt frem for \"Fuldt stop\". Betal kr. 1000 i bøde", 1, 1000);
        cards[i++] = new ChCardsArchetype("Chance", "Ryk tre felter tilbage.", 2, -3);
        cards[i++] = new ChCardsArchetype("Chance", "Ryk tre felter frem.", 2, 3);
        cards[i++] = new ChCardsArchetype("Chance", "Ryk tre felter tilbage", 2, -3);
        cards[i++] = new ChCardsArchetype("Chance", "Ryk frem til Vimmelskaftet. Hvis De passere \"START\", indkassér da kr. 4000.", 3, 32);
        cards[i++] = new ChCardsArchetype("Chance", "Ryk frem til Strandvejen. Hvis De passere \"START\", indkassér da kr. 4000", 3, 19);
        cards[i++] = new ChCardsArchetype("Chance", "Ryk frem til Frederiksberg Allé. Hvis De passere \"START\", indkassér da kr. 4000", 3, 11);
        cards[i++] = new ChCardsArchetype("Chance", "Tag med Mols-linen. Flyt brikken frem, og hvis De passere \"START\", indkassér da kr. 4000", 3, 15);
        cards[i++] = new ChCardsArchetype("Chance", "Tag ind på Rådhuspladsen.", 3, 39);
        cards[i++] = new ChCardsArchetype("Chance", "Ryk frem til Grønningen. Hvis De passere \"START\", indkassér da kr. 4000", 3, 24);
        cards[i++] = new ChCardsArchetype("Chance", "Ryk frem til \" START\".", 3, 0);
        cards[i++] = new ChCardsArchetype("Chance", "Ryk frem til \" START\".", 3, 0);
        cards[i++] = new ChCardsArchetype("Chance", "De har lagt penge ud til et sammenskudsgilde. Mærkeværdigvis betaler alle straks. Modtag fra hver medspiller kr. 500.", 4, 500);
        cards[i++] = new ChCardsArchetype("Chance", "De skal holde familiefest og får et tilskud fra hver medsipller på 500kr.", 4, 500);
        cards[i++] = new ChCardsArchetype("Chance", "Det er Deres fødselsdag. Modtag af hver medspiller kr. 200.", 4, 200);
        cards[i++] = new ChCardsArchetype("Chance", "Tag med den nærmeste færge. Flyt brikken frem, og hvis De passere \"Start\", indkasser da kr. 4000.", 5, 0);
        cards[i++] = new ChCardsArchetype("Chance", "Ryk brikken frem til det nærmeste rederi og betal ejeren to gange den leje, han eller er berettiget til. hvis selsakabet ikke ejes af nogen, kan de købe det af banken.", 5, 1);
        cards[i++] = new ChCardsArchetype("Chance", "Ryk brikken frem til det nærmeste rederi og betal ejeren to gange den leje, han eller er berettiget til. hvis selsakabet ikke ejes af nogen, kan de købe det af banken.", 5, 1);
        cards[i++] = new ChCardsArchetype("Chance", "I anledning af kongens fødselsdag benådes De herved for fængsel, Dette kort kan opbevares, indtil De får brug for det, eller de kan sælge det.", 6, 0);
        cards[i++] = new ChCardsArchetype("Chance", "I anledning af kongens fødselsdag benådes De herved for fængsel, Dette kort kan opbevares, indtil De får brug for det, eller de kan sælge det.", 6, 0);

        return cards;
    }}

