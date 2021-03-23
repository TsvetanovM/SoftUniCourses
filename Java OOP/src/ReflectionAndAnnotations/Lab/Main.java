package ReflectionAndAnnotations.Lab;

import java.lang.reflect.*;
import java.util.*;

@Subject(categories = {"Test", "Annotations"})
public class Main {
    public static class MethodComparator implements Comparator<Method> {

        @Override
        public int compare(Method f, Method s) {
            return f.getName().compareTo(s.getName());
        }
    }
    @Author(name = "George")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
//        Class clazz = Reflection.class;
//
////        Constructor<Reflection> ctor = clazz.getDeclaredConstructor();
////        Reflection reflection = ctor.newInstance();
//
//        Method[] methods = clazz.getDeclaredMethods();
//        Set<Method> setters = new TreeSet<>(new MethodComparator());
//        Set<Method> getters = new TreeSet<>(new MethodComparator());
//
//        for (Method method : methods) {
//            if (method.getName().startsWith("get")) {
//                getters.add(method);
//            } else if (method.getName().startsWith("set")) {
//                setters.add(method);
//            }
//        }
//
//        Arrays.stream(clazz.getDeclaredFields())
//                .filter(e -> !Modifier.isPrivate(e.getModifiers()))
//                .sorted(Comparator.comparing(Field::getName))
//                .forEach(e -> System.out.println(e.getName() + " must be private!"));
//
//        for (Method getter : getters) {
//            if (!Modifier.isPublic(getter.getModifiers())) {
//                System.out.println(getter.getName() + " have to be public!");
//            }
//        }
//
//        setters.stream().filter(e -> !Modifier.isPrivate(e.getModifiers()))
//                .forEach(e -> System.out.println(e.getName() + " have to be private!"));
//        Class reflection = Reflection.class;
//
//        System.out.println("class " + reflection.getSimpleName());
//
//        Class superClass = reflection.getSuperclass();
//        System.out.println(superClass);
//
//        Class[] interfaces = reflection.getInterfaces();
//        for (Class anInterface : interfaces) {
//            System.out.println(anInterface);
//        }
//
//        try {
//            Constructor<Reflection> declaredConstructor = reflection.getDeclaredConstructor(
//                    String.class, String.class, String.class
//            );
//            declaredConstructor.setAccessible(true);
//            Reflection reflectionObject = declaredConstructor.newInstance("1", "6", "9");
//
//            Field zip = reflection.getDeclaredField("zip");
//            zip.setAccessible(true);
//            int oldValue =(int) zip.get(reflectionObject);
//            System.out.println("Old value: " + oldValue);
//
//            zip.set(reflectionObject, 1612);
//            System.out.println("New value: " + zip.get(reflectionObject));
//            System.out.println(reflectionObject.toString());
//        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchFieldException e) {
//            e.printStackTrace();
//        }
    }
}
