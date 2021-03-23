package ReflectionAndAnnotations.Lab;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

public class Tracker {

    @Author(name = "George")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
    }

    @Author(name = "Peter")
    public static void printMethodsByAuthor(Class<?> cl) {
        Method[] methods = cl.getDeclaredMethods();

        Map<String, Method> methodsByAuthor = new TreeMap<>();

        for (Method method : methods) {
            Author author = method.getAnnotation(Author.class);

            if (author != null) {
                methodsByAuthor.put(author.name(), method);
            }
        }

        for (Map.Entry<String, Method> entry : methodsByAuthor.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getName() + "()");
        }
    }
}
