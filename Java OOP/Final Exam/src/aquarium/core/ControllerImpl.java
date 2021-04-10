package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.BaseAquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private DecorationRepository decorations;
    private Map<String, Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new LinkedHashMap<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        if (aquariumType.equals("FreshwaterAquarium")) {
            aquariums.put(aquariumName, new FreshwaterAquarium(aquariumName));
            return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
        }
        if (aquariumType.equals("SaltwaterAquarium")) {
            aquariums.put(aquariumName, new SaltwaterAquarium(aquariumName));
            return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
        }
        throw new NullPointerException(INVALID_AQUARIUM_TYPE);
    }

    @Override
    public String addDecoration(String type) {
        if (type.equals("Ornament")) {
            this.decorations.add(new Ornament());
            return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
        }
        if (type.equals("Plant")) {
            this.decorations.add(new Plant());
            return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
        }
        throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        if (this.decorations.findByType(decorationType) == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }
        Decoration decoration = this.decorations.findByType(decorationType);
        this.aquariums.get(aquariumName).addDecoration(decoration);
        this.decorations.remove(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Aquarium aquarium = this.aquariums.get(aquariumName);
        String type = fishType.replace("Fish", "");
        if (!aquarium.getClass().getSimpleName().contains(type)) {
            return WATER_NOT_SUITABLE;
        }
        switch (fishType) {
            case "FreshwaterFish":
                aquarium.addFish(new FreshwaterFish(fishName, fishSpecies, price));
                break;
            case "SaltwaterFish":
                aquarium.addFish(new SaltwaterFish(fishName, fishSpecies, price));
                break;
            default:
                throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }

        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        this.aquariums.get(aquariumName).feed();
        return String.format(FISH_FED, this.aquariums.get(aquariumName).getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        double value = 0;
        Aquarium aquarium = this.aquariums.get(aquariumName);
        for (Fish fish : aquarium.getFish()) {
            value += fish.getPrice();
        }
        for (Decoration decoration : aquarium.getDecorations()) {
            value += decoration.getPrice();
        }
        return String.format(VALUE_AQUARIUM, aquariumName, value);
    }

    @Override
    public String report() {
        StringBuilder output = new StringBuilder();
        aquariums.values().forEach(a -> output.append(a.getInfo()).append(System.lineSeparator()));
        return output.toString().trim();
    }
}
