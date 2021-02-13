import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        Map<String, Car> allCars = new LinkedHashMap<>();

        while (N-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s");
            addCar(allCars, tokens);
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String model = tokens[1];
            int km = Integer.parseInt(tokens[2]);
            allCars.get(model).driveCar(km);
            input = scanner.nextLine();
        }
        for (Car car : allCars.values()) {
            System.out.println(car.toString());
        }
    }

    private static void addCar(Map<String, Car> allCars, String[] tokens) {
        String model = tokens[0];
        double fuelAmount = Double.parseDouble(tokens[1]);
        double fuelCost = Double.parseDouble(tokens[2]);
        allCars.put(model, new Car(model, fuelAmount, fuelCost));
    }
}
