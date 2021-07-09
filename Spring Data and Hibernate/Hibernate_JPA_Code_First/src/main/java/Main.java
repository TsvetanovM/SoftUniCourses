import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please enter the exercise number:");
        try {
            int exNumber = Integer.parseInt(new Scanner(System.in).nextLine());
            executeExercise(exNumber);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid exercise number!");
        }
    }

    private static void createDatabase(String persistenceUnitName) {
        EntityManager em = Persistence
                .createEntityManagerFactory(persistenceUnitName)
                .createEntityManager();
    }

    private static void executeExercise(int exerciseNumber) {
        switch (exerciseNumber) {
            case 1:
                createDatabase("Gringotts - Exercise 01");
                break;
            case 2:
                createDatabase("Sales - Exercise 02");
                break;
            case 3:
                createDatabase("University - Exercise 03");
                break;
            case 4:
                createDatabase("Hospital - Exercise 04");
                break;
            case 5:
                createDatabase("Bills Payment System - Exercise 05");
                break;
            case 6:
                createDatabase("Football Betting - Exercise 06");
                break;
            default:
                System.out.println("No such exercise exists!");
        }
    }
}
