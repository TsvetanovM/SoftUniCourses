package PolymorphismExercises.Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuel;
    private final double FUEL_PER_KM;

    public Vehicle(double fuel, double FUEL_PER_KM) {
        this.fuel = fuel;
        this.FUEL_PER_KM = FUEL_PER_KM;
    }

    public double getFuel() {
        return fuel;
    }

    public double getFUEL_PER_KM() {
        return FUEL_PER_KM;
    }

    protected void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void drive(double distance) {
        double requiredFuel = distance * getFUEL_PER_KM();
        if (requiredFuel <= getFuel()) {
            setFuel(getFuel() - requiredFuel);
            DecimalFormat df = new DecimalFormat("0.##");
            System.out.printf("%s travelled %s km%n", this.getClass().getSimpleName(),df.format(distance));
        } else System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
    }

    public abstract void refuel(double liters);
}
