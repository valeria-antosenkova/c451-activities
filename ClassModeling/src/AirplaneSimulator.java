public abstract class AirplaneSimulator {
    private final String aircraftModel; // read-only
    private double throttlePercent;     // read/write
    private double pitch;               // read/write
    private double roll;                // read/write

    public AirplaneSimulator(String aircraftModel, double throttlePercent, double pitch, double roll) {
        this.aircraftModel = aircraftModel;
        this.throttlePercent = throttlePercent;
        this.pitch = pitch;
        this.roll = roll;
    }

    public String getAircraftModel() {
        return aircraftModel;
    }

    public double getThrottlePercent() {
        return throttlePercent;
    }

    public void setThrottlePercent(double throttlePercent) {
        this.throttlePercent = throttlePercent;
    }

    public double getPitch() {
        return pitch;
    }

    public void setPitch(double pitch) {
        this.pitch = pitch;
    }

    public double getRoll() {
        return roll;
    }

    public void setRoll(double roll) {
        this.roll = roll;
    }

    public abstract void applyControls();

    public abstract void simulateStep(double seconds);
}