package Geometry;

public class GeometryFactory {

    public static Rectangle createRectangle(int[] pointsInfo) {
        return new Rectangle(createPoint(pointsInfo[0], pointsInfo[1]),
                createPoint(pointsInfo[2], pointsInfo[3]));
    }

    private static Point createPoint(int x, int y) {
        return new Point(x, y);
    }
}
