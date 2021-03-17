package PolymorphismExercises.Vehicles;

public class Truck extends Vehicle{

    public Truck(double fuel, double fuelPerKm, int tankCapacity) {
        super(fuel, fuelPerKm, tankCapacity);
        setFuelPerKm(fuelPerKm + 1.6);
    }

    @Override
    public void refuel(double liters) {
        if (liters + getFuel() > getTANK_CAPACITY()) {
            System.out.println("Cannot fit fuel in tank");
        } else setFuel(getFuel() + liters * 0.95);
    }
}
