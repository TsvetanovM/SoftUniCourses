package viceCity.repositories;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.Repository;

import java.util.*;

public class GunRepository implements Repository<Gun> {
    private final ArrayDeque<Gun> models;

    public GunRepository() {
        models = new ArrayDeque<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return models;
    }

    @Override
    public void add(Gun model) {
        if (!models.contains(model)) {
            models.offer(model);
        }
    }

    @Override
    public boolean remove(Gun model) {
       return this.models.remove(model);
    }

    @Override
    public Gun find(String name) {
        for (Gun model : models) {
           if (model.getName().equals(name)) {
               return model;
           }
        }
        return null;
    }
}
