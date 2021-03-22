package ReflectionAndAnnotations;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static class MethodComparator implements Comparator<Method> {

        @Override
        public int compare(Method f, Method s) {
            return f.getName().compareTo(s.getName());
        }
    }

    public static void main(String[] args) {
        Class clazz = Reflection.class;

//        Constructor<Reflection> ctor = clazz.getDeclaredConstructor();
//        Reflection reflection = ctor.newInstance();

        Method[] methods = clazz.getDeclaredMethods();
        Set<Method> setters = new TreeSet<>(new MethodComparator());
        Set<Method> getters = new TreeSet<>(new MethodComparator());

        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                getters.add(method);
            } else if (method.getName().startsWith("set")) {
                setters.add(method);
            }
        }

        getters.forEach(m -> System.out.println( m.getName() + " will return "
                + m.getReturnType()));

        setters.forEach(m -> System.out.println( m.getName() + " and will set field of "
                + m.getParameterTypes()[0]));
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
