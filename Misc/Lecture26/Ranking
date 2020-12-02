package softuni.fundamentals.java;

import com.sun.source.tree.Tree;

import java.util.*;

public class ME01Ranking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> contestBook = new HashMap<>();
        String input = scan.nextLine();

        while (!input.equals("end of contests")){
            String[] command = input.split(":");
            contestBook.put(command[0], command[1]);
            input = scan.nextLine();
        }

        List<Student> results = new ArrayList<>();
        input = scan.nextLine();

        while (!input.equals("end of submissions")){
            String[] tokens = input.split("=>");
            String contest = tokens[0];
            String password = tokens[1];
            String user = tokens[2];
            int points = Integer.parseInt(tokens[3]);
            boolean validAuth = false;
            for (Map.Entry<String, String> entry : contestBook.entrySet()) {
                if (entry.getKey().equals(contest)){
                    if (entry.getValue().equals(password)){
                        validAuth = true;
                    }
                    break;
                }
            }
            if (validAuth){
                boolean registeredStudent = false;
                for (Student result : results) {
                    if (result.getName().equals(user)){
                        registeredStudent = true;
                        result.getGrades().putIfAbsent(contest, points);
                        if (result.getGrades().get(contest)<points){
                            result.getGrades().put(contest, points);
                        }
                        break;
                    }
                }
                if (!registeredStudent){
                    Student student = new Student(user, contest, points);
                    results.add(student);
                }
            }
            input = scan.nextLine();
        }

        results.sort((e1, e2) -> e2.getBestPoints() - e1.getBestPoints());
        System.out.println("Best candidate is " + results.get(0).getName() + " with total " + results.get(0).getBestPoints() + " points." );
        System.out.println("Ranking: ");
        results.stream().
                sorted(Comparator.comparing(Student::getName))
                .forEach(e -> {
                    System.out.println(e.getName());
                    e.getGrades().entrySet()
                            .stream()
                            .sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                            .forEach(c -> System.out.printf("#  %s -> %d%n", c.getKey(), c.getValue()));
                });
    }
}

class Student {
    String name;
    TreeMap<String, Integer> grades = new TreeMap<>();

    public Student(String name, String contest, int points) {
        this.name = name;
        this.grades.put(contest, points);
    }

    public String getName() {
        return name;
    }

    public TreeMap<String, Integer> getGrades() {
        return grades;
    }

    public int getBestPoints() {
        int maxPoints = 0;
        for (Map.Entry<String, Integer> entry : getGrades().entrySet()) {
            maxPoints+= entry.getValue();
        }
        return maxPoints;
    }
}
