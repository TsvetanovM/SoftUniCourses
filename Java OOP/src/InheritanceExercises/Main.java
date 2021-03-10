package InheritanceExercises;

import InheritanceExercises.person.Child;
import InheritanceExercises.zoo.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Animal animal = new Animal("Marto");
        Mammal mammal = new Mammal("Acho");
        Snake snake = new Snake("Ivanina");

        System.out.println(animal.getName());
        System.out.println(mammal.getName());
        System.out.println(snake.getName());
     }
}
