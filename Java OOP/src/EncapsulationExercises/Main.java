package EncapsulationExercises;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] pizzaInput = scanner.nextLine().split("\\s+");
        String pizzaName = pizzaInput[1];
        int numberOfToppings = Integer.parseInt(pizzaInput[2]);

        Pizza pizza = new Pizza(pizzaName, numberOfToppings);

        String[] doughInput = scanner.nextLine().split("\\s+");
        String flourType = doughInput[1];
        String bakingTechnique = doughInput[2];
        double doughWeight = Double.parseDouble(doughInput[3]);

        Dough dough = new Dough(flourType, bakingTechnique, doughWeight);
        pizza.setDough(dough);

        String toppingInput = scanner.nextLine();
        while (!toppingInput.equals("END")) {
            String[] tokens = toppingInput.split("\\s+");
            String toppingType = tokens[1];
            double toppingWeight = Double.parseDouble(tokens[2]);
            Topping topping = new Topping(toppingType, toppingWeight);
            pizza.addTopping(topping);
            toppingInput = scanner.nextLine();
        }

        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
    }
}
