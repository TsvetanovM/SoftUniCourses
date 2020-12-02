package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int losses = Integer.parseInt(scan.nextLine());
        double headsetPrice = Double.parseDouble(scan.nextLine());
        double mousePrice = Double.parseDouble(scan.nextLine());
        double keyboardPrice = Double.parseDouble(scan.nextLine());
        double displayPrice = Double.parseDouble(scan.nextLine());
        double totalExpense = 0;
        int keyboardCounter = 0;

        for (int i = 1; i<=losses; i++){
            boolean mouseThrashed = false;
            if (i%2==0){
                totalExpense+=headsetPrice;
                mouseThrashed = true;
            }
            if (i%3==0){
                totalExpense+=mousePrice;
                if (mouseThrashed){
                    totalExpense+=keyboardPrice;
                    keyboardCounter++;
                }
            }
            if (keyboardCounter == 2){
                keyboardCounter = 0;
                totalExpense+=displayPrice;
            }
        }
        System.out.printf("Rage expenses: %.2f lv.", totalExpense);
    }
}
