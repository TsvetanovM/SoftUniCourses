package softuni.fundamentals.java;

import java.util.Scanner;

public class Lab06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input1 = scan.nextLine();
        String input2 = scan.nextLine();
        String[] line1 = input1.split(" ");
        String[] line2 = input2.split(" ");
        boolean identical = true;
        int indexDifference = line2.length-1;

        for (int i = 0; i < line1.length; i++) {
            if (!line1[i].equals(line2[i])){
               identical = false;
               indexDifference = i;
               break;
            }
        }
        int [] array1 = new int[line1.length];
        int sum = 0;

        for (int i = 0; i < array1.length; i++) {
            array1[i] = Integer.parseInt(line1[i]);
            sum+= array1[i];
        }
        if (!identical || line2.length>line1.length){
            System.out.printf("Arrays are not identical. Found difference at %d index.", indexDifference);
        }
        else {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}
