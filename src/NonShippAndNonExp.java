import java.time.LocalDate;

public class NonShippAndNonExp extends NonExpirable{

    public NonShippAndNonExp(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public boolean isShippable() {
        return false;
    }
}
