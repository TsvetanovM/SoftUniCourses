package ExceptionsAndErrors.Lab;

import ExceptionsAndErrors.Lab.InvalidPersonNameException;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }

    public void setFirstName(String firstName) {
        validateStringField(firstName, "first");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateStringField(lastName, "second");
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age must be in the rage [0 - 120]");
        }
        this.age = age;
    }

    private void validateStringField(String s, String fieldName) {
        if (s == null || s.isBlank()) {
            throw new InvalidPersonNameException("The " + fieldName + " name cannot be null or empty");
        }
    }
}
