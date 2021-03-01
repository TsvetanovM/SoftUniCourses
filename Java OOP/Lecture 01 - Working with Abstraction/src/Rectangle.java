public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public boolean contains(Point point) {
        boolean isWithinX = (this.bottomLeft.getX() <= point.getX() && this.topRight.getX() >= point.getX());
        boolean isWithinY = (this.bottomLeft.getY() <= point.getY() && this.topRight.getY() >= point.getY());
        return (isWithinX && isWithinY);
    }

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }
}
