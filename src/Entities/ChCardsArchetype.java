package Entities;

public class ChCardsArchetype {

    private String cardName;
    private String cardMessage;
    private int cardEffect;
    private int cardAmount;


    public ChCardsArchetype(String cardName, String cardMessage,  int cardEffect, int cardAmount) {
        this.cardName = cardName;
        this.cardEffect = cardEffect;
        this.cardMessage = cardMessage;
        this.cardAmount = cardAmount;

    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardMessage() {
        return cardMessage;
    }

    public void setCardMessage(String cardMessage) {
        this.cardMessage = cardMessage;
    }

    public int getCardEffect() {
        return cardEffect;
    }

    public void setCardEffect(int cardEffect) {
        this.cardEffect = cardEffect;
    }

    public int getCardAmount() {
        return cardAmount;
    }

    public void setCardAmount(int cardAmount) {
        this.cardAmount = cardAmount;
    }
}


