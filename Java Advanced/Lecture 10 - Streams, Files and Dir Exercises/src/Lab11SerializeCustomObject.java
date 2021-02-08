import java.io.*;

public class Lab11SerializeCustomObject {
    private static final String PATH = "course.ser";
    public static void main(String[] args) {
        Course course = new Course("Astrology", 3);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH))) {
            oos.writeObject(course);
            Course astrology = (Course) ois.readObject();
            System.out.println(astrology.getName());
            System.out.println(astrology.getTotalStudents());
        } catch (IndexOutOfBoundsException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static class Course implements Serializable {
        String name;
        int totalStudents;

        Course(String name, int students) {
            this.name = name;
            totalStudents = students;
        }

        public String getName() {
            return name;
        }

        public int getTotalStudents() {
            return totalStudents;
        }


    }
}
