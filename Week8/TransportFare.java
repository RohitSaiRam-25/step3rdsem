import java.util.Scanner;

interface Transport {
    double calculateFare();
}

class Bus implements Transport {

    private double distance;

    Bus(double distance) {
        this.distance = distance;
    }

    public double calculateFare() {

        double fare =
            2 + (0.10 * distance);

        if (fare > 10) {
            fare = 10;
        }

        return fare;
    }
}

class Train implements Transport {

    private double distance;

    Train(double distance) {
        this.distance = distance;
    }

    public double calculateFare() {
        return 3 + (0.15 * distance);
    }
}

class Metro implements Transport {

    private double distance;
    private double peakHourFactor;

    Metro(double distance,
          double peakHourFactor) {

        this.distance = distance;
        this.peakHourFactor = peakHourFactor;
    }

    public double calculateFare() {

        double baseFare =
            1.50 + (0.20 * distance);

        return baseFare * peakHourFactor;
    }
}

public class TransportFare {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            double distance =
                sc.nextDouble();

            Transport transport;

            if (type.equals("BUS")) {

                transport =
                    new Bus(distance);
            }
            else if (type.equals("TRAIN")) {

                transport =
                    new Train(distance);
            }
            else {

                double peakHourFactor =
                    sc.nextDouble();

                transport =
                    new Metro(
                        distance,
                        peakHourFactor
                    );
            }

            double fare =
                transport.calculateFare();

            total = total + fare;

            System.out.printf(
                "%s: %.2f%n",
                type,
                fare
            );
        }

        System.out.printf(
            "Total: %.2f%n",
            total
        );

        sc.close();
    }
}