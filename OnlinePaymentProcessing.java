import java.util.Scanner;

interface Payment {
    double calculateFee(double amount);
}

class CreditCardPayment implements Payment {
    @Override
    public double calculateFee(double amount) {
        return amount * 0.02;
    }
}

class UpiPayment implements Payment {
    @Override
    public double calculateFee(double amount) {
        return amount * 0.005;
    }
}

class WalletPayment implements Payment {
    @Override
    public double calculateFee(double amount) {
        return amount * 0.01;
    }
}

public class OnlinePaymentProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int paymentType = scanner.nextInt();
        double paymentAmount = scanner.nextDouble();

        Payment payment = null;

        if (paymentType == 1) {
            payment = new CreditCardPayment();
        } else if (paymentType == 2) {
            payment = new UpiPayment();
        } else if (paymentType == 3) {
            payment = new WalletPayment();
        }

        if (payment != null) {
            double transactionFee = payment.calculateFee(paymentAmount);
            double finalAmount = paymentAmount + transactionFee;

            System.out.printf("Payment Amount: %.2f%n", paymentAmount);
            System.out.printf("Transaction Fee: %.2f%n", transactionFee);
            System.out.printf("Final Amount: %.2f%n", finalAmount);
        }

        scanner.close();
    }
}