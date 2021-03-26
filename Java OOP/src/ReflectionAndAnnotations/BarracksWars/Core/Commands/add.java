package ReflectionAndAnnotations.BarracksWars.Core.Commands;

import ReflectionAndAnnotations.BarracksWars.Interfaces.Repository;
import ReflectionAndAnnotations.BarracksWars.Interfaces.Unit;
import ReflectionAndAnnotations.BarracksWars.Interfaces.UnitFactory;

public class add extends Command{


    public add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];;
        Unit unitToAdd = getUnitFactory().createUnit(unitType);
        getRepository().addUnit(unitToAdd);
        return unitType + " added!";
    }
}
