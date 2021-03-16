package InterfecesAndAbstractionExercises.Military;

public abstract class SoliderImpl implements Soldier{
    private int id;
    private String firstName;
    private String lastName;

    public SoliderImpl(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getFirstName() {
       return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d%n",
                getFirstName(), getLastName(), getId());
    }
}
