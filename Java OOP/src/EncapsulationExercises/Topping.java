package EncapsulationExercises;

public class Topping {
    private static final int BASE_CALORIES_PER_GRAM = 2;
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (!isValidTopping(toppingType)) {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return weight * BASE_CALORIES_PER_GRAM * ToppingTypes.valueOf(toppingType.toUpperCase()).getModifier();
    }

    private boolean isValidTopping(String topping) {
        return topping.equals("Meat") || topping.equals("Veggies")
                || topping.equals("Cheese") || topping.equals("Sauce");
    }
}
