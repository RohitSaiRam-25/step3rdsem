import java.util.Scanner;

abstract class Staff {

    protected String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double calculatePay();

    void display() {
        System.out.printf("%s: %.2f%n",
                name, calculatePay());
    }
}

class FullTimeStaff extends Staff {

    private double weeklySalary;

    FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {

    private double hours;
    private double rate;

    HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double calculatePay() {

        if (hours <= 40) {
            return hours * rate;
        }

        double regularPay = 40 * rate;

        double overtimeHours = hours - 40;

        double overtimePay = overtimeHours * rate * 1.5;

        return regularPay + overtimePay;
    }
}

class InternStaff extends Staff {

    private double stipend;

    InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Staff[] staff = new Staff[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            if (type.equals("FULLTIME")) {

                double weeklySalary = sc.nextDouble();

                staff[i] =
                        new FullTimeStaff(name, weeklySalary);

            } else if (type.equals("HOURLY")) {

                double hours = sc.nextDouble();
                double rate = sc.nextDouble();

                staff[i] =
                        new HourlyStaff(name, hours, rate);

            } else {

                double stipend = sc.nextDouble();

                staff[i] =
                        new InternStaff(name, stipend);
            }
        }

        double total = 0;

        for (Staff person : staff) {

            person.display();

            total += person.calculatePay();
        }

        System.out.printf("Total Payroll: %.2f%n", total);

        sc.close();
    }
}