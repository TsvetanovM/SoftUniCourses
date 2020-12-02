package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab01Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfWagons = Integer.parseInt(scan.nextLine());
        int[] peopleInWagons = new int[numberOfWagons];
        int totalPeople = 0;
        for (int i = 0; i < peopleInWagons.length; i++) {
            peopleInWagons[i] = Integer.parseInt(scan.nextLine());
            totalPeople+= peopleInWagons[i];
        }
        for (int wagon : peopleInWagons) {
            System.out.print(wagon + " ");
        }
        System.out.println(" ");
        System.out.println(totalPeople);
    }
}
