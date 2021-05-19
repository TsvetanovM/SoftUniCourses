package OnlineShop.src.onlineShop.models.products.components;

import OnlineShop.src.onlineShop.models.products.BaseProduct;

public abstract class BaseComponent extends BaseProduct implements Component{
    private int generation;


    public BaseComponent(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance);
        this.generation = generation;
    }

    @Override
    public int getGeneration() {
        return 0;
    }

    @Override
    public String toString() {
        return "BaseComponent{" +
                "generation=" + generation +
                '}';
    }
}
