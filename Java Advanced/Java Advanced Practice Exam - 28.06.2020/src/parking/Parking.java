package parking;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.capacity > 0) {
            this.data.add(car);
            this.capacity--;
        }
    }

    public boolean remove(String manufacturer, String model) {
        return this.data.removeIf(car -> car.getManufacturer().equals(manufacturer)
                && car.getModel().equals(model));
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
        String output = String.format("The cars are parked in %s:%n", this.type);
        for (Car car : data) {
            output += car.toString();
            output += String.format("%n");
        }
        return output;
    }
}
