public class Box<T> {
    private T t;

    public Box(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        String output = t.getClass() + ": " + t.toString();
        return output.replace("class ", "");
    }
}
