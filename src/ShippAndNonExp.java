import java.time.LocalDate;

public class ShippAndNonExp extends NonExpirable implements Shippable {

    protected double weight;
    public ShippAndNonExp(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight=weight;
    }

    @Override
    public boolean isShippable() {
        return true;
    }

    public String getName() {
        return this.Name;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
