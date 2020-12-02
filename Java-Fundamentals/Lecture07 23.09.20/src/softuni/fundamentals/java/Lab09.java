package softuni.fundamentals.java;

import java.math.BigDecimal;
import java.util.Scanner;

public class Lab09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int centuries = scan.nextInt();
        int years = centuries*100;
        int days = (int) (years*365.2422);
        int hours = days*24;
        long minutes = hours*60L;
        System.out.printf("%d centuries = %d years = %d days = %d hours = %d minutes", centuries, years, days, hours, minutes);
    }
}
