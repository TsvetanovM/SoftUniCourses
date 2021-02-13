import java.util.ArrayDeque;

public class Jar<T> {
    private ArrayDeque<T> elements;

    public Jar() {
        this.elements = new ArrayDeque<>();
    }

    public void add(T t) {
        this.elements.add(t);
    }

    public void remove(T t) {
        this.elements.pop();
    }
}
