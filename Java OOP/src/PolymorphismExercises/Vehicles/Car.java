package PolymorphismExercises.Vehicles;

public class Car extends Vehicle {

    public Car(double fuel, double fuelPerKm, int tankCapacity) {
        super(fuel, fuelPerKm, tankCapacity);
        setFuelPerKm(fuelPerKm + 0.9);
    }
}
