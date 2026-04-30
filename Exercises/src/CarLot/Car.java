package CarLot;

import java.math.BigDecimal;

public class Car {
    private String VIN;
    private String make;
    private String model;
    private String color;

    private BigDecimal price;
    private long odometerMiles;

    private CarKey key;

    public Car() {
    }
    public Car(String VIN, String make, String model, String color) {
        this.VIN = VIN;
        this.make = make;
        this.model = model;
        this.color = color;

    }

    // plus getters, setters & appropriate constructors
    public void setVIN(String VIN) {
        this.VIN = VIN;
    }
    public String getVIN() {
        return VIN;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public String getMake() {
        return make;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getModel() {
        return model;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setOdometerMiles(long odometerMiles) {
        this.odometerMiles = odometerMiles;
    }
    public long getOdometerMiles() {
        return odometerMiles;
    }
    public void setKey(CarKey key) {
        this.key = key;
    }
    public CarKey getKey() {
        return key;
    }
}
