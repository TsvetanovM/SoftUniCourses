package bakery.entities.tables;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;

import java.util.*;

import static bakery.common.ExceptionMessages.*;

public abstract class BaseTable implements Table {
    private List<BakedFood> foodOrders;
    private List<Drink> drinkOrders;
    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    public BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.tableNumber = tableNumber;
        setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        foodOrders = new ArrayList<>();
        drinkOrders = new ArrayList<>();
    }

    public void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    @Override
    public int getTableNumber() {
        return this.tableNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public double getPrice() {
        return numberOfPeople * pricePerPerson;
    }

    @Override
    public void reserve(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
        isReserved = true;
    }

    @Override
    public void orderFood(BakedFood food) {
        foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        drinkOrders.add(drink);
    }

    @Override
    public double getBill() {
        double bill = 0;
        for (BakedFood foodOrder : foodOrders) {
            bill += foodOrder.getPrice();
        }
        for (Drink drink : drinkOrders) {
            bill += drink.getPrice();
        }
        return bill + getPrice();
    }

    @Override
    public void clear() {
        foodOrders.clear();
        drinkOrders.clear();
        this.isReserved = false;
    }

    @Override
    public String getFreeTableInfo() {

        return String.format("Table: %d", getTableNumber()) +
                System.lineSeparator() +
                ("Type: ") + this.getClass().getSimpleName() +
                System.lineSeparator() +
                String.format("Capacity: %d", getCapacity()) +
                System.lineSeparator() +
                String.format("Price per Person: %.2f", getPricePerPerson());
    }
}
