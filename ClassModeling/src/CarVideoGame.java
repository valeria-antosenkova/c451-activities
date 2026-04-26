public abstract class CarVideoGame {
    private final String carId;         // read-only
    private double speed;               // read/write
    private double health;              // read/write
    private double nitro;               // read/write

    public CarVideoGame(String carId, double speed, double health, double nitro) {
        this.carId = carId;
        this.speed = speed;
        this.health = health;
        this.nitro = nitro;
    }

    public String getCarId() {
        return carId;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getNitro() {
        return nitro;
    }

    public void setNitro(double nitro) {
        this.nitro = nitro;
    }

    public abstract void accelerate();

    public abstract void brake();

    public abstract void useNitro();
}