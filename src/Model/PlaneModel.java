package Model;

public class PlaneModel {
    private String planeType;
    private double fuelBurn;
    private boolean isNarrowBodies;

    public PlaneModel(String planeType, double fuelBurn, boolean isNarrowBodies) {
        this.planeType = planeType;
        this.fuelBurn = fuelBurn;
        this.isNarrowBodies = isNarrowBodies;
    }

    
    public boolean isNarrowBodies() {
        return isNarrowBodies;
    }

    public void setNarrowBodies(boolean isNarrowBodies) {
        this.isNarrowBodies = isNarrowBodies;
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