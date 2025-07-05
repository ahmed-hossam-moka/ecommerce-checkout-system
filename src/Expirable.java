import java.time.LocalDate;

public abstract class Expirable extends Product {

    private LocalDate expiryDate;

    public Expirable(String name, double price, int quantity, LocalDate expirydate) {
        super(name, price, quantity);
        this.expiryDate=expirydate;
    }
    public boolean isExpirable() {
        return LocalDate.now().isAfter(expiryDate);
    }
}
