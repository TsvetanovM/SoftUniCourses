package softuni.fundamentals.java;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int biscuitsPerDay = Integer.parseInt(scan.nextLine());
        int workersCount = Integer.parseInt(scan.nextLine());
        int opposingFactory = Integer.parseInt(scan.nextLine());
        int totalBiscuits = 0;
        int dayCount = 0;
        for (int i = 0; i<30; i++){
            dayCount++;
            if (dayCount==3){
                double biscuitsToday = 0.75*biscuitsPerDay*workersCount;
                totalBiscuits += Math.floor(biscuitsToday);
                dayCount = 0;
            } else {
                totalBiscuits += workersCount * biscuitsPerDay;
            }
        }
        System.out.printf("You have produced %d biscuits for the past month.%n", totalBiscuits);
        double productionDifference = 0;
        if (totalBiscuits>opposingFactory){
           productionDifference = (totalBiscuits-opposingFactory)*1.0/opposingFactory*100;
            System.out.printf("You produce %.2f percent more biscuits.", productionDifference);
        }
        else {
            productionDifference = (opposingFactory-totalBiscuits)*1.0/opposingFactory*100;
            System.out.printf("You produce %.2f percent less biscuits.", productionDifference);
        }
    }
}
