package softuni.fundamentals.java;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lab05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> array = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
