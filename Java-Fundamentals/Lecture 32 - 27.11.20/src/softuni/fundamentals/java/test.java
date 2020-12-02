package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        String input = "G!32e%o7r#32g$235@!2e";
        String nameFinder = input.replaceAll("[^A-Za-z]", "");
        System.out.println(nameFinder);
    }
}
