package InterfecesAndAbstractionExercises.person;

public class Citizen extends Human
        implements Identifiable {

    private String id;
    private String birthDate;

    public Citizen(String name, int age, String id, String birthDate) {
        super(name, age);
        this.id = id;
        this.birthDate = birthDate;
    }


    @Override
    public String getId() {
        return id;
    }

    @Override
    public void buyFood() {
        setFood(super.getFood() + 10);
    }
}
