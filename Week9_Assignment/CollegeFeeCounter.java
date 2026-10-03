import java.util.Scanner;

abstract class Student {

    protected String name;

    static final double TRANSPORT_FEE = 12000;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateTuition();

    boolean usesBus() {
        return false;
    }

    double calculateTotalFee() {

        double fee = calculateTuition();

        if (usesBus()) {
            fee += TRANSPORT_FEE;
        }

        return fee;
    }

    void display() {

        System.out.printf("%s: %.2f%n",
                name, calculateTotalFee());
    }
}

class DayScholar extends Student {

    DayScholar(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000;
    }

    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {

    Hosteller(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000 + 60000;
    }
}

class ScholarshipStudent extends Student {

    ScholarshipStudent(String name) {
        super(name);
    }

    double calculateTuition() {
        return 20000;
    }

    boolean usesBus() {
        return true;
    }
}

public class CollegeFeeCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            if (type.equals("DAY_SCHOLAR")) {

                students[i] =
                        new DayScholar(name);

            } else if (type.equals("HOSTELLER")) {

                students[i] =
                        new Hosteller(name);

            } else {

                students[i] =
                        new ScholarshipStudent(name);
            }
        }

        double total = 0;

        for (Student student : students) {

            student.display();

            total += student.calculateTotalFee();
        }

        System.out.printf(
                "Total Collected: %.2f%n",
                total
        );

        sc.close();
    }
}