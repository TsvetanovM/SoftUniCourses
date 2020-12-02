package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Lab8 {

        //Трябва да се пресметне колко литра вода ще събира аквариума, ако се знае, че определен процент от вместимостта
        // му е заета от пясък, растения, нагревател и помпа.
        //Един литър вода се равнява на един кубичен дециметър/ 1л=1 дм3/.
        // Да се напише програма, която изчислява литрите вода, която са необходими за напълването на аквариума.
        //vuvejdane ot konzola: duljina, shirochina i visochina(celi chisla) v sm i procent zaetost;
        // otpechatvane ot konzola - •	литрите вода, които ще  събира аквариума, форматирани до третия знак след десетичната запетая.

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            int a = Integer.parseInt(scan.nextLine());
            int b = Integer.parseInt(scan.nextLine());
            int c = Integer.parseInt(scan.nextLine());
            double procent1 = Double.parseDouble(scan.nextLine());

            int area = a * b * c;
            double volume = area * 0.001;
            double procent2 = procent1 * 0.01;
            double total = volume * (1 - procent2);

            //DecimalFormat df = new DecimalFormat("#.000");
            //System.out.println(df.format(total));

            System.out.printf("%.3f", total);



    }
}
