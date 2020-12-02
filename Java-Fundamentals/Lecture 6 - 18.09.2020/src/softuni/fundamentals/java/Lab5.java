package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        String password = "";
        int attemptCounter = 0;
        boolean isLogged = true;
        for (int i = username.length() - 1; i >=0 ; i--) {
            password += username.charAt(i);
        }
        String input = scan.nextLine();
        while (!input.equals(password)){
            if (attemptCounter==3){
                System.out.println("User "+username+" blocked!");
                isLogged = false;
                break;
            }
            System.out.println("Incorrect password. Try again.");
            attemptCounter++;
            input = scan.nextLine();
        }
        if (isLogged){
            System.out.println("User "+username+" logged in.");
        }
    }
}
