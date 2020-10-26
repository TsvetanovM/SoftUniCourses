package softuni.fundamentals.java;

import java.util.*;
import java.util.stream.Collectors;

public class OpinionPoll{
    String name;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    int age;
    OpinionPoll(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.name, this.age);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        List <OpinionPoll> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] currentPerson = scan.nextLine().split(" ");
            String name = currentPerson[0];
            int age = Integer.parseInt(currentPerson[1]);
            list.add(new OpinionPoll(name, age));
        }
        list.stream().filter(person -> person.getAge() > 30)
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(person -> System.out.println(person.toString()));
    }
}
