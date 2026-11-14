import java.util.Scanner;

class Delivery {
    protected double orderAmount;

    public Delivery(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public double calculateDeliveryCharge() {
        return orderAmount;
    }
}

class RegularDelivery extends Delivery {
    public RegularDelivery(double orderAmount) {
        super(orderAmount);
    }

    @Override
    public double calculateDeliveryCharge() {
        return orderAmount + 40.0;
    }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double orderAmount) {
        super(orderAmount);
    }

    @Override
    public double calculateDeliveryCharge() {
        return orderAmount + 80.0 + (orderAmount * 5.0 / 100.0);
    }
}

public class FoodDeliveryOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int deliveryType = scanner.nextInt();
        double orderAmount = scanner.nextDouble();

        Delivery delivery = null;

        if (deliveryType == 1) {
            delivery = new RegularDelivery(orderAmount);
        } else if (deliveryType == 2) {
            delivery = new ExpressDelivery(orderAmount);
        }

        if (delivery != null) {
            System.out.printf("%.2f%n", delivery.calculateDeliveryCharge());
        }

        scanner.close();
    }
}