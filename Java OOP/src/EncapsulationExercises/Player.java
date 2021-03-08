package EncapsulationExercises;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println(("A name should not be empty."));
        } else {
           this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    private void setEndurance(int endurance) {
        if (isInvalidStat(endurance)) {
            System.out.println(("Endurance should be between 0 and 100."));
        } else {
            this.endurance = endurance;
        }
    }

    private void setSprint(int sprint) {
        if (isInvalidStat(sprint)) {
            System.out.println(("Sprint should be between 0 and 100."));
        } else {
            this.sprint = sprint;
        }
    }

    private void setDribble(int dribble) {
        if (isInvalidStat(dribble)) {
            System.out.println("Dribble should be between 0 and 100.");
        } else {
            this.dribble = dribble;
        }
    }

    private void setPassing(int passing) {
        if (isInvalidStat(passing)) {
            System.out.println(("Passing should be between 0 and 100."));
        } else {
            this.passing = passing;
        }
    }

    private void setShooting(int shooting) {
        if (isInvalidStat(shooting)) {
            System.out.println(("Shooting should be between 0 and 100."));
        } else {
            this.shooting = shooting;
        }
    }

    public double overallSkillLevel() {
        return 1.0 * (endurance + passing + dribble + shooting + sprint) / 5;
    }

    private boolean isInvalidStat(int stat) {
        return stat < 0 || stat > 100;
    }
}
