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

        Truck truckOne = new Truck("Truck", "Man", BigDecimal.valueOf(55000), "Diesel", 6000.0);
        Truck truckTwo = new Truck("Truck", "Mercedes", BigDecimal.valueOf(55000), "Diesel", 6000.0);

        Driver driverOne = new Driver();
        driverOne.setFull_name("Petkan");
        driverOne.setTruck(truckOne);
        driverOne.setTruck(truckTwo);
        entityManager.persist(driverOne);

        Driver driverTwo = new Driver();
        driverTwo.setFull_name("Mitko");
        driverTwo.setTruck(truckTwo);
        entityManager.persist(driverTwo);

        truckOne.setDriver(driverTwo);
        truckTwo.setDriver(driverOne);

        entityManager.persist(truckOne);
        entityManager.persist(truckTwo);

//        Company company = new Company();
//        company.setName("Tsvetanovi Inc.");
//        entityManager.persist(company);

//        Vehicle bike = new Bike("Bike", "BMX", BigDecimal.valueOf(550.00), "eko");
//        Car car = new Car("Car", "Yaris", BigDecimal.valueOf(6000), "petrol", 5);
//        Plane plane = new Plane(325,"Emirates", "Plane", "Boeing 777", BigDecimal.valueOf(35000000), "kerosene");

//        plane.setCompany(company);
//        entityManager.persist(plane);
//        Plate_number plateNumber = new Plate_number();
//        plateNumber.setNumber("CA5108KA");
//        entityManager.persist(bike);
//        entityManager.persist(plateNumber);
//        car.setPlateNumber(plateNumber);
//        entityManager.persist(car);
//        entityManager.persist(truck);
//        entityManager.persist(plane);

        entityManager.getTransaction().commit();
    }
}
