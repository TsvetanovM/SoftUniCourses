package InterfecesAndAbstractionExercises.person;

public class Pet extends AnimateBeing{

    public Pet(String name, String birthDate) {
        super(name, birthDate);
    }

    public String getName() {
        return super.getName();
    }
}
