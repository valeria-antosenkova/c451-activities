public class HouseDesign3D {
    private String modelName;
    private int floors;
    private double widthMeters;
    private double lengthMeters;
    private double wallHeightMeters;
    private String roofStyle;
    private int windowCount;
    private int doorCount;
    private boolean hasGarage;

    public HouseDesign3D(String modelName, int floors, double widthMeters, double lengthMeters,
                         double wallHeightMeters, String roofStyle, boolean hasGarage) {
        this.modelName = modelName;
        this.floors = floors;
        this.widthMeters = widthMeters;
        this.lengthMeters = lengthMeters;
        this.wallHeightMeters = wallHeightMeters;
        this.roofStyle = roofStyle;
        this.hasGarage = hasGarage;
    }

    public void addWindows(int count) {
        if (count > 0) {
            this.windowCount += count;
        }
    }

    public void addDoors(int count) {
        if (count > 0) {
            this.doorCount += count;
        }
    }

    public double getFootprintAreaSqM() {
        return widthMeters * lengthMeters;
    }

    public double getInteriorVolumeCubicM() {
        return getFootprintAreaSqM() * wallHeightMeters * floors;
    }

    public void resize(double newWidthMeters, double newLengthMeters, double newWallHeightMeters) {
        if (newWidthMeters > 0 && newLengthMeters > 0 && newWallHeightMeters > 0) {
            this.widthMeters = newWidthMeters;
            this.lengthMeters = newLengthMeters;
            this.wallHeightMeters = newWallHeightMeters;
        }
    }
}