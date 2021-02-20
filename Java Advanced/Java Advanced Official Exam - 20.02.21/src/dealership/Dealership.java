package dealership;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Dealership {
    public String name;
    public int capacity;
    private Set<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        data = new LinkedHashSet<>();
    }

    public void add(Car car) {
        if (this.capacity > data.size()) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        return this.data.removeIf(car -> car.getManufacturer().equals(manufacturer)
                && car.getModel().equals(model));
    }

    public Car getLatestCar() {
        Car outputCar = null;
        for (Car car : data) {
            if (outputCar == null || outputCar.getYear() < car.getYear()) {
                outputCar = car;
            }
        }
        return outputCar;
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The cars in a car dealership ").append(this.name).append(":");
        for (Car car : data) {
            sb.append(System.lineSeparator());
            sb.append(car.toString());
        }
        return sb.toString();
    }
}
