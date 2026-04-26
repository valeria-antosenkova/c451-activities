public class AirplaneSimulator {
    private String aircraftModel;
    private double fuelKg;
    private double thrustPercent;
    private double pitch;
    private double roll;
    private double yaw;
    private int flapsPosition;
    private boolean gearDown;
    private double airspeedKnots;
    private double altitudeFeet;

    public AirplaneSimulator(String aircraftModel, double fuelKg) {
        this.aircraftModel = aircraftModel;
        this.fuelKg = fuelKg;
        this.thrustPercent = 0;
        this.gearDown = true;
    }

    public void setControlInputs(double pitch, double roll, double yaw) {
        this.pitch = pitch;
        this.roll = roll;
        this.yaw = yaw;
    }

    public void setThrustPercent(double thrustPercent) {
        if (thrustPercent < 0) {
            this.thrustPercent = 0;
        } else if (thrustPercent > 100) {
            this.thrustPercent = 100;
        } else {
            this.thrustPercent = thrustPercent;
        }
    }

    public void setFlapsPosition(int flapsPosition) {
        if (flapsPosition >= 0 && flapsPosition <= 4) {
            this.flapsPosition = flapsPosition;
        }
    }

    public void setGearDown(boolean gearDown) {
        this.gearDown = gearDown;
    }

    public void simulateStep(double seconds) {
        airspeedKnots += (thrustPercent * 0.06 - flapsPosition * 0.7) * seconds;
        altitudeFeet += (pitch * 15) * seconds;
        fuelKg -= thrustPercent * 0.02 * seconds;
        if (fuelKg < 0) {
            fuelKg = 0;
        }
        if (airspeedKnots < 0) {
            airspeedKnots = 0;
        }
    }
}