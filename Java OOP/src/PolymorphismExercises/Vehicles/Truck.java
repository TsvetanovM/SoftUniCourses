package PolymorphismExercises.Vehicles;

public class Truck extends Vehicle{

    public Truck(double fuel, double FUEL_PER_KM) {
        super(fuel, FUEL_PER_KM + 1.6);
    }

    @Override
    public void refuel(double liters) {
        setFuel(getFuel() + liters * 0.95);
    }
}
