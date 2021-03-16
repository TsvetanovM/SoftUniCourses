package Polymorphism.Shapes;

public abstract class Shape {
    protected Double perimeter;
    protected Double area;

    public abstract void calculatePerimeter();

    public abstract void calculateArea();

    public Double getPerimeter() {
        return perimeter;
    }

    public Double getArea() {
        return area;
    }
}
