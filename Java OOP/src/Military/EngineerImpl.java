package Military;

import java.util.LinkedHashSet;
import java.util.Set;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer{
    private Set<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        repairs = new LinkedHashSet<>();
    }

    public void addRepair(Repair repair) {
        repairs.add(repair);
    }

    @Override
    public Set<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public String toString() {
        return (super.toString() + "Repairs:" + System.lineSeparator() +
                getCollectionPrintInfo(getRepairs())).trim();
    }
}
