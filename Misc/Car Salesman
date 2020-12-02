package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ME03CarSalesman {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        List<Engines> allEngines = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] engineData = scan.nextLine().split(" ");
            Engines currentEngine = new Engines(engineData[0], engineData[1]);
            if (engineData.length == 3) {
                String component = engineData[2];
                if (hasDigit(component)) {
                    currentEngine.setDisplacement(component);
                } else {
                    currentEngine.setEfficiency(component);
                }
            }
            if (engineData.length == 4) {
                currentEngine.setDisplacement(engineData[2]);
                currentEngine.setEfficiency(engineData[3]);
            }
            allEngines.add(currentEngine);
        }
        int M = Integer.parseInt(scan.nextLine());
        List<Cars> allCars = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String[] carData = scan.nextLine().split(" ");
            String engineModel = carData[1];
            Engines suitableEngine = new Engines();
            suitableEngine = findEngine(allEngines, suitableEngine, engineModel);
            Cars car = new Cars(carData[0], suitableEngine);
            if (carData.length==3){
                String component = carData[2];
                if (hasDigit(component)){
                    car.setWeight(component);
                }
                else {
                    car.setColor(component);
                }
            }
            if (carData.length==4){
                car.setWeight(carData[2]);
                car.setColor(carData[3]);
            }
            allCars.add(car);
        }

        for (Cars car : allCars) {
            System.out.println(car.toString());
        }
    }

    public static Engines findEngine(List<Engines> engines, Engines engine, String engineModel) {
        for (Engines value : engines) {
            if (value.getModel().equals(engineModel)) {
                engine = value;
                break;
            }
        }
        return engine;
    }

    public static boolean hasDigit(String line) {
        for (int j = 0; j < line.length(); j++) {
            if (Character.isDigit(line.charAt(j))) {
                return true;
            }
        }
        return false;
    }
}

class Cars {
    String model;
    Engines engine;
    String color = "n/a";
    String weight = "n/a";

    public Cars(String model, Engines engine) {
        this.model = model;
        this.engine = engine;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return  model + ":" + '\n' +
                engine.toString() +
                "Weight: " + weight + '\n' +
                "Color: " + color;
    }
}

class Engines {
    String model, power;
    String displacement = "n/a";
    String efficiency = "n/a";

    public Engines(String model, String power) {
        this.model = model;
        this.power = power;
    }

    public Engines() {
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return   model + ":" + '\n' +
                "Power: " + power + '\n' +
                "Displacement: " + displacement + '\n' +
                "Efficiency: " + efficiency + '\n';
    }
}
