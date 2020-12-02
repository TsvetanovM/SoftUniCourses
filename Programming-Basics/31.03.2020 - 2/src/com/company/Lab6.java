package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args) {
        //Напишете програма, която пресмята нужните разходи за закупуването на храна за кучета.
        // Храната се пазарува основно за кучета, от зоомагазин, но понякога стопанинът им купува и за животните на съседа му.
        // Една опаковка храна за кучета е на цена 2.50лв., а всяка останала, която не е за тях струва 4лв.
        //От конзолата се четат 2 реда:
        //1.	Броят на кучетата – цяло число в интервала [0… 100]
        //2.	Броят на останалите животни  - цяло число в интервала [0… 100]
        //На конзолата се отпечатва:
        //"{крайната сума} lv."

        Scanner scan = new Scanner(System.in);
        int dogs = Integer.parseInt(scan.nextLine());
        int otherAnimals = Integer.parseInt(scan.nextLine());
        double dogPrice = 2.5;
        int otherPrice = 4;
        double total = dogs * dogPrice + otherAnimals * otherPrice;

        System.out.printf("%.2f lv.", total);
    }
}
