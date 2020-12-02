package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab05MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String largeNumber = scan.nextLine().replaceFirst("^0+","");
        int smallNumber = Integer.parseInt(scan.nextLine());
        if (smallNumber==0){
            System.out.println("0");
        } else {
            int leftover = 0;
            StringBuilder product = new StringBuilder();
            for (int i = largeNumber.length() - 1; i >= 0; i--) {
                int num = largeNumber.charAt(i) - 48;
                int result = num * smallNumber + leftover;
                if (i == 0) {
                    product.insert(0, result);
                    break;
                }
                if (result > 9) {
                    leftover = result / 10;
                    result = result % 10;
                } else {
                    leftover = 0;
                }
                product.insert(0, result);
            }
            System.out.println(product.toString());
        }
    }
}
