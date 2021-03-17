package PolymorphismExercises.Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));

        String[] truckInfo = scanner.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));

        int N = Integer.parseInt(scanner.nextLine());

        while (N-- > 0) {
            String[] commandInfo = scanner.nextLine().split("\\s+");
            String command = commandInfo[0];
            String vehicleType = commandInfo[1];

            if (command.equals("Drive")) {
                double distance = Double.parseDouble(commandInfo[2]);
                if (vehicleType.equals("Car")) {
                    car.drive(distance);
                } else truck.drive(distance);
            } else {
                double liters = Double.parseDouble(commandInfo[2]);
                if (vehicleType.equals("Car")) {
                    car.refuel(liters);
                } else truck.refuel(liters);
            }
        }
        System.out.printf("Car: %.2f%nTruck: %.2f", car.getFuel(), truck.getFuel());
    }
}
