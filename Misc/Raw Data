package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ME02RawData {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] data = scan.nextLine().split(" ");
            double[] specs = toDouble(data);
            cars.add(new Car(data[0], specs[0], specs[1], specs[2], data[4], specs[3], specs[4], specs[5],
                    specs[6], specs[7], specs[8], specs[9], specs[10]));
        }
        String type = scan.nextLine();
        List<Car> properCars = cars.stream().filter(car -> car.getCargo().getType().equals(type)).collect(Collectors.toList());

        switch (type) {
            case "fragile":
                for (Car car : properCars) {
                    double[] tires = car.getTires().tyreOrganizer();
                    for (int i = 0; i < tires.length; i++) {
                        if (tires[0] < 1) {
                            System.out.println(car.getModel());
                            break;
                        }
                    }
                }
                break;
            case "flamable":
                for (Car car : properCars) {
                    if (car.getEngine().getPower() > 250) {
                        System.out.println(car.getModel());
                    }
                }
                break;
        }
    }

    static double[] toDouble(String[] input) {
        double[] output = new double[input.length - 2];
        int j = 0;
        for (int i = 1; i < input.length; i++) {
            if (i == 4) {
                continue;
            }
            output[j] = Double.parseDouble(input[i]);
            j++;
        }
        return output;
    }
}

class Car {
    String model;
    Engine engine;
    Cargo cargo;
    Tires tires;

    public Car(String model, double engineSpeed, double enginePower, double cargoWeight, String cargoType, double tyre1P, double tyre1a,
               double tyre2p, double tyre2a, double tyre3p, double tyre3a, double tyre4p, double tyre4a) {
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        cargo = new Cargo(cargoWeight, cargoType);
        tires = new Tires(tyre1P, tyre2p, tyre3p, tyre4p, tyre1a, tyre2a, tyre3a, tyre4a);
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tires getTires() {
        return tires;
    }
}

class Engine {
    double speed;
    double power;

    Engine(double speed, double power) {
        this.speed = speed;
        this.power = power;
    }

    public double getPower() {
        return power;
    }
}

class Cargo {
    double weight;
    String type;

    public Cargo(double weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class Tires {
    double pressure1, pressure2, pressure3, pressure4;
    double age1, age2, age3, age4;

    public Tires(double pressure1, double pressure2, double pressure3, double pressure4, double age1, double age2, double age3, double age4) {
        this.pressure1 = pressure1;
        this.pressure2 = pressure2;
        this.pressure3 = pressure3;
        this.pressure4 = pressure4;
        this.age1 = age1;
        this.age2 = age2;
        this.age3 = age3;
        this.age4 = age4;
    }

    public double[] tyreOrganizer() {
        double[] tyreSet = new double[4];
        tyreSet[0] = this.pressure1;
        tyreSet[1] = this.pressure2;
        tyreSet[2] = this.pressure3;
        tyreSet[3] = this.pressure4;
        return tyreSet;
    }
}
