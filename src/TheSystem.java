import java.util.ArrayList;
import java.util.List;

class TheSystem {
    private ShippingService shippingService;
    private static final double SHIPPING_RATE = 30.0;

    public TheSystem() {
        this.shippingService = new ShippingService();
    }

    public void checkout(Customer customer, ShoppingCart cart) throws CheckoutException {
        if (cart.isEmpty()) {
            throw new CheckoutException("Cart is empty");
        }

        List<Shippable> shippableItems = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();

            if (product.isExpirable()) {
                throw new CheckoutException("Product " + product.getName() + " is expired");
            }

            if (item.getQuantity() > product.getQuantity()) {
                throw new CheckoutException("Product " + product.getName() + " is out of stock");
            }

            if (product.isShippable() && product instanceof Shippable) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    shippableItems.add((Shippable) product);
                }
            }
        }

        double subtotal = cart.getSubtotal();
        double shippingFee = shippableItems.isEmpty() ? 0 : SHIPPING_RATE;
        double totalAmount = subtotal + shippingFee;

        if (customer.getBalance() < totalAmount) {
            throw new CheckoutException("no moeny");
        }

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            product.setQuantity(product.getQuantity() - item.getQuantity());
        }

        customer.deductBalance(totalAmount);

        if (!shippableItems.isEmpty()) {
            shippingService.ship(shippableItems);
        }

        System.out.println("-- Checkout receipt --");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %s %.0f%n",
                    item.getQuantity(),
                    item.getProduct().getName(),
                    item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f%n", subtotal);
        System.out.printf("Shipping %.0f%n", shippingFee);
        System.out.printf("Amount %.0f%n", totalAmount);
        System.out.printf("Customer balance after payment: %.2f%n", customer.getBalance());
        System.out.println("END.");

        cart.clear();
    }
}

class ShippingService {
    public void ship(List<Shippable> items) {
        if (items.isEmpty()) return;

        System.out.println("-- Shipment notice --");
        double totalWeight = 0;

        for (Shippable item : items) {
            System.out.printf("1x %s %.0fg%n", item.getName(), item.getWeight() * 1000);
            totalWeight += item.getWeight();
        }

        System.out.printf("Total package weight %.1fkg%n", totalWeight);
    }
}

class CheckoutException extends Exception {
    public CheckoutException(String message) {
        super(message);
    }
}
