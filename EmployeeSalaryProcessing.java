import java.util.Scanner;


abstract class Employee {
    private int employeeId;
    private String employeeName;

    public Employee(int employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public abstract double calculateSalary();
}


class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(int employeeId, String employeeName, double monthlySalary) {
        super(employeeId, employeeName);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}


class ContractEmployee extends Employee {
    private int workingDays;
    private double dailyRate;

    public ContractEmployee(int employeeId, String employeeName, int workingDays, double dailyRate) {
        super(employeeId, employeeName);
        this.workingDays = workingDays;
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateSalary() {
        return workingDays * dailyRate;
    }
}


public class EmployeeSalaryProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int employeeType = scanner.nextInt();
        int employeeId = scanner.nextInt();
        String employeeName = scanner.next();

        Employee emp = null;

        if (employeeType == 1) {
            double monthlySalary = scanner.nextDouble();
            emp = new FullTimeEmployee(employeeId, employeeName, monthlySalary);
        } else if (employeeType == 2) {
            int workingDays = scanner.nextInt();
            double dailyRate = scanner.nextDouble();
            emp = new ContractEmployee(employeeId, employeeName, workingDays, dailyRate);
        }

        if (emp != null) {
            System.out.println("Employee ID: " + emp.getEmployeeId());
            System.out.println("Employee Name: " + emp.getEmployeeName());
            System.out.printf("Salary: %.2f%n", emp.calculateSalary());
        }

        scanner.close();
    }
}