package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>();
        test.add(6);
        test.add(2);
        test.add(2);
        System.out.println(test.size());
        test.add(3, 6);
        System.out.println(test.size());
    }
}
