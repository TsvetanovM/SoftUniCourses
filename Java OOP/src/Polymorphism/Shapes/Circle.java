package Polymorphism.Shapes;

public class Circle extends Shape{
    private final Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        this.perimeter = Math.PI * radius * 2;
    }

    @Override
    public void calculateArea() {
        this.area =  Math.PI * Math.pow(radius, 2);
    }

    public final Double getRadius() {
        return radius;
    }
}
