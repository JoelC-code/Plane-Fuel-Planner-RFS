package Model;

public enum PlaneCategory {
    GENERAL_AVIATION(100, 15.0/60.0),
    REGIONAL(250, 18.0/60.0),
    NARROW_BODY(500, 24.0/60.0),
    WIDE_BODY(3000, 28.0/60.0),
    HEAVY_CARGO(5000, 28.0/60.0),
    SPECIAL(4000, 28.0/60.0);

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
