package DeckOfCards;

public class Main {
    public static void main(String[] args) {
        CardSuits[] suits = CardSuits.values();
        System.out.println("Card Suits:");

        for (CardSuits suit : suits) {
            System.out.println("Ordinal value: " + suit.ordinal() + "; Name value: " + suit);
        }
    }
}
