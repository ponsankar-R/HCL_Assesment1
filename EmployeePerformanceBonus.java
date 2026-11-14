import java.util.Scanner;

class Employee {
    protected String employeeName;

    public Employee(String employeeName) {
        this.employeeName = employeeName;
    }

    public double calculateBonus() {
        return 0.0;
    }

    public double calculateBonus(double amount) {
        return 0.0;
    }
}

class TechnicalEmployee extends Employee {
    private double basicSalary;
    private int rating;

    public TechnicalEmployee(String employeeName, double basicSalary, int rating) {
        super(employeeName);
        this.basicSalary = basicSalary;
        this.rating = rating;
    }

    @Override
    public double calculateBonus() {
        return calculateBonus(basicSalary, rating);
    }

    public double calculateBonus(double salary, int employeeRating) {
        return salary * employeeRating * 2.0 / 100.0;
    }
}

class SalesEmployee extends Employee {
    private double salesAmount;

    public SalesEmployee(String employeeName, double salesAmount) {
        super(employeeName);
        this.salesAmount = salesAmount;
    }

    @Override
    public double calculateBonus() {
        return calculateBonus(salesAmount);
    }

    @Override
    public double calculateBonus(double amount) {
        return amount * 3.0 / 100.0;
    }
}

public class EmployeePerformanceBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int employeeType = scanner.nextInt();
        String employeeName = scanner.next();

        Employee emp = null;
        double baseEarnings = 0.0;

        if (employeeType == 1) {
            double basicSalary = scanner.nextDouble();
            int rating = scanner.nextInt();
            emp = new TechnicalEmployee(employeeName, basicSalary, rating);
            baseEarnings = basicSalary;
        } else if (employeeType == 2) {
            double salesAmount = scanner.nextDouble();
            emp = new SalesEmployee(employeeName, salesAmount);
            baseEarnings = salesAmount;
        }

        if (emp != null) {
            double bonus = emp.calculateBonus();
            double totalEarnings = baseEarnings + bonus;

            System.out.println("Employee Name: " + emp.employeeName);
            System.out.printf("Bonus: %.2f%n", bonus);
            System.out.printf("Total Earnings: %.2f%n", totalEarnings);
        }

        scanner.close();
    }
}