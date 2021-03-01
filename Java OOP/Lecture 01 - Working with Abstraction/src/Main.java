import Geometry.GeometryFactory;
import Geometry.Point;
import Geometry.Rectangle;
import IOUtils.ConsoleReader;
import IOUtils.InputParser;

public class Main {
    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();

        int[] coordinates = InputParser.parseArray(reader.readLine(), "\\s+");

        Rectangle rectangle = GeometryFactory.createRectangle(coordinates);

        int N = Integer.parseInt(reader.readLine());

        while (N-- > 0) {
            int[] currentCoordinates = InputParser.parseArray(reader.readLine(), "\\s+");
            int x = currentCoordinates[0];
            int y = currentCoordinates[1];
            System.out.println(rectangle.contains(new Point(x, y)));
        }
    }
}
