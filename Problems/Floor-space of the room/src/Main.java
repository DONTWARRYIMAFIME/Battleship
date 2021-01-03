import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String shapeType = scanner.next();

        double pi = 3.14;

        double a, b, c, radius, square;

        switch (shapeType) {
            case "triangle":
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                c = scanner.nextDouble();


                double p = (a + b + c) / 2;

                square = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                System.out.println(square);
                break;

            case "rectangle":
                a = scanner.nextDouble();
                b = scanner.nextDouble();

                square = a * b;
                System.out.println(square);
                break;

            case "circle":
                radius = scanner.nextDouble();

                square = pi * Math.pow(radius, 2);
                System.out.println(square);
                break;


            default:
                System.out.println("Unknown shape type");
                break;
        }
    }
}
