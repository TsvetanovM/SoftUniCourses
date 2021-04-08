package bakery.core;

import bakery.common.ExceptionMessages;
import bakery.common.OutputMessages;
import bakery.core.interfaces.Controller;
import bakery.entities.bakedFoods.Bread;
import bakery.entities.bakedFoods.Cake;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.DrinkRepositoryImpl;
import bakery.repositories.FoodRepositoryImpl;
import bakery.repositories.TableRepositoryImpl;
import bakery.repositories.interfaces.*;

import static bakery.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static bakery.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private FoodRepository<BakedFood> foodRepository;
    private DrinkRepository<Drink> drinkRepository;
    private TableRepository<Table> tableRepository;

    public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository, TableRepository<Table> tableRepository) {
        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;
    }


    @Override
    public String addFood(String type, String name, double price) {
        if (foodRepository.getAll().stream()
        .anyMatch(f -> f.getName().equals(name))) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        if (type.equals("Bread")) {
            foodRepository.add(new Bread(name, price));
        } else {
            foodRepository.add(new Cake(name, price));
        }

        return String.format(FOOD_ADDED, name, type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        //TODO:
        return null;
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        //TODO:
        return null;
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        //TODO:
        return null;
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        //TODO:
        return null;
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        //TODO:
        return null;

    }

    @Override
    public String leaveTable(int tableNumber) {
        //TODO:
        return null;
    }

    @Override
    public String getFreeTablesInfo() {
        //TODO:
        return null;
    }

    @Override
    public String getTotalIncome() {
        //TODO:
        return null;
    }
}
