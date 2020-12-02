package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LivePractice {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        System.out.println(list.size());
        list.add(42);
        list.add(13);
        list.add(255);
        System.out.println(list.size());
        System.out.println(list.get(0));
        list.set(0, 5);
        list.remove(1);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
