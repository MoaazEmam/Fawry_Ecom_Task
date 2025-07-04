import java.time.LocalDate;

public interface Expriable {
    LocalDate getExpiryDate();
    boolean isExpired();
}
