package InterfacesAndAbstraction;

import InterfacesAndAbstraction.ferrari.Car;
import InterfacesAndAbstraction.ferrari.Ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        Car ferrari = new Ferrari(name);

        System.out.println(ferrari.toString());
    }
}
