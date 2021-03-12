package InterfecesAndAbstractionExercises.person;

public class Rebel extends Human implements Person {
    private String group;

    public Rebel(String name, int age, String group) {
        super(name, age);
        this.group = group;
    }

    @Override
    public void buyFood() {
        setFood(super.getFood() + 5);
    }
}
