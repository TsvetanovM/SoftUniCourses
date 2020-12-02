package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab11Snowballs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        int highestSnow = 0;
        int highestTime = 0;
        int highestQuality = 0;
        double highestValue = 0;
        for (int i = 0; i < N; i++) {
            int snowballSnow = Integer.parseInt(scan.nextLine());
            int snowballTime = Integer.parseInt(scan.nextLine());
            int snowballQuality = Integer.parseInt(scan.nextLine());
            double snowballValue = Math.pow ((double)snowballSnow/snowballTime, snowballQuality);
            if (snowballValue>highestValue){
                highestValue = snowballValue;
                highestSnow = snowballSnow;
                highestQuality = snowballQuality;
                highestTime = snowballTime;
            }
            if (N-1==i){
                System.out.printf("%d : %d = %.0f (%d)", highestSnow, highestTime, highestValue, highestQuality);
            }
        }
    }
}
