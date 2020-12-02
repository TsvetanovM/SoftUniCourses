package com.company;

import java.util.Scanner;

public class JivotPromenliva {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double a = 0.0;
        String currentday = "Monday";

        if (currentday.equals("Monday")) {
            //double b = Double.parseDouble(scan.nextLine()); // kogato deklarirame promenliva v sub blockove, tq ne sushtestvuva izvun nego.
            a = Double.parseDouble(scan.nextLine()); // kogato smenqme stoinost na veche deklarirana promenliva v if block, promenite se zapazvat za celiq psvm.
        }
        System.out.println(a); // printira novata stoinost zadadena w if blocka.
        //System.out.println(b); // ne moje da printira b tui kato promenlivata e vuvedena v sub-blocka if, a sout a izvun nego.
    }
}
