package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int age = scan.nextInt();
        String type;
        if (age<=2){
            type = "baby";
        }
        else if (age<=13){
            type = "child";
        }
        else if (age<=19){
            type = "teenager";
        }
        else if (age<=65){
            type = "adult";
        }
        else {
            type = "elder";
        }
        System.out.println(type);
    }
}
