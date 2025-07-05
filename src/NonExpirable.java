import java.time.LocalDate;

public abstract class NonExpirable extends Product {


    public NonExpirable(String name, double price, int quantity) {
        super(name, price, quantity);
    }
    public boolean isExpirable() {
        return false;
    }
}
