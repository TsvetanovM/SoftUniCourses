package softuni.fundamentals.java;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab03MergingLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> firstList = (Arrays.stream(scan.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList()));
        List<Double> secondList = (Arrays.stream(scan.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList()));
        List<Double> finalList = new ArrayList<>();
        int smallerList = Math.min(firstList.size(), secondList.size());
        int biggerList = Math.max(firstList.size(), secondList.size());
        int counter = 0;
        for (int i = 0; i < smallerList; i++) {
            finalList.add(firstList.get(i));
            finalList.add(secondList.get(i));
            counter++;
        }
        for (int i = counter; i < biggerList; i++) {
            if (biggerList == firstList.size()) {
                finalList.add(firstList.get(i));
            } else {
                finalList.add(secondList.get(i));
            }
        }
//        System.out.println(printNonStringList(finalList, " "));
        System.out.println(finalList.toString().replaceAll("[\\[\\],.0]", ""));
    }
}
