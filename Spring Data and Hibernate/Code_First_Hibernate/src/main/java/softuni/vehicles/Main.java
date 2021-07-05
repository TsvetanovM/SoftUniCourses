package softuni.vehicles;

import softuni.vehicles.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence
                .createEntityManagerFactory("vehicle")
                .createEntityManager();

        entityManager.getTransaction().begin();

        Vehicle bike = new Bike("Bike", "BMX", BigDecimal.valueOf(550.00), "eko");
        Vehicle car = new Car("Car", "Yaris", BigDecimal.valueOf(6000), "petrol", 5);
        Vehicle truck = new Truck("Truck", "Man", BigDecimal.valueOf(55000), "Diesel", 6000.0);
        Vehicle plane = new Plane("Plane", "Boeing 777", BigDecimal.valueOf(35000000), "kerosene", 325, "Emirates");

        entityManager.persist(bike);
        entityManager.persist(car);
        entityManager.persist(truck);
        entityManager.persist(plane);

        entityManager.getTransaction().commit();
    }
}
