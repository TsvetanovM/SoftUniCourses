package Encapsulation.Geometry;

public class GeometryFactory {

    public static Rectangle createRectangle(int[] pointsInfo) {
        return new Rectangle(createPoint(pointsInfo[0], pointsInfo[1]),
                createPoint(pointsInfo[2], pointsInfo[3]));
    }

    public static Point createPoint(int x, int y) {
        return new Point(x, y);
    }

    public static Point createPoint(int[] coordinates) {
        if (coordinates.length!=2) {
            throw new IllegalStateException("Invalid number of coordinates!");
        }
        return createPoint(coordinates[0], coordinates[1]);
    }
}
