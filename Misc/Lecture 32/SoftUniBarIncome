package softuni.fundamentals.java;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab03SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String validator = "[^|$%.]*%(?<customerName>[A-Z][a-z]+)%[^|$%.]*<(?<productName>\\w+)>[^|$%.]*\\|(?<count>\\d+)\\|(\\d*[^|$%.\\d])*(?<price>\\d+\\.?\\d*)\\$";
        double totalIncome = 0.0;

        while (!input.equals("end of shift")){
            Pattern pattern = Pattern.compile(validator);
            Matcher match = pattern.matcher(input);
            if (match.find()){
                double totalPrice = Double.parseDouble(match.group("price")) * Integer.parseInt(match.group("count"));
                totalIncome += totalPrice;
                System.out.printf("%s: %s - %.2f%n", match.group("customerName"), match.group("productName"), totalPrice);
            }
            input = scan.nextLine();
        }
        System.out.printf("Total income: %.2f", totalIncome);
    }
}
