import java.util.Collections;
import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        validateList(list.isEmpty());
        return Collections.min(list);
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        validateList(list.isEmpty());
        return Collections.max(list);
    }

    private static void validateList(boolean empty) {
        if (empty) {
            throw new IllegalArgumentException();
        }
    }
}
