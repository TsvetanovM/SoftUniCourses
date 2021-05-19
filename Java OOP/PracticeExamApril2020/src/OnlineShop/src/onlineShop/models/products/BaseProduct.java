package OnlineShop.src.onlineShop.models.products;

public abstract class BaseProduct implements Product {
    private int id;
    private String manufacturer;
    private String model;
    private double price;
    private double overallPerformance;

    public BaseProduct(int id, String manufacturer, String model, double price, double overallPerformance) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
        this.overallPerformance = overallPerformance;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getManufacturer() {
        return null;
    }

    @Override
    public String getModel() {
        return null;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public double getOverallPerformance() {
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }
}
