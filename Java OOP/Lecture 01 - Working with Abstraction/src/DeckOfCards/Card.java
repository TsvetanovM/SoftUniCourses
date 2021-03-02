package DeckOfCards;

public class Card {
    private final CardRank rank;
    private final CardSuit suit;

    public Card(String rank, String suit) {
        this.rank = CardRank.valueOf(rank.toUpperCase());
        this.suit = CardSuit.valueOf(suit.toUpperCase());
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                rank, suit, getCardPower());
    }

    private int getCardPower() {
        return rank.getPower() + suit.getPower();
    }
}
