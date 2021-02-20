package dealership;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Dealership {
    public String name;
    public int capacity;
    public List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.capacity > 0) {
            this.data.add(car);
            this.capacity--;
        }
    }

    public boolean buy(String manufacturer, String model) {
        boolean carExists = this.data.removeIf(car -> car.getManufacturer().equals(manufacturer)
                && car.getModel().equals(model));
        if (carExists) {
            capacity++;
        }
        return carExists;
    }

    public Car getLatestCar() {
        if (data.isEmpty()) {
            return null;
        }
        List<Car> collect = this.data.stream()
                .sorted((c1, c2) -> Integer.compare(c2.getYear(), c1.getYear()))
                .limit(1)
                .collect(Collectors.toList());
        return collect.get(0);
    }

    public Car getCar(String manufacturer, String model) {
        Predicate<Car> carExists = c -> c.getManufacturer().equals(manufacturer) &&
                c.getModel().equals(model);

        if (this.data.stream().anyMatch(carExists)) {
            List<Car> collect = this.data.stream()
                    .filter(carExists).collect(Collectors.toList());
            return collect.get(0);
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The cars in a car dealership ").append(this.name).append(":");
        sb.append(System.lineSeparator());
        for (Car car : data) {
            sb.append(car.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
