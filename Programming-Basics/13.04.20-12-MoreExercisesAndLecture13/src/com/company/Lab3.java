package com.company;

import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cargoCount = Integer.parseInt(scan.nextLine());
        double busCargo = 0;
        double truckCargo =0;
        double trainCargo =0;
        double totalPrice = 0;

        for (int i =1; i<=cargoCount; i++){
            int cargoWeight = Integer.parseInt(scan.nextLine());
            if (cargoWeight<=3){
                busCargo+=cargoWeight;
                totalPrice+= 200*cargoWeight;
            }
            else if (cargoWeight<=11){
                truckCargo+=cargoWeight;
                totalPrice+=175*cargoWeight;
            }
            else {
                trainCargo+=cargoWeight;
                totalPrice+=120*cargoWeight;
            }
        }
        double totalCargo = busCargo+trainCargo+truckCargo;
        double averagePrice = totalPrice/totalCargo;
        busCargo = busCargo/totalCargo*100;
        truckCargo = truckCargo/totalCargo*100;
        trainCargo = trainCargo/totalCargo*100;

        System.out.printf("%.2f%n%.2f%%%n%.2f%%%n%.2f%%", averagePrice, busCargo, truckCargo, trainCargo);
    }
}
