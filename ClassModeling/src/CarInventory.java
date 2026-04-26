public abstract class CarInventory {
    private final String vin;           // read-only
    private String make;                // read/write
    private double listPrice;           // read/write
    private boolean sold;               // read/write

    public CarInventory(String vin, String make, double listPrice, boolean sold) {
        this.vin = vin;
        this.make = make;
        this.listPrice = listPrice;
        this.sold = sold;
    }

    public String getVin() {
        return vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public abstract void markSold();

    public abstract void applyDiscount(double percent);
}