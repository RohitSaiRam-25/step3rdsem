import java.util.Scanner;

abstract class Parcel {

    protected double weight;
    protected double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();

    double calculateInsurance() {
        return 0;
    }

    double calculateTotal() {
        return calculateCharge() + calculateInsurance();
    }

    abstract String getType();

    void display() {

        System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                getType(),
                calculateCharge(),
                calculateInsurance(),
                calculateTotal()
        );
    }
}

class StandardParcel extends Parcel {

    StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 40 + weight * 10;
    }

    String getType() {
        return "STANDARD";
    }
}

interface Insurable {
    double calculateInsurance();
}

class ExpressParcel extends Parcel implements Insurable {

    ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 80 + weight * 15;
    }

    public double calculateInsurance() {
        return declaredValue * 0.02;
    }

    String getType() {
        return "EXPRESS";
    }
}

class FragileParcel extends Parcel implements Insurable {

    FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 40 + weight * 10 + 50;
    }

    public double calculateInsurance() {
        return declaredValue * 0.02;
    }

    String getType() {
        return "FRAGILE";
    }
}

public class ParcelShippingDesk {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Parcel[] parcels = new Parcel[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();

            if (type.equals("STANDARD")) {

                parcels[i] =
                        new StandardParcel(weight, declaredValue);

            } else if (type.equals("EXPRESS")) {

                parcels[i] =
                        new ExpressParcel(weight, declaredValue);

            } else {

                parcels[i] =
                        new FragileParcel(weight, declaredValue);
            }
        }

        double grandTotal = 0;

        for (Parcel parcel : parcels) {

            parcel.display();

            grandTotal += parcel.calculateTotal();
        }

        System.out.printf(
                "Grand Total: %.2f%n",
                grandTotal
        );

        sc.close();
    }
}