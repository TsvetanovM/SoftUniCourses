package InterfacesAndAbstraction.SayHello;

public abstract class BasePerson implements Person {
    private String name;

    public BasePerson(String name) {
        setName(name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }

    private void setName(String name) {
        this.name = name;
    }
}
