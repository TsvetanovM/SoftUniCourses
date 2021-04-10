package aquarium.entities.aquariums;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class BaseAquarium implements Aquarium{
    private String name;
    private int capacity;
    private List<Decoration> decorations;
    private List<Fish> fish;

    public BaseAquarium(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.fish = new ArrayList<>();
        this.decorations = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int calculateComfort() {
        int sum = 0;
        for (Decoration decoration : decorations) {
            sum += decoration.getComfort();
        }
        return sum;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
        if (this.fish.size() >= this.capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        this.fish.forEach(Fish::eat);
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s):", this.name, this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append("Fish:");
        if (this.fish.isEmpty()) {
            sb.append("none");
        } else {
            for (Fish fish1 : fish) {
                sb.append(" ").append(fish1.getName());
            }
        }
        sb.append(System.lineSeparator())
                .append("Decorations: ")
                .append(getDecorations().size())
                .append(System.lineSeparator())
                .append("Comfort: ")
                .append(calculateComfort());
        return sb.toString();
    }

    @Override
    public Collection<Fish> getFish() {
        return this.fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations;
    }
}
