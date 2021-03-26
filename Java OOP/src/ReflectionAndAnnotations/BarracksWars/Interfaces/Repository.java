package ReflectionAndAnnotations.BarracksWars.Interfaces;

public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	Integer removeUnit(String unitType);
}
