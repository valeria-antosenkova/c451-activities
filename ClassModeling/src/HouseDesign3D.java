public abstract class HouseDesign3D {
    private final String modelName;     // read-only
    private int floors;                 // read/write
    private double widthMeters;         // read/write
    private double lengthMeters;        // read/write

    public HouseDesign3D(String modelName, int floors, double widthMeters, double lengthMeters) {
        this.modelName = modelName;
        this.floors = floors;
        this.widthMeters = widthMeters;
        this.lengthMeters = lengthMeters;
    }

    public String getModelName() {
        return modelName;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public double getWidthMeters() {
        return widthMeters;
    }

    public void setWidthMeters(double widthMeters) {
        this.widthMeters = widthMeters;
    }

    public double getLengthMeters() {
        return lengthMeters;
    }

    public void setLengthMeters(double lengthMeters) {
        this.lengthMeters = lengthMeters;
    }

    public abstract void renderPreview();

    public abstract double calculateFloorArea();
}