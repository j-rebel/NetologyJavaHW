package netology.homework9t2;
import java.math.BigDecimal;

public abstract class TaxType {
    public abstract BigDecimal calculateTaxFor(BigDecimal amount);
}
