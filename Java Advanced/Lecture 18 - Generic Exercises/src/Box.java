public class Box<T> {
    private T t;

    public Box(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        String output = this.t.getClass() + ": " + this.t;
        return output.replace("class ", "");
    }
}
