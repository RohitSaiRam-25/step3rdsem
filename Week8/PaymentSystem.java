import java.util.Scanner;

interface PaymentMethod {
    double calculateAmount(double amount);
}

class CardPayment implements PaymentMethod {

    public double calculateAmount(double amount) {
        return amount + (amount * 0.02);
    }
}

class WalletPayment implements PaymentMethod {

    public double calculateAmount(double amount) {
        return amount + (amount * 0.01);
    }
}

class BankTransferPayment implements PaymentMethod {

    public double calculateAmount(double amount) {
        return amount;
    }
}

class Transaction {
    String type;
    double amount;
    PaymentMethod paymentMethod;

    Transaction(String type, double amount, PaymentMethod paymentMethod) {
        this.type = type;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    double getAdjustedAmount() {
        return paymentMethod.calculateAmount(amount);
    }
}

public class PaymentSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            PaymentMethod paymentMethod;

            if (type.equals("CARD")) {
                paymentMethod = new CardPayment();
            } else if (type.equals("WALLET")) {
                paymentMethod = new WalletPayment();
            } else {
                paymentMethod = new BankTransferPayment();
            }

            Transaction transaction =
                new Transaction(type, amount, paymentMethod);

            double adjustedAmount =
                transaction.getAdjustedAmount();

            total += adjustedAmount;

            System.out.printf(
                "%s: %.2f%n",
                type,
                adjustedAmount
            );
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}