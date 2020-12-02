package com.company;

public class zakruglqnedrobnichisla {
    public static void main(String[] args) {

        //double up = Math.ceil(26.22); // zakruglqne nagore = result 27;
        //double down = Math.floor(26.86); // zakruglqne nadolu = result 26;

        //System.out.println(up);
        //System.out.println(down);

        //int example1 = Math.abs(-44); // absolutna stoinost na chislo, rezultat: 44;
        //int example2 = Math.abs(44); // rezultat: 44;

        //System.out.println(example1);
        //System.out.println(example2);

        double a = 7.66666;

        System.out.println(Math.ceil(a));
        System.out.println(Math.floor(a));
        System.out.println(Math.abs(a));
        System.out.println(Math.round(a)); // round e standartno zakruglqne - ako e pod .5, nadolu, ako e nad - nagore;
        //System.out.printf("%.2f", a); // zakruglq do 2 simvola sled desetichnata zapetaq;
        System.out.printf("%.0f", a); // zakruglq do cqlo chislo;
        //System.out.printf("%.3f", a); // zakruglq do 2 simvola sled desetichnata zapetaq;
    }
}
