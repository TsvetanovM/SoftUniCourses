package ReflectionAndAnnotations.HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Field[] fields;

    public static void main(String[] args) {
        Class<RichSoilLand> clazz = RichSoilLand.class;

        fields = clazz.getDeclaredFields();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("HARVEST")) {
            printSuitableFields(input);
            input = scanner.nextLine();
        }
    }

    private static void printSuitableFields(String fieldType) {
        switch (fieldType) {
            case "private":
                Arrays.stream(fields)
                        .filter(f -> Modifier.isPrivate(f.getModifiers()))
                        .forEach(f -> System.out.println("private " + f.getType().getSimpleName() + " " + f.getName()));
                break;
            case "protected":
                Arrays.stream(fields)
                        .filter(f -> Modifier.isProtected(f.getModifiers()))
                        .forEach(f -> System.out.println("protected " + f.getType().getSimpleName() + " " + f.getName()));
                break;
            case "public":
                Arrays.stream(fields)
                        .filter(f -> Modifier.isPublic(f.getModifiers()))
                        .forEach(f -> System.out.println("public " + f.getType().getSimpleName() + " " + f.getName()));
                break;
            default:
                for (Field field : fields) {
                    System.out.println(Modifier.toString(field.getModifiers()) + " "
                    + field.getType().getSimpleName() + " " + field.getName());
                }
                break;
        }
    }
}
