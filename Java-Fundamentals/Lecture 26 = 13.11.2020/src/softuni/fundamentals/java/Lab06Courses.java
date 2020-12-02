package softuni.fundamentals.java;

import java.util.*;
import java.util.stream.Collectors;

public class Lab06Courses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Course> courses = new ArrayList<>();
        boolean firstDone = false;

        while (!input.equals("end")){
            boolean studentAdded = false;
            String[] command = input.split(":");
            String courseName = command[0];
            String student = command[1];
            if (!firstDone) {
                courses.add(new Course(courseName));
                firstDone = true;
            }
            for (Course cours : courses) {
                if (cours.getName().equals(courseName)) {
                    cours.addStudent(student);
                    studentAdded = true;
                    break;
                }
            }
            if (!studentAdded){
                courses.add(new Course(courseName));
                courses.get(courses.size()-1).addStudent(student);
            }
            input = scan.nextLine();
        }
        courses.sort(Comparator.comparing(Course::getTotalStudents));

        for (Course course : courses) {
            System.out.println(course.getName() + ": " + course.getTotalStudents());
            course.students = course.students.stream().sorted().collect(Collectors.toList());
            for (String student : course.students) {
                System.out.println("-- " + student);
            }
        }
    }
}

class Course {
    String name;
    List<String> students;

    Course(String name) {
        this.name = name;
    }

    public void addStudent(String student) {
        this.students.add(student);
    }

    public String getName() {
        return name;
    }

    public int getTotalStudents() {
        return students.size();
    }
}
