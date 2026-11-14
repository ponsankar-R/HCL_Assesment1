import java.util.Scanner;

class Product {
    protected int productId;
    protected String productName;
    protected double price;

    public Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public double calculateDiscount() {
        return 0.0;
    }
}

class ElectronicsProduct extends Product {
    public ElectronicsProduct(int productId, String productName, double price) {
        super(productId, productName, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 12.0 / 100.0;
    }
}

class ClothingProduct extends Product {
    public ClothingProduct(int productId, String productName, double price) {
        super(productId, productName, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 20.0 / 100.0;
    }
}

class GroceryProduct extends Product {
    public GroceryProduct(int productId, String productName, double price) {
        super(productId, productName, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 5.0 / 100.0;
    }
}

public class ECommerceProductPricing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int productType = scanner.nextInt();
        int productId = scanner.nextInt();
        String productName = scanner.next();
        double price = scanner.nextDouble();

        Product product = null;

        if (productType == 1) {
            product = new ElectronicsProduct(productId, productName, price);
        } else if (productType == 2) {
            product = new ClothingProduct(productId, productName, price);
        } else if (productType == 3) {
            product = new GroceryProduct(productId, productName, price);
        }

        if (product != null) {
            double discount = product.calculateDiscount();
            double finalPrice = product.price - discount;

            System.out.println("Product ID: " + product.productId);
            System.out.println("Product Name: " + product.productName);
            System.out.printf("Discount: %.2f%n", discount);
            System.out.printf("Final Price: %.2f%n", finalPrice);
        }

        scanner.close();
    }
}