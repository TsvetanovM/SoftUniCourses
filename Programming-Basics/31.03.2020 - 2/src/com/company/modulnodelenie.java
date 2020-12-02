package com.company;

public class modulnodelenie {
    public static void main(String[] args) {

        //int a = 7;
        //int b = 2;
        //int product = a % b;

        //System.out.println(product);

        //System.out.println(5 % 2);
        //System.out.println(10 % 3);
        //System.out.println(5 % 13);
        //System.out.println(4 % 19);
        //System.out.println(-3 % -10);//kogato i dvete chisla sa otricatelno, ni hvurlq otricatelen ostatuk.
        // System.out.println(3 % -10);// kogato samo ednoto e otricatelno, go prevrushta avtomatichno v polojitelno.
        // System.out.println(-3 % 11);
        // System.out.println(-10 % -2);

        int number = 1234;

        System.out.println(number % 10); // 4 - samo edinicite;
        System.out.println(number % 100); // 34 - desetici;
        System.out.println(number % 1000); // 234 - stotici;
    }
}
