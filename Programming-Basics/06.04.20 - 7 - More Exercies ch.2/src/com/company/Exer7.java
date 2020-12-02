package com.company;

import java.util.Scanner;

public class Exer7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Мария иска да купи подарък на сина си. Тя работи в магазин за цветя. В магазина идва поръчка за цветя.
        // Напишете програма, която пресмята сумата от поръчката и дали печалбата е достатъчна за подаръка. Цветята имат следните цени:
        //•	Магнолии – 3.25 лева
        //•	Зюмбюли – 4 лева
        //•	Рози – 3.50 лева
        //•	Кактуси – 8 лева
        //От общата сума, Мария трябва да плати 5% данъци.
        int M = Integer.parseInt(scan.nextLine());
        int Z = Integer.parseInt(scan.nextLine());
        int R = Integer.parseInt(scan.nextLine());
        int K = Integer.parseInt(scan.nextLine());
        double GiftPrice = Double.parseDouble(scan.nextLine());

        double OrderIncome = (M*3.25+Z*4+R*3.50+K*8)*0.95;

        if (GiftPrice>OrderIncome){
            double MoneyNeeded = GiftPrice - OrderIncome;
            MoneyNeeded = Math.ceil(MoneyNeeded);
            System.out.printf("She will have to borrow %.0f leva.", MoneyNeeded);
        }
        else {
            double ExtraMoney = OrderIncome - GiftPrice;
            ExtraMoney = Math.floor(ExtraMoney);
            System.out.printf("She is left with %.0f leva.", ExtraMoney);
        }
    }
}
