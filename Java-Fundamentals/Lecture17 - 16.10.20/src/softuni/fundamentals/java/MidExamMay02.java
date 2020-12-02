package softuni.fundamentals.java;

import java.util.Arrays;
import java.util.Scanner;

public class MidExamMay02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] input = scan.nextLine().split(" ");
        while (!input[0].equals("end")){
            String command = input[0];
            switch (command){
                case "swap":
                    int firstIndexValue = array[Integer.parseInt(input[1])];
                    array[Integer.parseInt(input[1])] = array[Integer.parseInt(input[2])];
                    array[Integer.parseInt(input[2])] = firstIndexValue;
                    break;
                case "multiply":
                    int result = array[Integer.parseInt(input[1])]*array[Integer.parseInt(input[2])];
                    array[Integer.parseInt(input[1])] = result;
                    break;
                case "decrease":
                    for (int i = 0; i < array.length; i++) {
                        array[i]--;
                    }
                    break;
            }
            input = scan.nextLine().split(" ");
        }
        for (int i=0; i<array.length; i++) {
            if (i<array.length-1) {
                System.out.print(array[i] + ", ");
                continue;
            }
            System.out.print(array[i]);
        }
    }
}
