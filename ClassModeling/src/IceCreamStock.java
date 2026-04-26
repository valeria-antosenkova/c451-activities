public abstract class IceCreamStock {
    private final String sku;           // read-only
    private final String flavor;        // read-only
    private int unitsOnHand;            // read/write
    private int reorderPoint;           // read/write

    public IceCreamStock(String sku, String flavor, int unitsOnHand, int reorderPoint) {
        this.sku = sku;
        this.flavor = flavor;
        this.unitsOnHand = unitsOnHand;
        this.reorderPoint = reorderPoint;
    }

    public String getSku() {
        return sku;
    }

    public String getFlavor() {
        return flavor;
    }

    public int getUnitsOnHand() {
        return unitsOnHand;
    }

    public void setUnitsOnHand(int unitsOnHand) {
        this.unitsOnHand = unitsOnHand;
    }

    public int getReorderPoint() {
        return reorderPoint;
    }

    public void setReorderPoint(int reorderPoint) {
        this.reorderPoint = reorderPoint;
    }

    public abstract void restock(int units);

    public abstract boolean sell(int units);

    public abstract boolean isLowStock();
}