public class AirplaneAtc {
    private String callsign;
    private String transponderCode;
    private double latitude;
    private double longitude;
    private int altitudeFeet;
    private int headingDegrees;
    private int groundSpeedKnots;

    public AirplaneAtc(String callsign, String transponderCode, double latitude, double longitude,
                       int altitudeFeet, int headingDegrees, int groundSpeedKnots) {
        this.callsign = callsign;
        this.transponderCode = transponderCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitudeFeet = altitudeFeet;
        this.headingDegrees = headingDegrees;
        this.groundSpeedKnots = groundSpeedKnots;
    }

    public void updateRadarPosition(double latitude, double longitude, int altitudeFeet) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitudeFeet = altitudeFeet;
    }

    public void assignHeading(int headingDegrees) {
        this.headingDegrees = ((headingDegrees % 360) + 360) % 360;
    }

    public void assignSpeed(int groundSpeedKnots) {
        if (groundSpeedKnots > 0) {
            this.groundSpeedKnots = groundSpeedKnots;
        }
    }

    public boolean hasPotentialConflict(AirplaneAtc other) {
        double latDiff = Math.abs(this.latitude - other.latitude);
        double lonDiff = Math.abs(this.longitude - other.longitude);
        int altitudeDiff = Math.abs(this.altitudeFeet - other.altitudeFeet);

        return latDiff < 0.08 && lonDiff < 0.08 && altitudeDiff < 1000;
    }

    public String getCallsign() {
        return callsign;
    }
}