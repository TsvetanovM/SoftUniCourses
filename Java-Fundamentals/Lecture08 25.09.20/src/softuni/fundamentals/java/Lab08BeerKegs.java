package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab08BeerKegs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        double biggest = 0;
        String winner = "";
        for (int i = 0; i < n; i++) {
            String model = scan.nextLine();
            double radius = Double.parseDouble(scan.nextLine());
            int height = Integer.parseInt(scan.nextLine());
            double kegVolume = Math.PI*(radius*radius)*height;
            if (kegVolume>biggest){
                biggest = kegVolume;
                winner = model;
            }
        }
        System.out.println(winner);
    }
}
