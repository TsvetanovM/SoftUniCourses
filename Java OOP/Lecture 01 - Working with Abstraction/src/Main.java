import Geometry.*;
import IOUtils.*;

public class Main {
    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();

        int[] coordinates = InputParser.parseArray(reader.readLine(), "\\s+");

        Rectangle rectangle = GeometryFactory.createRectangle(coordinates);

        int N = Integer.parseInt(reader.readLine());

        while (N-- > 0) {
            int[] currentCoordinates = InputParser.parseArray(reader.readLine(), "\\s+");
            Point point = GeometryFactory.createPoint(currentCoordinates);
            System.out.println(rectangle.contains(point));
        }
    }
}
