package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab09SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int startingYield = scan.nextInt();
        int totalYield = 0;
        int daysCounter = 0;
        for (int i = startingYield; i >= 100; i -= 10) {
            totalYield+=i;
            if (totalYield>=26){
                totalYield-=26;
            }
            daysCounter++;
        }
        if (totalYield>=26){
            totalYield-=26;
        }
        System.out.println(daysCounter);
        System.out.println(totalYield);
    }
}
