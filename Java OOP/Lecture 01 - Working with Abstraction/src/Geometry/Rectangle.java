package Geometry;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public boolean contains(Point point) {
        boolean isWithinX = isWithin(point, "X");
        boolean isWithinY = isWithin(point, "Y");
        return (isWithinX && isWithinY);
    }

    private boolean isWithin(Point point, String coordinate) {
        return (coordinate.equals("X"))
                ? this.bottomLeft.getX() <= point.getX() && this.topRight.getX() >= point.getX()
                : this.bottomLeft.getY() <= point.getY() && this.topRight.getY() >= point.getY();
    }

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }
}
