package InterfecesAndAbstractionExercises.person;

public class Rebel implements Person, Buyer{
    private String name;
    private int age;
    private String group;
    private int food;

    public Rebel(String name, int age, String group, int food) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.food = food;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void buyFood() {
        setFood(food + 5);
    }

    @Override
    public int getFood() {
        return food;
    }

    private void setFood(int food) {
        this.food = food;
    }
}
