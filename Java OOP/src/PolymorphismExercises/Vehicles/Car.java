package PolymorphismExercises.Vehicles;

public class Car extends Vehicle {

    public Car(double fuel, double FUEL_PER_KM) {
        super(fuel, FUEL_PER_KM + 0.9);
    }

    @Override
    public void refuel(double liters) {
        setFuel(getFuel() + liters);
    }
}
