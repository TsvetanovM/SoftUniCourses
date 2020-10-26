package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab06VehicleCatalogue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] vehicle = scan.nextLine().split(" ");
        List<Vehicle> catalogue = new ArrayList<>();
        while (!vehicle[0].equals("End")){
            catalogue.add(new Vehicle(vehicle[0], vehicle[1], vehicle[2], Integer.parseInt(vehicle[3])));
            vehicle = scan.nextLine().split(" ");
        }
        String model = scan.nextLine();
        while (!model.equals("Close the Catalogue")) {
            for (Vehicle v : catalogue) {
                if (v.getModel().equals(model)) {
                    System.out.println(v);
                    break;
                }
            }
            model = scan.nextLine();
        }
        int truckCounter = 0;
        int carCounter = 0;
        double truckHorsepower = 0;
        double carHorsepower = 0;
        for (Vehicle vehicle1 : catalogue) {
            if (vehicle1.getType().equals("Car")){
                carCounter++;
                carHorsepower+= vehicle1.getHorsepower();
                continue;
            }
            truckCounter++;
            truckHorsepower+=vehicle1.getHorsepower();
        }
        double averageTruckHP = 0;
        double averageCarHP = 0;
        if (truckCounter!=0) {
            averageTruckHP = truckHorsepower / truckCounter;
        }
        if (carCounter!=0){
            averageCarHP = carHorsepower / carCounter;
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n", averageCarHP);
        System.out.printf("Trucks have average horsepower of: %.2f.", averageTruckHP);
    }
}

class Vehicle{
    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    String type, model, color;
    int horsepower;

    public int getHorsepower() {
        return horsepower;
    }

    Vehicle(String type, String model, String color, int horsepower) {
        this.type = type.substring(0, 1).toUpperCase()+type.substring(1).toLowerCase();
        this.model= model;
        this.color = color;
        this.horsepower = horsepower;
    }

    @Override
    public String toString() {
        return "Type: " + this.type + "\n" +
                "Model: " + this.model + "\n" +
                "Color: " + this.color + "\n" +
                "Horsepower: " + this.horsepower;
    }
}
