package Calendar;

public enum WeekDay {
    MONDAY(1, "Monday"),
    TUESDAY(2, "Tuesday"),
    WEDNESDAY(3, "Wednesday"),
    THURSDAY(4, "Thursday"),
    FRIDAY(5, "Friday"),
    SATURDAY(6, "Saturday"),
    SUNDAY(7, "Sunday");

    private int numericRepresentation;
    private String name;

    WeekDay(int numericRepresentation, String name) {
        this.numericRepresentation = numericRepresentation;
        this.name = name;
    }

    public int getNumericRepresentation() {
        return numericRepresentation;
    }

    public String getName() {
        return name;
    }
}
