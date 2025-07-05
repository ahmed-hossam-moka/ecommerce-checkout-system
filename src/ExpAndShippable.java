import java.time.LocalDate;

public class ExpAndShippable extends Expirable implements Shippable {

    protected double weight;
    public ExpAndShippable(String name, double price, int quantity, LocalDate expirydate, double weight) {
        super(name, price, quantity, expirydate);
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
