package InterfecesAndAbstractionExercises.person;

public class Citizen extends AnimateBeing
        implements Person, Identifiable {

    private int age;
    private String id;

    public Citizen(String name, int age, String id, String birthDate) {
        super(name, birthDate);
        this.age = age;
        this.id = id;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getId() {
        return id;
    }


//    @Override
//    public String toString() {
//        return "Citizen{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", id='" + id + '\'' +
//                ", birthDate='" + birthDate + '\'' +
//                '}';
//    }
}
