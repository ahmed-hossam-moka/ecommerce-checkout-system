import java.time.LocalDate;

class Main {
    public static void main(String[] args) {
        try {
            Product cheese = new ExpAndShippable("Cheese", 80, 20,
                    LocalDate.now().plusDays(5), 0.5);
            Product tv = new ShippAndNonExp("TV", 2000, 50, 5);
            Product scratchCard = new NonShippAndNonExp("Mobile Scratch ", 20, 10);

            Customer customer = new Customer("Ahmed Hossam", 5000);

            ShoppingCart cart = new ShoppingCart();
            cart.add(cheese, 2);
            cart.add(tv, 1);
            cart.add(scratchCard, 1);

            TheSystem system = new TheSystem();
            system.checkout(customer, cart);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}