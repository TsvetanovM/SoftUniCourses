package com.company;

import java.util.Scanner;

public class Lab7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Като за стените се използва зелена боя, а за покрива – червена. Разхода на зелената боя е 1 литър за 3.4 м2, а на червената – 1 литър за 4.3 м2.
        //Стените имат следните размери:
        //•	Предната и задната стена са квадрати със страна „x“
        //o	на предната стена има правоъгълна врата с широчина 1.2м и височина 2м
        //•	Страничните стени са правоъгълници със страни „x“ и „y“
        //o	и на двете странични стени има по един квадратен прозорец със страна 1.5м
        //Покривът има следните размери:
        //•	Два правоъгълника със страни „x“ и „y“
        //•	Два равностранни триъгълника със страна „x“ и височина „h“
        //Трябва да пресметнете площта на всички страни и площта на покрива, за да
        //намерите колко литра от всяка боя ще са нужни.
        // x - visochina na kushtata; y = duljina stranichna stena; h = visochina triugulna strana na pokriva;

        double x = Double.parseDouble(scan.next());
        double y = Double.parseDouble(scan.next());
        double h = Double.parseDouble(scan.next());

        double housearea = 2*(x*x) - 2.4 + 2*(x*y) - 4.5;
        double roofarea = 2*(x*y) + 2*(x*h/2);
        double houseprice = housearea/3.4;
        double roofprice = roofarea/4.3;

        System.out.printf("%.2f%n%.2f", houseprice, roofprice);
    }
}
