public abstract class AirplaneAtc {
    private final String callsign;      // read-only
    private int altitudeFeet;           // read/write
    private int headingDegrees;         // read/write
    private int speedKnots;             // read/write

    public AirplaneAtc(String callsign, int altitudeFeet, int headingDegrees, int speedKnots) {
        this.callsign = callsign;
        this.altitudeFeet = altitudeFeet;
        this.headingDegrees = headingDegrees;
        this.speedKnots = speedKnots;
    }

    public String getCallsign() {
        return callsign;
    }

    public int getAltitudeFeet() {
        return altitudeFeet;
    }

    public void setAltitudeFeet(int altitudeFeet) {
        this.altitudeFeet = altitudeFeet;
    }

    public int getHeadingDegrees() {
        return headingDegrees;
    }

    public void setHeadingDegrees(int headingDegrees) {
        this.headingDegrees = headingDegrees;
    }

    public int getSpeedKnots() {
        return speedKnots;
    }

    public void setSpeedKnots(int speedKnots) {
        this.speedKnots = speedKnots;
    }

    public abstract void reportPosition();

    public abstract boolean hasConflict(AirplaneAtc other);
}