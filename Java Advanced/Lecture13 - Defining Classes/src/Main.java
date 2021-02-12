import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

        while (N-- > 0) {
            String[] carDetails = scanner.nextLine().split("\\s+");
            String brand = carDetails[0];
            String model = carDetails[1];
            int hp = Integer.parseInt(carDetails[2]);
            Car car = new Car(brand, model, hp);
            System.out.println(car.carInfo());
        }
    }
}
