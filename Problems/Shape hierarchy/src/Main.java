abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}

class Triangle extends Shape {

    final double a;
    final double b;
    final double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    double getPerimeter() {
        return a + b + c;
    }

    double getArea() {
        double p = getPerimeter() / 2.0f;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}

class Rectangle extends Shape {

    final double width;
    final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    double getPerimeter() {
        return (width + height) * 2;
    }

    double getArea() {
        return width * height;
    }
}

class Circle extends Shape {

    final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}