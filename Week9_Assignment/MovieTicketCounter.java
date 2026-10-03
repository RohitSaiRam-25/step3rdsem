import java.util.Scanner;

abstract class Ticket {

    protected int count;

    static final double CONVENIENCE_FEE = 20;

    Ticket(int count) {
        this.count = count;
    }

    abstract double getPrice();

    double calculateAmount() {
        return count * (getPrice() + CONVENIENCE_FEE);
    }

    abstract String getSeatType();

    void display() {
        System.out.printf("%s: %.2f%n",
                getSeatType(), calculateAmount());
    }
}

class RegularTicket extends Ticket {

    RegularTicket(int count) {
        super(count);
    }

    double getPrice() {
        return 150;
    }

    String getSeatType() {
        return "REGULAR";
    }
}

class PremiumTicket extends Ticket {

    PremiumTicket(int count) {
        super(count);
    }

    double getPrice() {
        return 250;
    }

    String getSeatType() {
        return "PREMIUM";
    }
}

class ReclinerTicket extends Ticket {

    ReclinerTicket(int count) {
        super(count);
    }

    double getPrice() {
        return 400;
    }

    String getSeatType() {
        return "RECLINER";
    }
}

public class MovieTicketCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Ticket[] tickets = new Ticket[n];

        for (int i = 0; i < n; i++) {

            String seat = sc.next();
            int count = sc.nextInt();

            if (seat.equals("REGULAR")) {

                tickets[i] = new RegularTicket(count);

            } else if (seat.equals("PREMIUM")) {

                tickets[i] = new PremiumTicket(count);

            } else {

                tickets[i] = new ReclinerTicket(count);
            }
        }

        double total = 0;

        for (Ticket ticket : tickets) {

            ticket.display();

            total += ticket.calculateAmount();
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}