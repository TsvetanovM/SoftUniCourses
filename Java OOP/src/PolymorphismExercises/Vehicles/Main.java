package PolymorphismExercises.Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]), Integer.parseInt(carInfo[3]));

        String[] truckInfo = scanner.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]), Integer.parseInt(truckInfo[3]));

        String[] busInfo = scanner.nextLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(busInfo[1]), Double.parseDouble(busInfo[2]), Integer.parseInt(busInfo[3]));

        int N = Integer.parseInt(scanner.nextLine());

        while (N-- > 0) {
            String[] commandInfo = scanner.nextLine().split("\\s+");
            String command = commandInfo[0];
            String vehicleType = commandInfo[1];
            double value = Double.parseDouble(commandInfo[2]);

            if (command.equals("Drive")) {
                if (vehicleType.equals("Car")) {
                    car.drive(value);
                } else if (vehicleType.equals("Truck")) {
                    truck.drive(value);
                } else {
                    bus.drive(value, false);
                }
            } else if (command.equals("Refuel")) {
                if (vehicleType.equals("Car")) {
                    car.refuel(value);
                } else if (vehicleType.equals("Truck")) {
                    truck.refuel(value);
                } else bus.refuel(value);
            } else bus.drive(value, true);
        }
        System.out.printf("Car: %.2f%nTruck: %.2f%nBus: %.2f", car.getFuel(), truck.getFuel(), bus.getFuel());
    }
}
