package InheritanceExercises;

import InheritanceExercises.animals.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String animal = scanner.nextLine();

        while (!animal.equals("Beast!")) {
            String[] tokens = scanner.nextLine().split("\\s+");
            switch (animal) {
                case "Dog":
                    Dog dog = new Dog(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                    printAnimal(dog);
                    break;
                case "Cat":
                    Cat cat = new Cat(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                    printAnimal(cat);
                    break;
                case "Frog":
                    Frog frog = new Frog(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                    printAnimal(frog);
                    break;
                case "Kitten":
                    Kitten kitten = new Kitten(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                    printAnimal(kitten);
                    break;
                case "Tomcat":
                    Tomcat tomcat = new Tomcat(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                    printAnimal(tomcat);
                    break;
            }
            animal = scanner.nextLine();
        }
    }

    public static void printAnimal(Animal animal) {
        System.out.println(animal.obtainClass());
        System.out.println(animal.toString());
        System.out.println(animal.produceSound());
    }
}
