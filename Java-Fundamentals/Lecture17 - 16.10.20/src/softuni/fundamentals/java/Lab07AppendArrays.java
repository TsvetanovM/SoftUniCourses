package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lab07AppendArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] inputArray = input.split("\\|");
        List<String> inputList = new ArrayList<>();
        for (int i = inputArray.length - 1; i >= 0; i--) {
            String[] current = inputArray[i].split(" +");
            inputList.addAll(Arrays.asList(current));
        }
        int index = 0;
        while (index<inputList.size()) {
            if (inputList.get(index).isEmpty()){
                inputList.remove(index);
            }
            else {
                index++;
            }
        }
        for (String s : inputList) {
                System.out.print(s + " ");
        }
    }
}
//        List<Character> print = new ArrayList<>();
//        String temp = "";
//        for (String s : inputArray) {
//            temp += s;
//        }
//        char[] charArray = temp.toCharArray();
//        int arrayStart = 0;
//        for (int i = 0; i < charArray.length; i++) {
//            if (charArray[i] == '|' || i == charArray.length - 1) {
//                if (i==charArray.length-1){
//                    print.add(charArray[i]);
//                }
//                for (int j = i - 1; j >= arrayStart; j--) {
//                    print.add(charArray[j]);
//                }
//                arrayStart = i + 1;
//            }
//        }
//        for (int i = print.size() - 1; i >= 0; i--) {
//            System.out.print(print.get(i)+ " ");
//        }
//        List<String> inputList = Arrays.asList(temp.split("\\|"));
//        for (int i = inputList.size() - 1; i >= 0; i--) {
//            char[] current = inputList.get(i).toCharArray();
//            for (char c : current) {
//                System.out.print(c+" ");
//            }
//        }