import Calendar.WeekDay;
import Geometry.*;
import IOUtils.*;

public class Main {
    public static void main(String[] args) {

        WeekDay monday = WeekDay.MONDAY;

        System.out.println(monday.getNumericRepresentation());
        System.out.println(monday.ordinal());

        WeekDay[] values = WeekDay.values();

        for (WeekDay value : values) {
            System.out.println(value.getName());
        }
//        ConsoleReader reader = new ConsoleReader();
//
//        int[] coordinates = InputParser.parseArray(reader.readLine(), "\\s+");
//
//        Rectangle rectangle = GeometryFactory.createRectangle(coordinates);
//
//        int N = Integer.parseInt(reader.readLine());
//
//        while (N-- > 0) {
//            int[] currentCoordinates = InputParser.parseArray(reader.readLine(), "\\s+");
//            Point point = GeometryFactory.createPoint(currentCoordinates);
//            System.out.println(rectangle.contains(point));
//        }
    }
}
