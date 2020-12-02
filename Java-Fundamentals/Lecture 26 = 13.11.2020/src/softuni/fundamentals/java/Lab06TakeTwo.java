package softuni.fundamentals.java;

import java.util.*;

public class Lab06TakeTwo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, List<String>> courses = new LinkedHashMap<>();

        while (!input.equals("end")){
            String[] currentLine = input.split(" :");
            String courseName = currentLine[0];
            String student = currentLine[1];
            courses.putIfAbsent(courseName, new ArrayList<>());
            courses.get(courseName).add(student);
            input = scan.nextLine();
        }

         courses.entrySet().stream()
                .sorted((c1, c2) -> Integer.compare(c2.getValue().size(), c1.getValue().size()))
                 .forEach(entry -> {
                     System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
                     entry.getValue().sort(String::compareTo);
                     for (String s : entry.getValue()) {
                         System.out.println("--" + s);
                     }
                 });
    }
}
