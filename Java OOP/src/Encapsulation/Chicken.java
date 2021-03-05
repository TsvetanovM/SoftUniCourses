package Encapsulation;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name) {
        setName(name);
    }

    public Chicken(String name, int age) {
        this(name);
        setAge(age);
    }

    private void setName(String name) {
        if (name == null || name.length()<1 || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        if (age < 6) {
            return 2;
        } else if (age < 12) {
            return 1;
        }
        return 0.75;
    }

    @Override
    public String toString() {
        return String.format("Chicken Mara (age %d) can produce %.2f eggs per day.",
                getAge(), productPerDay());
    }
}
