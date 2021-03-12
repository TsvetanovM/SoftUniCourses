package InterfecesAndAbstractionExercises.person;

public abstract class Human implements Person, Buyer {
    private String name;
    private int age;
    private int food;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    protected void setFood(int food) {
        this.food = food;
    }

    @Override
    public abstract void buyFood();

    @Override
    public int getFood() {
        return this.food;
    }
}
