package softuni.fundamentals.java;

import java.math.BigDecimal;
import java.util.Scanner;

public class Lab03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        BigDecimal sum = new BigDecimal(0);
        for (int i = 1; i<=n; i++){
            BigDecimal number = new BigDecimal(scan.nextLine());
            sum = sum.add(number);
        }
        System.out.println(sum);
    }
}
