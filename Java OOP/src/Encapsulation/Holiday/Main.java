package Encapsulation.Holiday;

import IOUtils.ConsoleReader;
import IOUtils.InputParser;

public class Main {
    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();
        String[] reservationInfo = InputParser.readArray(reader.readLine(), "\\s+");
        double pricePerDay = Double.parseDouble(reservationInfo[0]);
        int numberOfDays = Integer.parseInt(reservationInfo[1]);
        String season = reservationInfo[2];
        String discountType = reservationInfo[3];

        double holidayPrice = PriceCalculator.getTotalPrice(pricePerDay, numberOfDays, season, discountType);

        System.out.printf("%.2f", holidayPrice);
    }
}
