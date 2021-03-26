package ReflectionAndAnnotations.BarracksWars.Core;

import ReflectionAndAnnotations.BarracksWars.Interfaces.Executable;
import ReflectionAndAnnotations.BarracksWars.Interfaces.Repository;
import ReflectionAndAnnotations.BarracksWars.Interfaces.UnitFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    private static final String COMMAND_PACKAGE_NAME = "ReflectionAndAnnotations.BarracksWars.Core.Commands.";
    private Repository repository;
    private UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    public Repository getRepository() {
        return repository;
    }

    public UnitFactory getUnitFactory() {
        return unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                Class<?> clazz = Class.forName(COMMAND_PACKAGE_NAME + commandName);
                Executable command = (Executable) clazz.getDeclaredConstructor(new Class[]
                        {String[].class, Repository.class, UnitFactory.class})
                        .newInstance(data, getRepository(), getUnitFactory());
                String result = command.execute();
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException | ClassNotFoundException | IllegalAccessException
                    | NoSuchMethodException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
}
