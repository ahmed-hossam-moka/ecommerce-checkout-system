# E-commerce Checkout System 🛒

This project simulates an e-commerce checkout system in **Java**, built as part of the **Fawry Internship Challenge**.

## ✅ Features

- Define products with name, price, quantity.
- Support for:
  - Perishable products (with expiry)
  - Shippable products (with weight)
- Cart management:
  - Add products to cart with quantity limit
- Checkout system:
  - Validates balance, product availability, and expiry
  - Calculates subtotal, shipping, total amount
  - Sends shippable items to shipping service
- Clean OOP design using Java classes and interfaces

## 📦 Classes Overview

- `Product` (Abstract)
- `PerishableProduct`, `NonPerishableProduct`
- `ShippableProduct`, `Shippable` interface
- `Customer`, `Cart`, `CartItem`
- `CheckoutService`, `ShippingService`

## 🧪 Example Usage

```java
cart.add(cheese, 2);
cart.add(tv, 1);
cart.add(scratchCard, 1);
checkout(customer, cart);

🖨 Console Output Example:

** Shipment notice **
Cheese    400g
TV        7000g
Total package weight 7.4kg

** Checkout receipt **
2x Cheese        200
1x TV            300
1x Scratch Card   50
----------------------
Subtotal         550
Shipping          45
Amount           595
Balance left:    405
END.

🛠 Requirements
Java 8 or higher

Terminal / IDE like IntelliJ, VS Code, Eclipse

📄 License
This project is for learning purposes and internship evaluation only.

sql
Copy
Edit

### Then commit and push it:

```bash
git add README.md
git commit -m "Add README file"
git push