
import java.util.Scanner;

abstract class TravelBooking {

    protected double distance;

    static final double BOOKING_FEE = 50;

    TravelBooking(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    double calculateTotal() {
        return calculateFare() + BOOKING_FEE;
    }

    abstract String getMode();

    void display() {
        System.out.printf("%s: %.2f%n",
                getMode(), calculateTotal());
    }
}

class BusBooking extends TravelBooking {

    BusBooking(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 2;
    }

    String getMode() {
        return "BUS";
    }
}

class TrainBooking extends TravelBooking {

    TrainBooking(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 1.5;
    }

    String getMode() {
        return "TRAIN";
    }
}

class FlightBooking extends TravelBooking {

    FlightBooking(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 2500 + distance * 4;
    }

    String getMode() {
        return "FLIGHT";
    }
}

public class TravelBookingWithCommonFee {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        TravelBooking[] bookings =
                new TravelBooking[n];

        for (int i = 0; i < n; i++) {

            String mode = sc.next();
            double distance = sc.nextDouble();

            if (mode.equals("BUS")) {

                bookings[i] =
                        new BusBooking(distance);

            } else if (mode.equals("TRAIN")) {

                bookings[i] =
                        new TrainBooking(distance);

            } else {

                bookings[i] =
                        new FlightBooking(distance);
            }
        }

        for (TravelBooking booking : bookings) {
            booking.display();
        }

        sc.close();
    }
}
