package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab05Students {
    public String getFirstName() {
        return firstName;
    }

    String firstName;

    public String getLastName() {
        return lastName;
    }

    String lastName;

    public String getAge() {
        return age;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public void setAge(String age) {
        this.age = age;
    }

    String age;

    public String getHometown() {
        return hometown;
    }

    String hometown;

    Lab05Students(String[] studentInfo) {
        this.firstName = studentInfo[0];
        this.lastName = studentInfo[1];
        this.age = studentInfo[2];
        this.hometown = studentInfo[3];
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] currentStudent = scan.nextLine().split(" ");
        List<Lab05Students> students = new ArrayList();
        while (!currentStudent[0].equals("end")){
            students.add(new Lab05Students(currentStudent));
            currentStudent = scan.nextLine().split(" ");
        }
        String cityName = scan.nextLine();
        for (Lab05Students student : students) {
            if (cityName.equals(student.getHometown())){
                System.out.printf("%s %s is %s years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }
}
