package Military;

import java.util.LinkedHashSet;
import java.util.Set;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando{
    private Set<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        missions = new LinkedHashSet<>();
    }

    public void addMission(Mission mission) {
        for (State state : State.values()) {
            if (mission.getState().equals(state.name())) {
                this.missions.add(mission);
            }
        }
    }

    @Override
    public Set<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public String toString() {
        return (super.toString() + "Missions:" + System.lineSeparator() +
                getCollectionPrintInfo(getMissions())).trim();
    }
}
