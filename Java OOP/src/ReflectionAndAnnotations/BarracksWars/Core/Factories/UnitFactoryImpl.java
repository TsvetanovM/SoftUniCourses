package ReflectionAndAnnotations.BarracksWars.Core.Factories;

import ReflectionAndAnnotations.BarracksWars.Interfaces.Unit;
import ReflectionAndAnnotations.BarracksWars.Interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"ReflectionAndAnnotations.BarracksWars.Models.Units.";

	@Override
	public Unit createUnit(String unitType) {
		Unit unit = null;

		try {
			Class<?> clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
			unit = (Unit) clazz.getDeclaredConstructor().newInstance();
		} catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
				| InstantiationException | InvocationTargetException e) {
			throw new IllegalArgumentException("Unit type does not exist!");
		}

		return unit;
	}
}
