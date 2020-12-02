package softuni.fundamentals.java;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> input = Arrays.stream(scan.nextLine().split(" "))
                .filter(w -> w.length()%2==0)
                .collect(Collectors.toList());
        for (String s : input) {
            System.out.println(s);
        }
    }
}
