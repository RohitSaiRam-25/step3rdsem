import java.util.Scanner;

abstract class Cab {

    protected double distance;

    static final double MINIMUM_FARE = 100;

    Cab(double distance) {
        this.distance = distance;
    }

    abstract double getRate();

    abstract String getType();

    boolean offersNightService() {
        return false;
    }

    double calculateFare() {

        double fare = distance * getRate();

        if (fare < MINIMUM_FARE) {
            fare = MINIMUM_FARE;
        }

        return fare;
    }

    double calculateNightFare() {

        return calculateFare() * 1.20;
    }
}

class MiniCab extends Cab {

    MiniCab(double distance) {
        super(distance);
    }

    double getRate() {
        return 10;
    }

    String getType() {
        return "MINI";
    }
}

class SedanCab extends Cab {

    SedanCab(double distance) {
        super(distance);
    }

    double getRate() {
        return 14;
    }

    String getType() {
        return "SEDAN";
    }

    boolean offersNightService() {
        return true;
    }
}

class SUVCab extends Cab {

    SUVCab(double distance) {
        super(distance);
    }

    double getRate() {
        return 18;
    }

    String getType() {
        return "SUV";
    }

    boolean offersNightService() {
        return true;
    }
}

public class CityCabFareMeter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Cab[] cabs = new Cab[n];

        String[] times = new String[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            times[i] = time;

            if (type.equals("MINI")) {

                cabs[i] = new MiniCab(km);

            } else if (type.equals("SEDAN")) {

                cabs[i] = new SedanCab(km);

            } else {

                cabs[i] = new SUVCab(km);
            }
        }

        double total = 0;

        for (int i = 0; i < n; i++) {

            Cab cab = cabs[i];

            if (times[i].equals("NIGHT")
                    && !cab.offersNightService()) {

                System.out.println(
                        cab.getType()
                        + ": night service not available"
                );

            } else {

                double fare;

                if (times[i].equals("NIGHT")) {
                    fare = cab.calculateNightFare();
                } else {
                    fare = cab.calculateFare();
                }

                System.out.printf(
                        "%s: %.2f%n",
                        cab.getType(),
                        fare
                );

                total += fare;
            }
        }

        System.out.printf(
                "Total: %.2f%n",
                total
        );

        sc.close();
    }
}

