package InterfecesAndAbstractionExercises.person;

public abstract class AnimateBeing implements Birthable {
    private String name;
    private String birthDate;

    public AnimateBeing(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }
}
