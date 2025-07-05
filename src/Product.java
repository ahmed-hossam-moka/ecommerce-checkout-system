public abstract class Product {
    protected String Name;
    protected double Price;
    protected int Quantity;

    public Product(String name, double price, int quantity) {
        Name = name;
        Price = price;
        Quantity = quantity;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return Price;
    }
    public void setPrice(double price) {
        Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }
    public void setQuantity(int quantity) {
        Quantity = quantity;
    }


    public void reduceQuantity(int amount) {
        if (amount > Quantity) throw new IllegalArgumentException("The Quantity .");
        Quantity -= amount;
    }

    public boolean isAvailable(int requestedQuantity) {
        return requestedQuantity <= Quantity;
    }

    public abstract boolean isExpirable();
    public abstract boolean isShippable();

}
