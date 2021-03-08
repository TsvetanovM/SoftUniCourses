package EncapsulationExercises;

public class Dough {
    private static final int BASE_CALORIES_PER_GRAM = 2;
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (isInvalidFlour(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (isInvalidBakingTechnique(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private boolean isInvalidFlour(String name) {
        return !name.equals("White") && !name.equals("Wholegrain");
    }

    private boolean isInvalidBakingTechnique(String name) {
        return !name.equals("Crispy") && !name.equals("Chewy") && !name.equals("Homemade");
    }

    public double calculateCalories() {
       return weight * BASE_CALORIES_PER_GRAM *
               DoughTypes.valueOf(flourType.toUpperCase()).getModifier()
               * DoughTypes.valueOf(bakingTechnique.toUpperCase()).getModifier();
    }
}
