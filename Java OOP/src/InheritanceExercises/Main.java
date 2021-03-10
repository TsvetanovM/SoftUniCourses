package InheritanceExercises;

import InheritanceExercises.vehicle.*;
import InheritanceExercises.vehicle.Vehicle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Vehicle raceMotorcycle = new SportCar(100, 350);

        raceMotorcycle.drive(5);

        System.out.println(raceMotorcycle.getFuel());
     }
}
