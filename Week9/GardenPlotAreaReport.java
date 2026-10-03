import java.util.Scanner;

abstract class Plot {
    protected String owner;
    protected String shape;

    Plot(String owner, String shape) {
        this.owner = owner;
        this.shape = shape;
    }

    abstract double calculateArea();

    void display() {
        System.out.printf("%s (%s): %.2f%n",
                owner, shape, calculateArea());
    }
}

class Circle extends Plot {

    private double radius;

    Circle(String owner, double radius) {
        super(owner, "CIRCLE");
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Plot {

    private double length;
    private double width;

    Rectangle(String owner, double length, double width) {
        super(owner, "RECTANGLE");
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }
}

class Triangle extends Plot {

    private double base;
    private double height;

    Triangle(String owner, double base, double height) {
        super(owner, "TRIANGLE");
        this.base = base;
        this.height = height;
    }

    double calculateArea() {
        return 0.5 * base * height;
    }
}

public class GardenPlotAreaReport {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Plot[] plots = new Plot[n];

        for (int i = 0; i < n; i++) {

            String shape = sc.next();
            String owner = sc.next();

            if (shape.equals("CIRCLE")) {

                double radius = sc.nextDouble();

                plots[i] = new Circle(owner, radius);

            } else if (shape.equals("RECTANGLE")) {

                double length = sc.nextDouble();
                double width = sc.nextDouble();

                plots[i] = new Rectangle(owner, length, width);

            } else {

                double base = sc.nextDouble();
                double height = sc.nextDouble();

                plots[i] = new Triangle(owner, base, height);
            }
        }

        double total = 0;

        for (Plot plot : plots) {

            plot.display();

            total += plot.calculateArea();
        }

        System.out.printf("Total Area: %.2f%n", total);

        sc.close();
    }
}