public class CarVideoGame {
    private String name;
    private double topSpeed;
    private double acceleration;
    private double handling;
    private double durability;
    private double nitroLevel;
    private double currentSpeed;
    private double health;

    public CarVideoGame(String name, double topSpeed, double acceleration, double handling, double durability) {
        this.name = name;
        this.topSpeed = topSpeed;
        this.acceleration = acceleration;
        this.handling = handling;
        this.durability = durability;
        this.nitroLevel = 100;
        this.health = 100;
    }

    public void accelerate(double seconds) {
        currentSpeed += acceleration * seconds;
        if (currentSpeed > topSpeed) {
            currentSpeed = topSpeed;
        }
    }

    public void brake(double seconds) {
        currentSpeed -= (acceleration * 1.3) * seconds;
        if (currentSpeed < 0) {
            currentSpeed = 0;
        }
    }

    public double steer(double turnInput) {
        return turnInput * handling;
    }

    public void useNitro(double seconds) {
        if (nitroLevel <= 0) {
            return;
        }
        double consumed = 15 * seconds;
        nitroLevel = Math.max(0, nitroLevel - consumed);
        currentSpeed = Math.min(topSpeed * 1.2, currentSpeed + 25 * seconds);
    }

    public void takeDamage(double impactForce) {
        double damage = impactForce / durability;
        health = Math.max(0, health - damage);
    }
}