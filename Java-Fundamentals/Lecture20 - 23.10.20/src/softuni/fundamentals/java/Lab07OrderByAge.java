package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Lab07OrderByAge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] person = scan.nextLine().split(" ");
        List<Person> people = new ArrayList<>();
        while (!person[0].equals("End")){
            people.add(new Person(person[0], person[1], Integer.parseInt(person[2])));
            person = scan.nextLine().split(" ");
        }
        people.stream().sorted((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge())).forEach(System.out::println);
    }
}

class Person {
    String name;
    String ID;
    int age;

    public int getAge() {
        return age;
    }

    Person(String name, String ID, int age) {
        this.name = name;
        this.ID = ID;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s with ID: %s is %d years old.", this.name, this.ID, this.age);
    }
}
