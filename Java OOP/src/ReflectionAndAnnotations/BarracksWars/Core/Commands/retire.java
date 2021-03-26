package ReflectionAndAnnotations.BarracksWars.Core.Commands;

import ReflectionAndAnnotations.BarracksWars.Interfaces.Repository;
import ReflectionAndAnnotations.BarracksWars.Interfaces.UnitFactory;

public class retire extends Command{


    public retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        if (getRepository().removeUnit(unitType) == null) {
            return "No such units in repository.";
        }
        return unitType + " retired!";
    }
}
