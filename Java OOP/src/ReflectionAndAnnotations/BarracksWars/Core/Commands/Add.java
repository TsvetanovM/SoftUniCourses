package ReflectionAndAnnotations.BarracksWars.Core.Commands;

import ReflectionAndAnnotations.BarracksWars.Annotations.Inject;
import ReflectionAndAnnotations.BarracksWars.Interfaces.Repository;
import ReflectionAndAnnotations.BarracksWars.Interfaces.Unit;
import ReflectionAndAnnotations.BarracksWars.Interfaces.UnitFactory;

public class Add extends Command{
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    public Add(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];;
        Unit unitToAdd = unitFactory.createUnit(unitType);
        repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}
