package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab02Gauss {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List <Integer> initialList = (Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        initialList = gaussTrick(initialList);
        for (int number :initialList) {
            System.out.print(number + " ");
        }
    }

    public static List<Integer> gaussTrick (List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        int placeHolder = 0;
        boolean oddSize = false;

        if (list.size()%2!=0) {
            placeHolder = list.get(list.size()/2);
            list.remove(list.size()/2);
            oddSize = true;
        }
        for (int i = 0; i<list.size()/2; i++) {
            newList.add(list.get(i)+list.get(list.size()-1-i));
        }
        if (oddSize){
            newList.add(placeHolder);
        }
        return newList;
    }
}
