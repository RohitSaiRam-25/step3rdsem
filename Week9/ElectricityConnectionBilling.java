
import java.util.Scanner;

abstract class ElectricityConnection {

    protected int units;

    ElectricityConnection(int units) {
        this.units = units;
    }

    abstract double calculateBill();

    abstract String getType();

    void display() {
        System.out.printf("%s: %.2f%n",
                getType(), calculateBill());
    }
}

class HomeConnection extends ElectricityConnection {

    HomeConnection(int units) {
        super(units);
    }

    double calculateBill() {

        if (units <= 100) {
            return units * 5;
        }

        return 100 * 5 + (units - 100) * 7;
    }

    String getType() {
        return "HOME";
    }
}

class ShopConnection extends ElectricityConnection {

    ShopConnection(int units) {
        super(units);
    }

    double calculateBill() {
        return units * 8 + 100;
    }

    String getType() {
        return "SHOP";
    }
}

class FactoryConnection extends ElectricityConnection {

    FactoryConnection(int units) {
        super(units);
    }

    double calculateBill() {

        double bill = units * 6;

        if (bill < 1000) {
            bill = 1000;
        }

        return bill;
    }

    String getType() {
        return "FACTORY";
    }
}

public class ElectricityConnectionBilling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ElectricityConnection[] connections =
                new ElectricityConnection[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int units = sc.nextInt();

            if (type.equals("HOME")) {

                connections[i] =
                        new HomeConnection(units);

            } else if (type.equals("SHOP")) {

                connections[i] =
                        new ShopConnection(units);

            } else {

                connections[i] =
                        new FactoryConnection(units);
            }
        }

        double total = 0;

        for (ElectricityConnection connection : connections) {

            connection.display();

            total += connection.calculateBill();
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}