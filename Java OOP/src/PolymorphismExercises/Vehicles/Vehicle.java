package PolymorphismExercises.Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuel;
    private double fuelPerKm;
    private final int TANK_CAPACITY;

    public Vehicle(double fuel, double fuelPerKm, int tankCapacity) {
        setFuel(fuel);
        this.fuelPerKm = fuelPerKm;
        this.TANK_CAPACITY = tankCapacity;
    }

    protected void setFuelPerKm(double fuelPerKm) {
        this.fuelPerKm = fuelPerKm;
    }

    public int getTANK_CAPACITY() {
        return TANK_CAPACITY;
    }

    public double getFuel() {
        return fuel;
    }

    public double getFuelPerKm() {
        return fuelPerKm;
    }

    protected void setFuel(double fuel) {
        if (fuel <= 0) {
            System.out.println("Fuel must be a positive number.");
        } else this.fuel = getFuel() + fuel;
    }

    public void drive(double distance) {
        double requiredFuel = distance * getFuelPerKm();
        if (requiredFuel <= getFuel()) {
            setFuel(getFuel() - requiredFuel);
            DecimalFormat df = new DecimalFormat("0.##");
            System.out.printf("%s travelled %s km%n", this.getClass().getSimpleName(),df.format(distance));
        } else System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
    }

    public void refuel(double liters) {
        if (liters + getFuel() > TANK_CAPACITY) {
            System.out.println("Cannot fit fuel in tank");
        } else setFuel(liters);
    }
}
