package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab01Furniture {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String validator = ">>(?<furnitureName>\\w+)<<(?<price>\\d+(\\.?\\d+))!(?<quantity>\\d+)";
        List<String> furniture = new ArrayList<>();
        double totalPrice = 0.0;

        while (!input.equals("Purchase")){
            Pattern patt = Pattern.compile(validator);
            Matcher match = patt.matcher(input);

            if (match.find()){
                String name = match.group("furnitureName");
                double price = Double.parseDouble(match.group("price"));
                int quantity = Integer.parseInt(match.group("quantity"));
                furniture.add(name);
                totalPrice += price*quantity;
            }

            input = scan.nextLine();
        }
        System.out.println("Bought furniture:");
        for (String s : furniture) {
            System.out.println(s);
        }
        System.out.printf("Total money spend: %.2f", totalPrice);
    }
}
