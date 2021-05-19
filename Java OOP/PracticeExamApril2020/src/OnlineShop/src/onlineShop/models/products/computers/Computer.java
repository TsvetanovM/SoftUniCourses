package OnlineShop.src.onlineShop.models.products.computers;

import OnlineShop.src.onlineShop.models.products.Product;
import OnlineShop.src.onlineShop.models.products.components.Component;
import OnlineShop.src.onlineShop.models.products.peripherals.Peripheral;

import java.util.List;

public interface Computer extends Product {
    List<Component> getComponents();

    List<Peripheral> getPeripherals();

    void addComponent(Component component);

    Component removeComponent(String componentType);

    void addPeripheral(Peripheral peripheral);

    Peripheral removePeripheral(String peripheralType);
}