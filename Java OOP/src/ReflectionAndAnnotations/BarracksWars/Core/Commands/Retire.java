package ReflectionAndAnnotations.BarracksWars.Core.Commands;

import ReflectionAndAnnotations.BarracksWars.Annotations.Inject;
import ReflectionAndAnnotations.BarracksWars.Interfaces.Repository;

public class Retire extends Command{
    @Inject
    private Repository repository;

    public Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        if (repository.removeUnit(unitType) == null) {
            return "No such units in repository.";
        }
        return unitType + " retired!";
    }
}
