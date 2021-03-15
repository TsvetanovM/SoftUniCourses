package Military;

import java.util.Set;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier{
    private String corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    @Override
    public String getCorps() {
        return corps;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                "Corps: " + getCorps() + System.lineSeparator();
    }

    protected <T> String getCollectionPrintInfo(Set<T> set) {
        StringBuilder output = new StringBuilder();
        for (T t : set) {
            output.append("  ").append(t.toString());
            output.append(System.lineSeparator());
        }
        if (output.length() > 0) {
            output.deleteCharAt(output.length()-1);
        }
        return output.toString();
    }
}
