package CarLot;

import java.math.BigDecimal;

public class OverpaidPriceException extends Exception {
    private BigDecimal overpaidBy;

    public OverpaidPriceException(String message, BigDecimal overpaidBy) {
        super(message);
        this.overpaidBy = overpaidBy;
    }

    public BigDecimal getOverpaidBy() {
        return overpaidBy;
    }
}

