package ReflectionAndAnnotations.BarracksWars;

import ReflectionAndAnnotations.BarracksWars.Core.CommandInterpreterImpl;
import ReflectionAndAnnotations.BarracksWars.Core.Engine;
import ReflectionAndAnnotations.BarracksWars.Core.Factories.UnitFactoryImpl;
import ReflectionAndAnnotations.BarracksWars.Data.UnitRepository;
import ReflectionAndAnnotations.BarracksWars.Interfaces.Repository;
import ReflectionAndAnnotations.BarracksWars.Interfaces.Runnable;
import ReflectionAndAnnotations.BarracksWars.Interfaces.UnitFactory;


public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(new CommandInterpreterImpl(repository, unitFactory));
        engine.run();
    }
}
