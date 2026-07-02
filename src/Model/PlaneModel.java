package Model;

public class PlaneModel {
    private String planeType;
    private double fuelBurn;
    private PlaneCategory category;

    public PlaneModel(String planeType, double fuelBurn, PlaneCategory category) {
        this.planeType = planeType;
        this.fuelBurn = fuelBurn;
        this.category = category;
    }

    
    public PlaneCategory getCategory() {
        return category;
    }

    public void setCategory(PlaneCategory category) {
        this.category = category;
    }

    public String getPlaneType() {
        return planeType;
    }
    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public double getFuelBurn() {
        return fuelBurn;
    }
    public void setFuelBurn(double fuelBurn) {
        this.fuelBurn = fuelBurn;
    }
}