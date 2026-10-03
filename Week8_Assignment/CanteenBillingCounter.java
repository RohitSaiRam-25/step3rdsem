import java.util.Scanner;

abstract class Customer {
    protected String type;
    protected double amount;

    Customer(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    abstract double calculateAmount();

    void display() {
        System.out.printf("%s: %.2f%n", type, calculateAmount());
    }
}

class Student extends Customer {

    Student(double amount) {
        super("STUDENT", amount);
    }

    double calculateAmount() {
        return amount * 0.90;
    }
}

class Staff extends Customer {

    Staff(double amount) {
        super("STAFF", amount);
    }

    double calculateAmount() {
        return amount * 0.95;
    }
}

class Guest extends Customer {

    Guest(double amount) {
        super("GUEST", amount);
    }

    double calculateAmount() {
        return amount + 10;
    }
}

public class CanteenBillingCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Customer[] customers = new Customer[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            if (type.equals("STUDENT")) {
                customers[i] = new Student(amount);
            } else if (type.equals("STAFF")) {
                customers[i] = new Staff(amount);
            } else {
                customers[i] = new Guest(amount);
            }
        }

        double total = 0;

        for (Customer customer : customers) {
            customer.display();
            total += customer.calculateAmount();
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}