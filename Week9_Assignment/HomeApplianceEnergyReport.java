import java.util.Scanner;

abstract class Appliance {

    protected double hours;

    static final double COST_PER_UNIT = 8;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    abstract String getType();

    boolean supportsSaverMode() {
        return false;
    }

    double calculateUnits() {
        return (getPower() * hours) / 1000;
    }

    double calculateSaverUnits() {
        return calculateUnits() * 0.75;
    }

    double calculateCost(double units) {
        return units * COST_PER_UNIT;
    }
}

class Fridge extends Appliance {

    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }

    String getType() {
        return "FRIDGE";
    }
}

class AirConditioner extends Appliance {

    AirConditioner(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500;
    }

    String getType() {
        return "AC";
    }

    boolean supportsSaverMode() {
        return true;
    }
}

class TV extends Appliance {

    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }

    String getType() {
        return "TV";
    }
}

class Washer extends Appliance {

    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500;
    }

    String getType() {
        return "WASHER";
    }

    boolean supportsSaverMode() {
        return true;
    }
}

public class HomeApplianceEnergyReport {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Appliance[] appliances = new Appliance[n];

        boolean[] saver = new boolean[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double hours = sc.nextDouble();

            if (type.equals("SAVER")) {
                // This case is never expected here.
            }

            String mode = "";

            if (sc.hasNext("SAVER")) {
                mode = sc.next();
            }

            if (type.equals("FRIDGE")) {

                appliances[i] = new Fridge(hours);

            } else if (type.equals("AC")) {

                appliances[i] = new AirConditioner(hours);

            } else if (type.equals("TV")) {

                appliances[i] = new TV(hours);

            } else {

                appliances[i] = new Washer(hours);
            }

            saver[i] = mode.equals("SAVER");
        }

        double totalCost = 0;

        for (int i = 0; i < n; i++) {

            Appliance appliance = appliances[i];

            if (saver[i]
                    && !appliance.supportsSaverMode()) {

                System.out.println(
                        appliance.getType()
                        + ": saver mode not supported"
                );

            } else {

                double units;

                if (saver[i]) {
                    units = appliance.calculateSaverUnits();
                } else {
                    units = appliance.calculateUnits();
                }

                double cost =
                        appliance.calculateCost(units);

                System.out.printf(
                        "%s: Units=%.2f Cost=%.2f%n",
                        appliance.getType(),
                        units,
                        cost
                );

                totalCost += cost;
            }
        }

        System.out.printf(
                "Total Cost: %.2f%n",
                totalCost
        );

        sc.close();
    }
}