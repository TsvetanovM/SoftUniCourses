import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Lab01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<String> parkingLot = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String[] action = input.split(",\\s+");
            String direction = action[0];
            String plateNumber = action[1];
            switch (direction) {
                case "IN":
                    parkingLot.add(plateNumber);
                    break;
                case "OUT":
                    parkingLot.remove(plateNumber);
                    break;
            }
            input = scanner.nextLine();

        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : parkingLot) {
                System.out.println(car);
            }
        }
    }
}
