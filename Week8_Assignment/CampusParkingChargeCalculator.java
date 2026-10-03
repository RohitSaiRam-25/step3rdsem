import java.util.Scanner;

abstract class Vehicle {
    protected String type;
    protected int hours;

    Vehicle(String type, int hours) {
        this.type = type;
        this.hours = hours;
    }

    abstract double calculateCharge();

    void display() {
        System.out.printf("%s: %.2f%n", type, calculateCharge());
    }
}

class Bike extends Vehicle {

    Bike(int hours) {
        super("BIKE", hours);
    }

    double calculateCharge() {
        return hours * 10;
    }
}

class Car extends Vehicle {

    Car(int hours) {
        super("CAR", hours);
    }

    double calculateCharge() {

        if (hours == 1) {
            return 30;
        }

        return 30 + (hours - 1) * 20;
    }
}

class Truck extends Vehicle {

    Truck(int hours) {
        super("TRUCK", hours);
    }

    double calculateCharge() {

        double charge = hours * 50;

        if (charge < 100) {
            charge = 100;
        }

        return charge;
    }
}

public class CampusParkingChargeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int hours = sc.nextInt();

            if (type.equals("BIKE")) {
                vehicles[i] = new Bike(hours);
            } else if (type.equals("CAR")) {
                vehicles[i] = new Car(hours);
            } else {
                vehicles[i] = new Truck(hours);
            }
        }

        double total = 0;

        for (Vehicle vehicle : vehicles) {
            vehicle.display();
            total += vehicle.calculateCharge();
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}