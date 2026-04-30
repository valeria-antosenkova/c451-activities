package CarLot;

import java.math.BigDecimal;

public class UnderpaidPriceException extends Exception {
    private BigDecimal underpaidBy;

    public UnderpaidPriceException(String message, BigDecimal underpaidBy) {
        super(message);
        this.underpaidBy = underpaidBy;
    }

    public BigDecimal getUnderpaidBy() {
        return underpaidBy;
    }
}

