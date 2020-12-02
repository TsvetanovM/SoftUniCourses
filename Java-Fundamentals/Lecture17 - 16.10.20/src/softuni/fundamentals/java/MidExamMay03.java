package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MidExamMay03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] array = scan.nextLine().split("\\s+");
        List<Integer> list = new ArrayList<>();
        for (String s : array) {
            list.add(Integer.parseInt(s));
        }
        int totalValue = 0;
        for (Integer integer : list) {
            totalValue+=integer;
        }
        double averageValue = totalValue*1.0/list.size();
        Collections.sort(list);
        Collections.reverse(list);
        int counter = 0;
        for (Integer integer : list) {
            if (integer>averageValue){
                System.out.print(integer+" ");
                counter++;
            }
            if (counter==5){
                break;
            }
        }
        if (counter == 0){
            System.out.println("No");
        }
    }
}
