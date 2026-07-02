package Model;

public enum PlaneCategory {
    REGIONAL(250, 20.0/60.0),
    NARROW_BODY(500, 24.0/60.0),
    WIDE_BODY(1500, 28.0/60.0);

    public final double taxiFuel;
    public final double climbHour;

    PlaneCategory(double taxiFuel, double climbHours) {
        this.taxiFuel = taxiFuel;
        this.climbHour = climbHours;
    }

    public double getTaxiFuel() {
        return taxiFuel;
    }

    public double getClimbHours() {
        return climbHour;
    }
}
