package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Length: ");
        double length = Double.parseDouble(scanner.nextLine());
        System.out.print("Width: ");
        double width = Double.parseDouble(scanner.nextLine());
        System.out.print("Height: ");
        double height = Double.parseDouble(scanner.nextLine());
        double volume = (length*width/3)*height;
        System.out.printf("Pyramid Volume: %.2f", volume);
    }
}
