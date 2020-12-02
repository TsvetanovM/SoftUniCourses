package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BonusTaskMergingListGradually {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> firstList = (Arrays.stream(scan.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList()));
        List<Double> secondList = (Arrays.stream(scan.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList()));
        List<Double> finalList = new ArrayList<>();
        int indexFirst = 0;
        int indexSecond = 0;

        while (indexFirst<firstList.size() || indexSecond<secondList.size()) {
            if (indexFirst>=firstList.size()){
                finalList.add(secondList.get(indexSecond++));
                continue;
            }
            if (indexSecond>=secondList.size()){
                finalList.add(firstList.get(indexFirst++));
                continue;
            }
            if (firstList.get(indexFirst)<=secondList.get(indexSecond)) {
                finalList.add(firstList.get(indexFirst++));
            }
            else {
                finalList.add(secondList.get(indexSecond++));
            }
        }
        System.out.println(finalList.toString().replaceAll("[\\[\\],.0]", ""));
    }
}
