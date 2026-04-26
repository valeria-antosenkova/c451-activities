public class IceCreamProduction {
    private String batchId;
    private String flavor;
    private double mixVolumeLiters;
    private double fatPercent;
    private double temperatureC;
    private boolean pasteurized;
    private boolean homogenized;
    private boolean aged;
    private double packagedLiters;

    public IceCreamProduction(String batchId, String flavor, double mixVolumeLiters, double fatPercent) {
        this.batchId = batchId;
        this.flavor = flavor;
        this.mixVolumeLiters = mixVolumeLiters;
        this.fatPercent = fatPercent;
        this.temperatureC = 22;
    }

    public void pasteurize() {
        this.temperatureC = 83;
        this.pasteurized = true;
    }

    public void homogenize() {
        if (pasteurized) {
            this.homogenized = true;
        }
    }

    public void ageMix() {
        if (homogenized) {
            this.temperatureC = 4;
            this.aged = true;
        }
    }

    public void freezeAndPackage(double overrunPercent) {
        if (!aged || overrunPercent < 0) {
            return;
        }
        this.temperatureC = -6;
        this.packagedLiters = mixVolumeLiters * (1 + overrunPercent / 100.0);
    }

    public boolean qualityCheckPassed() {
        return pasteurized && homogenized && aged && fatPercent >= 8.0;
    }
}