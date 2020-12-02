package softuni.fundamentals.java;

import java.util.*;

public class Lab05Students {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Students> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] student = scan.nextLine().split(" ");
            students.add(new Students(student[0], student[1], Double.parseDouble(student[2])));
        }
        students.sort(new Comparator<Students>() {
            @Override
            public int compare(Students o1, Students o2) {
                if (o1.grade>o2.grade) {
                    return 1;
                }
                else if (o1.grade==o2.grade){
                    return 0;
                }
                    return -1;
            }
        });
        Collections.reverse(students);
        for (Students student : students) {
            System.out.println(student);
        }
    }
}

 class Students {
    String firstName, lastName;
    double grade;

    Students(String firstName, String lastName, double grade) {
        this.firstName = firstName;
        this.grade = grade;
        this.lastName = lastName;
    }

     @Override
     public String toString() {
         return String.format("%s %s: %.2f", this.firstName, this.lastName, this.grade);
     }
 }
