import java.time.LocalDate;
import java.util.Scanner;

abstract class StreamingPlan {
    protected String name;
    protected LocalDate startDate;

    StreamingPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract LocalDate calculateRenewalDate();

    void display() {
        System.out.println(name + ": " + calculateRenewalDate());
    }
}

class BasicPlan extends StreamingPlan {

    BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    LocalDate calculateRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends StreamingPlan {

    StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    LocalDate calculateRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends StreamingPlan {

    PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    LocalDate calculateRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class StreamingPlanRenewalReminder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        StreamingPlan[] plans = new StreamingPlan[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            if (type.equals("BASIC")) {
                plans[i] = new BasicPlan(name, startDate);
            } else if (type.equals("STANDARD")) {
                plans[i] = new StandardPlan(name, startDate);
            } else {
                plans[i] = new PremiumPlan(name, startDate);
            }
        }

        for (StreamingPlan plan : plans) {
            plan.display();
        }

        sc.close();
    }
}