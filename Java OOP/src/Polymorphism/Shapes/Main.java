package Polymorphism.Shapes;

public class Main {

    public static void main(String[] args) {
        Shape shape = new Rectangle(10.0, 15.0);

        shape.calculatePerimeter();
        shape.calculateArea();

        System.out.println(shape.getPerimeter());
        System.out.println(shape.getArea());
    }
}
