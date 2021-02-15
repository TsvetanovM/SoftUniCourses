import java.util.List;

public class Box<T> {
    private T t;

    public Box(T t) {
        this.t = t;
    }

    public static <T> void printElements(List<T> list, int firstIndex, int secondIndex) {
        swapIndexes(list, firstIndex, secondIndex);
        list.forEach(System.out::println);
    }

    private static <T> void swapIndexes(List<T> list, int firstIndex, int secondIndex) {
        T t1 = list.get(firstIndex);
        T t2 = list.get(secondIndex);
        list.remove(firstIndex);
        list.add(firstIndex, t2);
        list.remove(secondIndex);
        list.add(secondIndex, t1);
    }

    public static <T extends Comparable<T>> long elementsGreaterThanCount(List<T> list, T comparator) {
        return list.stream()
                .filter(e -> e.compareTo(comparator)>0)
                .count();
    }

    @Override
    public String toString() {
        String output = this.t.getClass() + ": " + this.t;
        return output.replace("class ", "");
    }
}
