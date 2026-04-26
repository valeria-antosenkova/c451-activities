public class CarInventory {
    private String vin;
    private String make;
    private String model;
    private int year;
    private int mileage;
    private String color;
    private double listPrice;
    private boolean sold;

    public CarInventory(String vin, String make, String model, int year, int mileage, String color, double listPrice) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.color = color;
        this.listPrice = listPrice;
        this.sold = false;
    }

    public String getDisplayName() {
        return year + " " + make + " " + model;
    }

    public void applyDiscountPercent(double percent) {
        if (percent > 0 && percent <= 100) {
            listPrice -= listPrice * (percent / 100.0);
        }
    }

    public void markSold() {
        this.sold = true;
    }

    public void updateMileage(int mileage) {
        if (mileage >= this.mileage) {
            this.mileage = mileage;
        }
    }

    public double getListPrice() {
        return listPrice;
    }
}