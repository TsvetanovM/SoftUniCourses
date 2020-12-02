package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab02CommonElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input1 = scan.nextLine();
        String input2 = scan.nextLine();
        String[] array1 = input1.split(" ");
        String[] array2 = input2.split(" ");

        for (String element : array2){
            for (String element2 : array1){
                if (element.equals(element2)){
                    System.out.print(element + " ");
                    break;
                }
            }
        }
    }
}
