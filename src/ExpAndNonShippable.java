import java.time.LocalDate;

public class ExpAndNonShippable extends Expirable {
    public ExpAndNonShippable(String name, double price, int quantity, LocalDate expirydate) {
        super(name, price, quantity, expirydate);
    }

    @Override
    public boolean isShippable() {
        return false;
    }
}
