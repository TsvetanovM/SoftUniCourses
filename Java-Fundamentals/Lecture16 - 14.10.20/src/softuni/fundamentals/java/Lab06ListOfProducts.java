package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lab06ListOfProducts {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<String> products = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            products.add(scan.nextLine());
        }
        Collections.sort(products);
        for (int i = 1; i<=products.size(); i++) {
            System.out.printf("%d.%s%n", i, products.get(i-1));
        }
    }
}
