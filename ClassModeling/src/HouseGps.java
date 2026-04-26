public abstract class HouseGps {
    private final String parcelId;      // read-only
    private final String address;       // read-only
    private double latitude;            // read/write
    private double longitude;           // read/write

    public HouseGps(String parcelId, String address, double latitude, double longitude) {
        this.parcelId = parcelId;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getParcelId() {
        return parcelId;
    }

    public String getAddress() {
        return address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public abstract double distanceTo(double targetLatitude, double targetLongitude);

    public abstract void updateMapMarker();
}