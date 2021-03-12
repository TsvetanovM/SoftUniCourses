package InterfecesAndAbstractionExercises.person;

public class Citizen
        implements Person, Identifiable, Buyer {

    private String name;
    private int age;
    private String id;
    private String birthDate;
    private int food;

    public Citizen(String name, int age, String id, String birthDate, int food) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
        this.food = food;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    private void setFood(int food) {
        this.food = food;
    }

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public void buyFood() {
        setFood(food + 10);
    }
}
