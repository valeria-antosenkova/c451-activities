import java.time.LocalDate;

public class IceCreamStock {
    private String sku;
    private String flavor;
    private int containerSizeMl;
    private int unitsOnHand;
    private int reorderPoint;
    private LocalDate expirationDate;
    private double storageTempC;

    public IceCreamStock(String sku, String flavor, int containerSizeMl, int unitsOnHand,
                         int reorderPoint, LocalDate expirationDate, double storageTempC) {
        this.sku = sku;
        this.flavor = flavor;
        this.containerSizeMl = containerSizeMl;
        this.unitsOnHand = unitsOnHand;
        this.reorderPoint = reorderPoint;
        this.expirationDate = expirationDate;
        this.storageTempC = storageTempC;
    }

    public void receiveShipment(int units) {
        if (units > 0) {
            unitsOnHand += units;
        }
    }

    public boolean sellUnits(int units) {
        if (units <= 0 || units > unitsOnHand) {
            return false;
        }
        unitsOnHand -= units;
        return true;
    }

    public boolean isLowStock() {
        return unitsOnHand <= reorderPoint;
    }

    public boolean isExpired(LocalDate today) {
        return today.isAfter(expirationDate);
    }
}