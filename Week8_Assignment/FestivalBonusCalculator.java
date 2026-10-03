import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateBonus();

    void display() {
        System.out.printf("%s: %.2f%n", name, calculateBonus());
    }
}

class FullTimeEmployee extends Employee {

    FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTimeEmployee extends Employee {

    PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return salary * 0.05;
    }
}

class Intern extends Employee {

    Intern(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return 2000;
    }
}

public class FestivalBonusCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equals("FULLTIME")) {
                employees[i] = new FullTimeEmployee(name, salary);
            } else if (type.equals("PARTTIME")) {
                employees[i] = new PartTimeEmployee(name, salary);
            } else {
                employees[i] = new Intern(name, salary);
            }
        }

        double total = 0;

        for (Employee employee : employees) {
            employee.display();
            total += employee.calculateBonus();
        }

        System.out.printf("Total Bonus: %.2f%n", total);

        sc.close();
    }
}