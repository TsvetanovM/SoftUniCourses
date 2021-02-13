import java.util.ArrayDeque;

public class Jar<T> {
    private ArrayDeque<T> elements;

    public Jar() {
        this.elements = new ArrayDeque<>();
    }

    public void add(T t) {
        this.elements.push(t);
    }

    public T remove(T t) {
       return this.elements.pop();
    }
}
