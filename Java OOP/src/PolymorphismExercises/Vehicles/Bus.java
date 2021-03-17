package PolymorphismExercises.Vehicles;

public class Bus extends Vehicle {

    public Bus(double fuel, double fuelPerKm, int tankCapacity) {
        super(fuel, fuelPerKm, tankCapacity);
    }

    public void drive(double distance, boolean isEmpty) {
        if (!isEmpty) {
            setFuelPerKm(getFuelPerKm() + 1.4);
            super.drive(distance);
            setFuelPerKm(getFuelPerKm() - 1.4);
        } else super.drive(distance);
    }
}
