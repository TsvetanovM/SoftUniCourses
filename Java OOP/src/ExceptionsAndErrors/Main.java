package ExceptionsAndErrors;

public class Main {
    public static void main(String[] args) {

        try {
            Person peter = new Person("Franco", "Aimee", 19);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }

        try {
            Person noName = new Person("  ", "Aimee", 19);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }

        try {
            Person noLastName = new Person("Franco", null, 19);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }

        try {
            Person negativeAge = new Person("Franco", "Aimee", -1);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }

        try {
            Person tooOldForThisProgram = new Person("Franco", "Aimee", 143);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }
    }
}
