package bakery.repositories;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.repositories.interfaces.FoodRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FoodRepositoryImpl implements FoodRepository<BakedFood> {
    private List<BakedFood> foods;

    public FoodRepositoryImpl() {
        this.foods = new ArrayList<>();
    }

    @Override
    public BakedFood getByName(String name) {
        for (BakedFood food : foods) {
            if (food.getName().equals(name)) return food;
        }
        return null;
    }

    @Override
    public Collection<BakedFood> getAll() {
        return Collections.unmodifiableList(foods);
    }

    @Override
    public void add(BakedFood bakedFood) {
        if (bakedFood != null) {
            foods.add(bakedFood);
        }
     }
}