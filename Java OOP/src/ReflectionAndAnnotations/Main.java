package ReflectionAndAnnotations;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        Class reflection = Reflection.class;

        System.out.println(reflection.getSimpleName());

        Class superClass = reflection.getSuperclass();
        System.out.println(superClass.getSimpleName());

        Class[] interfaces = reflection.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface.getSimpleName());
        }

        try {
            Constructor<Reflection> declaredConstructor = reflection.getDeclaredConstructor();
            Reflection reflectionObject = declaredConstructor.newInstance();
            System.out.println(reflectionObject.toString());
        } catch (NoSuchMethodException
                | IllegalAccessException
                | InstantiationException
                | InvocationTargetException e) {
            e.printStackTrace();
        }

//        try {
//            Class clazz = Class.forName("ReflectionAndAnnotations.Reflection");
//            System.out.println(clazz.getName());
//            System.out.println(clazz.getSuperclass());
//            Class[] interfaces = clazz.getInterfaces();
//            for (Class anInterface : interfaces) {
//                System.out.println(anInterface.getSimpleName());
//            }
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}
