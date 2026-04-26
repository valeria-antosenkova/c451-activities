public abstract class IceCreamProduction {
    private final String batchId;       // read-only
    private final String flavor;        // read-only
    private double temperatureC;        // read/write
    private double volumeLiters;        // read/write

    public IceCreamProduction(String batchId, String flavor, double temperatureC, double volumeLiters) {
        this.batchId = batchId;
        this.flavor = flavor;
        this.temperatureC = temperatureC;
        this.volumeLiters = volumeLiters;
    }

    public String getBatchId() {
        return batchId;
    }

    public String getFlavor() {
        return flavor;
    }

    public double getTemperatureC() {
        return temperatureC;
    }

    public void setTemperatureC(double temperatureC) {
        this.temperatureC = temperatureC;
    }

    public double getVolumeLiters() {
        return volumeLiters;
    }

    public void setVolumeLiters(double volumeLiters) {
        this.volumeLiters = volumeLiters;
    }

    public abstract void pasteurize();

    public abstract void freeze();

    public abstract boolean passesQualityCheck();
}