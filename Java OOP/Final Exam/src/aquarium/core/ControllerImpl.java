package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.BaseAquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
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
        return null;
    }

    @Override
    public String feedFish(String aquariumName) {
        return null;
    }

    @Override
    public String calculateValue(String aquariumName) {
        return null;
    }

    @Override
    public String report() {
        return null;
    }
}
