package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab07WaterOverflow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int totalQuantity = 0;
        for (int i = 0; i < n; i++) {
            int currentQuantity = scan.nextInt();
            totalQuantity +=currentQuantity;
            if (totalQuantity>255){
                totalQuantity -= currentQuantity;
                System.out.println("Insufficient capacity!");
            }
        }
        System.out.println(totalQuantity);
    }
}
