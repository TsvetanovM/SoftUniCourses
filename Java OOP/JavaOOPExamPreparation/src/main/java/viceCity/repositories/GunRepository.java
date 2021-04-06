package viceCity.repositories;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.Repository;

import java.util.Collection;

public class GunRepository implements Repository {
    private Collection<Gun> models;

    @Override
    public Collection<Gun> getModels() {
        return models;
    }

    @Override
    public void add(Object model) {
        Gun gun = (Gun) model;
        if (!models.contains(gun)) models.add(gun);
    }

    @Override
    public boolean remove(Object model) {
       return models.remove(model);
    }

    @Override
    public Object find(String name) {
        return models.stream()
                .filter(g -> g.getName().equals(name))
                .limit(1);
    }
}
