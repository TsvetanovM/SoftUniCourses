package ReflectionAndAnnotations.BarracksWars.Core.Commands;

import ReflectionAndAnnotations.BarracksWars.Interfaces.Repository;
import ReflectionAndAnnotations.BarracksWars.Interfaces.UnitFactory;

public class report extends Command{


    public report(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return getRepository().getStatistics();
    }
}
