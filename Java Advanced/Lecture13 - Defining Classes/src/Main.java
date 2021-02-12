import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        while (N-- > 0) {
            String[] carDetails = scanner.nextLine().split("\\s+");
            String brand = carDetails[0];
            if (carDetails.length>1) {
                String model = carDetails[1];
                int hp = Integer.parseInt(carDetails[2]);
                cars.add(new Car(brand, model, hp));
            } else {
                cars.add(new Car(brand));

            }
        }

        for (Car car : cars) {
            System.out.println(car.carInfo());
        }
    }
}
