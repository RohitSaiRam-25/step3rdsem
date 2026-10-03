import java.util.Scanner;

abstract class Room {
    protected String type;
    protected int units;

    Room(String type, int units) {
        this.type = type;
        this.units = units;
    }

    abstract double calculateBill();

    void display() {
        System.out.printf("%s: %.2f%n", type, calculateBill());
    }
}

class SingleRoom extends Room {

    SingleRoom(int units) {
        super("SINGLE", units);
    }

    double calculateBill() {
        return units * 8;
    }
}

class SharedRoom extends Room {

    private int occupants;

    SharedRoom(int units, int occupants) {
        super("SHARED", units);
        this.occupants = occupants;
    }

    double calculateBill() {
        return (units * 6) / occupants;
    }
}

class ACRoom extends Room {

    ACRoom(int units) {
        super("AC", units);
    }

    double calculateBill() {
        return units * 10 + 200;
    }
}

public class HostelElectricityBill {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Room[] rooms = new Room[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int units = sc.nextInt();

            if (type.equals("SINGLE")) {
                rooms[i] = new SingleRoom(units);
            } else if (type.equals("SHARED")) {

                int occupants = sc.nextInt();

                rooms[i] = new SharedRoom(units, occupants);
            } else {
                rooms[i] = new ACRoom(units);
            }
        }

        double total = 0;

        for (Room room : rooms) {
            room.display();
            total += room.calculateBill();
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}