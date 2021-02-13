public class Car {
    private final String model;
    private double fuelAmount;
    private final double fuelCost;
    private int distance;

    public Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distance = 0;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public int getDistance() {
        return distance;
    }

    public void driveCar(int km) {
        double fuelNeeded = this.fuelCost * km;
        if (fuelNeeded > this.fuelAmount) {
            System.out.println("Insufficient fuel for the drive");
        } else {
            this.fuelAmount -= fuelNeeded;
            this.distance += km;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distance);
    }
}
