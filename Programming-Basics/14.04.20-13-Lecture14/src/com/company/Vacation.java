package com.company;

import java.util.Scanner;

public class Vacation {
    public double vacationMoney;
    public double currentMoney;
    Scanner scan = new Scanner(System.in);

    public void savingProcess(){
        vacationMoney = Double.parseDouble(scan.nextLine());
        currentMoney = Double.parseDouble(scan.nextLine());
        int spendingCounter = 0;
        int daysCounter = 0;
      while (currentMoney<vacationMoney){
          String action = scan.nextLine();
          double dailyAmount = Double.parseDouble(scan.nextLine());
          daysCounter++;
          if (action.equals("spend")){
              if (dailyAmount>currentMoney){
                  currentMoney = 0;
              }
              else {
                  currentMoney-=dailyAmount;
              }
              spendingCounter++;
              if (spendingCounter==5){
                  System.out.println("You can't save the money.");
                  System.out.println(daysCounter);
                  break;
              }
          }
          else if (action.equals("save")){
              currentMoney+=dailyAmount;
              spendingCounter = 0;
          }
      }
      if (spendingCounter!=5){
          System.out.println("You saved the money for " + daysCounter + " days.");
      }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Vacation vac = new Vacation();
        vac.savingProcess();
    }
}
