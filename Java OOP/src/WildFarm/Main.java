package WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Mammal> animals = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] animalInfo = input.split("\\s+");
            String type = animalInfo[0];
            String name = animalInfo[1];
            double weight = Double.parseDouble(animalInfo[2]);
            String livingRegion = animalInfo[3];
            Mammal animal;

            switch (type) {
                case "Cat":
                    String breed = animalInfo[4];
                    animal = new Cat(type, name, weight, livingRegion, breed);
                    break;
                case "Tiger":
                    animal = new Tiger(type, name, weight, livingRegion);
                    break;
                case "Zebra":
                    animal = new Zebra(type, name, weight, livingRegion);
                    break;
                case "Mouse":
                    animal = new Mouse(type, name, weight, livingRegion);
                    break;
                default:
                    throw new IllegalStateException("Not an animal");
            }

            String[] foodInfo = scanner.nextLine().split("\\s+");
            String foodType = foodInfo[0];
            int foodAmount = Integer.parseInt(foodInfo[1]);
            Food food = (foodType.equals("Vegetable")) ? new Vegetable(foodAmount) : new Meat(foodAmount);

            animal.makeSound();
            animal.eat(food);

            animals.add(animal);

            input = scanner.nextLine();
        }

        for (Mammal animal : animals) {
            System.out.println(animal.toString());
        }
    }
}
