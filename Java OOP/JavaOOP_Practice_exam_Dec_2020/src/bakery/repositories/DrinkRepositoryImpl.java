package bakery.repositories;

import bakery.entities.drinks.interfaces.Drink;
import bakery.repositories.interfaces.DrinkRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DrinkRepositoryImpl implements DrinkRepository<Drink> {
    private List<Drink> drinks;

    public DrinkRepositoryImpl() {
        this.drinks = new ArrayList<>();
    }

    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
        List<Drink> list = drinks.stream()
                .filter(d -> d.getName().equals(drinkName) && d.getBrand().equals(drinkBrand))
                .collect(Collectors.toList());

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public Collection<Drink> getAll() {
        return Collections.unmodifiableList(drinks);
    }

    @Override
    public void add(Drink drink) {
        if (drink != null) {
            drinks.add(drink);
        }
    }
}
