package softuni.fundamentals.java;

import java.util.Arrays;
import java.util.Scanner;

public class Lab11ArrayManipulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split(" ")).
                mapToInt(e -> Integer.parseInt(e)).toArray();
        String input = scan.nextLine();
        while (!input.equals("end")) {
            String[] currentInput = input.split(" ");
            if (input.contains("exchange")) {
                int index = Integer.parseInt(currentInput[1]);
                if (index>=array.length||index<0) {
                    System.out.println("Invalid index");
                }
                else {
                    array = exchange(array, index);
                }
            }
            else if (input.contains("max")){
                maxNumber(array, currentInput[1]);
            }
            else if (input.contains("min")){
                minNumber(array, currentInput[1]);
            }
            else if (input.contains("first")){
                firstNumbers(array, Integer.parseInt(currentInput[1]), currentInput[2]);
            }
            else if (input.contains("last")) {
                lastNumbers(array, Integer.parseInt(currentInput[1]), currentInput[2]);
            }
            input = scan.nextLine();
        }
        System.out.println(Arrays.toString(array));
    }

    static int[] exchange(int[] array, int index) {
        int[] newArray = new int[array.length];
        int j = 0;
        for (int i = index+1; i < array.length; i++) {
            newArray[j]= array[i];
            j++;
        }
        for (int i = 0; i < index+1; i++) {
            newArray[j]= array[i];
            j++;
        }
       return newArray;
    }

    private static void maxNumber (int[] array, String type) {
        int index = -1;
        int max = Integer.MIN_VALUE;
        boolean matchFound = false;
        if (type.equals("odd")) {
            for (int i = 0; i < array.length; i++) {
                if (array[i]%2!=0 && array[i]>=max) {
                    max = array[i];
                    index = i;
                    matchFound = true;
                }
            }
        }
        else {
            for (int i = 0; i < array.length; i++) {
                if (array[i]%2==0 && array[i]>=max) {
                    max = array[i];
                    index = i;
                    matchFound = true;
                }
            }
        }
        if (!matchFound) {
            System.out.println("No matches");
        }
        else {
            System.out.println(index);
        }
    }

    public static void minNumber (int[] array, String type) {
        int index = -1;
        int min = Integer.MAX_VALUE;
        boolean matchFound = false;
        if (type.equals("odd")) {
            for (int i = 0; i < array.length; i++) {
                if (array[i]%2!=0 && array[i]<=min) {
                    min = array[i];
                    index = i;
                    matchFound = true;
                }
            }
        }
        else {
            for (int i = 0; i < array.length; i++) {
                if (array[i]%2==0 && array[i]<=min) {
                    min = array[i];
                    index = i;
                    matchFound = true;
                }
            }
        }
        if (!matchFound) {
            System.out.println("No matches");
        }
        else {
            System.out.println(index);
        }
    }

    static void firstNumbers (int[] array, int count, String type) {
        if (count>array.length){
            System.out.println("Invalid count");
        }
        else {
            int counter = 0;
            int[] printArray = new int[count];
            switch (type) {
                case "even":
                    for (int i = 0; i<array.length; i++) {
                        if (array[i] % 2 == 0) {
                            printArray[counter] = array[i];
                            counter++;
                            if (counter == count) {
                                break;
                            }
                        }
                    }
                    break;
                case "odd":
                    for (int i = 0; i<array.length; i++) {
                        if (array[i] % 2 != 0) {
                            printArray[counter] = array[i];
                            counter++;
                            if (counter == count) {
                                break;
                            }
                        }
                    }
                    break;
            }
            if (counter == 0) {
                System.out.print("[]");
            }
            else {
                System.out.print("[");
                for (int i = 0; i < printArray.length; i++) {
                    if (printArray[i]==0){
                        break;
                    }
                    if (i == 0) {
                        System.out.print(printArray[i]);
                    } else {
                        System.out.print(", " + printArray[i]);
                    }
                }
                System.out.print("]");
            }
            System.out.println();
        }
    }

    static void lastNumbers (int[] array, int count, String type) {
        if (count>array.length) {
            System.out.println("Invalid count");
        }
        else {
            int counter = 0;
            int[] printArray = new int[count];
            switch (type) {
                case "even":
                    for (int i = array.length-1; i >= 0 ; i--) {
                        if (array[i] % 2 == 0) {
                            printArray[counter] = array[i];
                            counter++;
                            if (counter == count) {
                                break;
                            }
                        }
                    }
                    break;
                case "odd":
                    for (int i = array.length-1; i >= 0 ; i--) {
                        if (array[i] % 2 != 0) {
                            printArray[counter] = array[i];
                            counter++;
                            if (counter == count) {
                                break;
                            }
                        }
                    }
                    break;
            }
            if (counter == 0) {
                System.out.print("[]");
            }
            else {
                boolean firstPrinted = false;
                System.out.print("[");
                for (int i = printArray.length-1; i>= 0; i--) {
                    if (printArray[i]==0){
                        continue;
                    }
                    if (!firstPrinted) {
                        System.out.print(printArray[i]);
                        firstPrinted = true;
                    }
                    else {
                        System.out.print(", " + printArray[i]);
                    }
                }
                System.out.print("]");
            }
            System.out.println();
        }
    }
}
