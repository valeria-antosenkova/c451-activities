public class HouseGps {
    private String parcelId;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private double latitude;
    private double longitude;

    public HouseGps(String parcelId, String streetAddress, String city, String state, String zipCode,
                    double latitude, double longitude) {
        this.parcelId = parcelId;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void updateCoordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getFullAddress() {
        return streetAddress + ", " + city + ", " + state + " " + zipCode;
    }

    public double distanceToKm(HouseGps other) {
        final double earthRadiusKm = 6371.0;
        double lat1 = Math.toRadians(this.latitude);
        double lat2 = Math.toRadians(other.latitude);
        double deltaLat = Math.toRadians(other.latitude - this.latitude);
        double deltaLon = Math.toRadians(other.longitude - this.longitude);

        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return earthRadiusKm * c;
    }

    public String getParcelId() {
        return parcelId;
    }
}