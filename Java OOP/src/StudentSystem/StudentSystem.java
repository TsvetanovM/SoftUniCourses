package StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> studentsByName;

    public StudentSystem() {
        this.studentsByName = new HashMap<>();
    }

    public Map<String, Student> getStudentsByName() {
        return this.studentsByName;
    }

    public void ParseCommand(String[] args) {

        String command = args[0];
        String name = args[1];

        if (command.equals("Create")) {
            int age = Integer.parseInt(args[2]);
            double grade = Double.parseDouble(args[3]);
            studentsByName.putIfAbsent(name, new Student(name, age, grade));
        } else if (command.equals("Show")) {
            if (studentsByName.containsKey(name)) {
                Student student = studentsByName.get(name);
                System.out.println(student.toString());
            }
        }
    }
}
