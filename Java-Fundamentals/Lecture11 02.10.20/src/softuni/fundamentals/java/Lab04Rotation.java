package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab04Rotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String arrayInput = scan.nextLine();
        int numberOfRotations = scan.nextInt();
        String[] array1 = arrayInput.split(" ");
        String currentValue = "";
        String previousValue = array1[array1.length-1];
        for (int i = 0; i < numberOfRotations; i++) {
            for (int j = array1.length-1; j>=0; j--) {
                if (j!=0) {
                    currentValue = array1[j-1];
                    array1[j-1] = previousValue;
                }
                else {
                    array1[array1.length-1] = previousValue;
                }
                previousValue = currentValue;
            }
        }
        for (String number : array1){
            System.out.print(number + " ");
        }
    }
}
