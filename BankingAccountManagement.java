import java.util.Scanner;


class BankAccount {
    protected int accountNumber;
    protected double balance;

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double calculateFinalBalance() {
        return balance;
    }
}


class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateFinalBalance() {
        return balance + (balance * interestRate / 100.0);
    }
}

class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(int accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double calculateFinalBalance() {
        return balance + overdraftLimit;
    }
}


public class BankingAccountManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int accountType = scanner.nextInt();
        int accountNumber = scanner.nextInt();
        double balance = scanner.nextDouble();

      
        BankAccount account = null;

        if (accountType == 1) {
            double interestRate = scanner.nextDouble();
            account = new SavingsAccount(accountNumber, balance, interestRate);
        } else if (accountType == 2) {
            double overdraftLimit = scanner.nextDouble();
            account = new CurrentAccount(accountNumber, balance, overdraftLimit);
        }

        if (account != null) {
            System.out.printf("%.2f%n", account.calculateFinalBalance());
        }

        scanner.close();
    }
}