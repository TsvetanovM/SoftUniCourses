package Encapsulation.Holiday;

public enum Season {
    Autumn(1),
    Spring(2),
    Winter(3),
    Summer(4);

    private int priceMultiplier;

    Season(int priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
    }

    public int getPriceMultiplier() {
        return priceMultiplier;
    }
}
