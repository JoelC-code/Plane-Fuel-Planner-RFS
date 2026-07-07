package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Model.PlaneCategory;
import Model.PlaneModel;

public class PlaneFuelController {
    private ArrayList<PlaneModel> listPlanes;
    private Scanner scan;
    private boolean isValid;

    private void planeDatabase() {
        listPlanes.add(new PlaneModel("(M) AIRBUS A220-300", 1775, PlaneCategory.NARROW_BODY));
        listPlanes.add(new PlaneModel("(M) AIRBUS A310-300", 4550, PlaneCategory.WIDE_BODY));
        listPlanes.add(new PlaneModel("(M) AIRBUS A318-100", 2200, PlaneCategory.REGIONAL));
        listPlanes.add(new PlaneModel("(M) AIRBUS A319-100", 2300, PlaneCategory.REGIONAL));
        listPlanes.add(new PlaneModel("(M) AIRBUS A320-200", 2400, PlaneCategory.REGIONAL));
        listPlanes.add(new PlaneModel("(M) AIRBUS A321-200", 2500, PlaneCategory.REGIONAL));
        listPlanes.add(new PlaneModel("(M) AIRBUS A320neo", 2250, PlaneCategory.REGIONAL));
        listPlanes.add(new PlaneModel("(M) AIRBUS A330-300", 4500, PlaneCategory.WIDE_BODY));
        listPlanes.add(new PlaneModel("AIRBUS A330-200", 4000, PlaneCategory.WIDE_BODY));
        listPlanes.add(new PlaneModel("(M) AIRBUS A330-700", 5750, PlaneCategory.HEAVY_CARGO));
        listPlanes.add(new PlaneModel("AIRBUS A330-900neo", 5000, PlaneCategory.WIDE_BODY));
        listPlanes.add(new PlaneModel("(M) AIRBUS A340-200", 5000, PlaneCategory.WIDE_BODY));
        listPlanes.add(new PlaneModel("(M) AIRBUS A340-600", 8100, PlaneCategory.WIDE_BODY));
        listPlanes.add(new PlaneModel("(M) AIRBUS A350-900", 5700, PlaneCategory.WIDE_BODY));
        listPlanes.add(new PlaneModel("(M) AIRBUS A350-1000", 6500, PlaneCategory.WIDE_BODY));
        listPlanes.add(new PlaneModel("AIRBUS A380-800", 11000, PlaneCategory.WIDE_BODY));
        listPlanes.add(new PlaneModel("(M) BOEING B707-320C", 7000, PlaneCategory.WIDE_BODY));
        listPlanes.add(new PlaneModel("(M) BOEING B727-200", 3900, PlaneCategory.NARROW_BODY));
        listPlanes.add(new PlaneModel("(M) BOEING B727-200WL", 3665, PlaneCategory.NARROW_BODY));
        listPlanes.add(new PlaneModel("(M) BOEING B737-100", 2500, PlaneCategory.NARROW_BODY));
        listPlanes.add(new PlaneModel("(M) BOEING B737-200", 2500, PlaneCategory.NARROW_BODY));
        listPlanes.add(new PlaneModel("(M) BOEING B737-800", 2450, PlaneCategory.NARROW_BODY));
        listPlanes.add(new PlaneModel("(M) BOEING B737 MAX8", 2700, PlaneCategory.NARROW_BODY));
        listPlanes.add(new PlaneModel("(M) BOEING B747-200B", 10000, PlaneCategory.WIDE_BODY));
        listPlanes.add(new PlaneModel("(M) BOEING B747-400", 11000, PlaneCategory.WIDE_BODY));
        listPlanes.add(new PlaneModel("(MM) BOEING B747-8I", 9600, PlaneCategory.WIDE_BODY));
        listPlanes.add(new PlaneModel("(M) BOEING B757-200", 2750, PlaneCategory.NARROW_BODY));
        listPlanes.add(new PlaneModel("(M) BOEING B757-300", 3150, PlaneCategory.NARROW_BODY));
        listPlanes.add(new PlaneModel("(M) BOEING B767-300", 5300, PlaneCategory.WIDE_BODY));
        listPlanes.add(new PlaneModel("(M) BOEING B777-200ER", 6800, PlaneCategory.WIDE_BODY));
        listPlanes.add(new PlaneModel("BOEING B777-200LR", 6400, PlaneCategory.WIDE_BODY));
        listPlanes.add(new PlaneModel("BOEING B777-300ER", 6600, PlaneCategory.WIDE_BODY));
        listPlanes.add(new PlaneModel("(M) BOEING B787-8", 4800, PlaneCategory.WIDE_BODY));
        listPlanes.add(new PlaneModel("(M) BOEING B787-9", 4350, PlaneCategory.WIDE_BODY));
        listPlanes.add(new PlaneModel("(M) BOEING B787-10", 5650, PlaneCategory.WIDE_BODY));
        listPlanes.add(new PlaneModel("Bombardier CRJ900", 1200, PlaneCategory.REGIONAL));
        listPlanes.add(new PlaneModel("McDonnell Douglas MD-11", 5300, PlaneCategory.WIDE_BODY));
        listPlanes.add(new PlaneModel("(M) McDonnell Douglas MD-81", 2650, PlaneCategory.NARROW_BODY));
        listPlanes.add(new PlaneModel("Saab 34", 420, PlaneCategory.REGIONAL));
        listPlanes.add(new PlaneModel("(M) Tupolev 154M", 3000, PlaneCategory.NARROW_BODY));
        listPlanes.add(new PlaneModel("(A) Douglas DC-8 61", 0, PlaneCategory.WIDE_BODY));
        listPlanes.add(new PlaneModel("(A) Boeing F/A-18E Super Hornet", 0, PlaneCategory.NARROW_BODY));
        listPlanes.add(new PlaneModel("(A) Aerospatiale/BAC Concorde", 0, PlaneCategory.SPECIAL));
        listPlanes.add(new PlaneModel("(A) DHC-6 Twin Otter 300", 0, PlaneCategory.REGIONAL));
    }

    public PlaneFuelController() {
        scan = new Scanner(System.in);
        listPlanes = new ArrayList<>();
        planeDatabase();
    }

    public void planeSelector() {
        isValid = false;
        int menuSelector = -1;
        int flightTime = 0;
        while (!isValid) {
            try {
                // Selecting the planes
                System.out.println("Plane types: ");
                showAllPlanes();
                System.out.print("Select: ");
                menuSelector = scan.nextInt() - 1;
                scan.nextLine();
                if (menuSelector >= listPlanes.size() || menuSelector < 0) {
                    System.out.println("Input must from 0 - " + listPlanes.size());
                    continue;
                }
                PlaneModel planeSelected = listPlanes.get(menuSelector);

                // Inputting duration of flight
                System.out.print("Flight time (in formal HHMM): ");
                flightTime = scan.nextInt();
                scan.nextLine();
                int hours = flightTime / 100;
                int minutes = flightTime % 100;
                double flightTimeDecimal = hours + minutes / 60.0;
                if (hours < 1 || minutes < 0 || minutes > 59) {
                    System.out.println("Invalid time");
                    continue;
                }
                calculateFuel(flightTimeDecimal, planeSelected.getFuelBurn(), planeSelected.getPlaneType(),
                        planeSelected.getCategory());
            } catch (Exception e) {
                System.out.println("Wrong input");
                scan.nextLine();
            }
        }
    }

    public void calculateFuel(double flightTimeDecimal, double fuelBurn, String planeType,
            PlaneCategory planeCategory) {
        double climbFactor = 1;
        double windFactor = 1;
        double routeBuffer = 1;
        double hourOfFlight = flightTimeDecimal;
        double climbHours = planeCategory.getClimbHours();
        double cruiseHours = hourOfFlight - climbHours;
        double baselineFuel = fuelBurn * flightTimeDecimal;

        switch (planeCategory) {
            case GENERAL_AVIATION:
                // Small piston/turboprop GA — short hops, low altitude, minimal wind routing
                // complexity
                if (hourOfFlight <= 1.0) {
                    climbFactor = 1.10;
                    windFactor = 1.00;
                    routeBuffer = 1.00;
                } else {
                    climbFactor = 1.06;
                    windFactor = 1.02;
                    routeBuffer = 1.01;
                }
                break;

            case HEAVY_CARGO:
                // Heavier gross weight than WIDE_BODY at similar range — slightly worse
                // climb/cruise efficiency
                if (hourOfFlight <= 3.0) {
                    climbFactor = 1.10;
                    windFactor = 1.02;
                    routeBuffer = 1.01;
                } else if (hourOfFlight <= 6.0) {
                    climbFactor = 1.07;
                    windFactor = 1.04;
                    routeBuffer = 1.02;
                } else if (hourOfFlight <= 18.0) {
                    climbFactor = 1.14;
                    windFactor = 1.08;
                    routeBuffer = 1.06;
                }
                break;

            case SPECIAL:
                // Supersonic (Concorde-style) — aggressive climb/accel to cruise altitude, but
                // stable supercruise above weather
                if (hourOfFlight <= 2.0) {
                    climbFactor = 1.15;
                    windFactor = 1.00;
                    routeBuffer = 1.00;
                } else {
                    climbFactor = 1.12;
                    windFactor = 1.01;
                    routeBuffer = 1.01;
                }
                break;

            case WIDE_BODY:
                if (hourOfFlight <= 3.0) {
                    climbFactor = 1.08;
                    windFactor = 1.01;
                    routeBuffer = 1.00;
                } else if (hourOfFlight <= 6.0) {
                    climbFactor = 1.05;
                    windFactor = 1.03;
                    routeBuffer = 1.01;
                } else if (hourOfFlight <= 16.0) {
                    climbFactor = 1.12;
                    windFactor = 1.07;
                    routeBuffer = 1.05;
                }
                break;

            case NARROW_BODY:
                if (hourOfFlight <= 2.5) {
                    climbFactor = 1.04;
                    windFactor = 1.00;
                    routeBuffer = 1.00;
                } else if (hourOfFlight <= 5.0) {
                    climbFactor = 1.03;
                    windFactor = 1.02;
                    routeBuffer = 1.02;
                } else {
                    climbFactor = 1.04;
                    windFactor = 1.04;
                    routeBuffer = 1.02;
                }
                break;

            case REGIONAL:
                if (hourOfFlight <= 1.5) {
                    climbFactor = 1.06;
                    windFactor = 1.00;
                    routeBuffer = 1.00;
                } else {
                    climbFactor = 1.04;
                    windFactor = 1.02;
                    routeBuffer = 1.01;
                }
                break;
        }

        double climbFuel = fuelBurn * climbHours * climbFactor;
        double combinedFactor = windFactor + routeBuffer - 1.0;
        double cruiseFuel = fuelBurn * cruiseHours * combinedFactor;
        double tripFuel = climbFuel + cruiseFuel;
        double contingencyFuel = tripFuel * 0.05;
        double alternateFuel = fuelBurn * 0.75;
        double finalReserve = fuelBurn * 0.50;
        double reserveFuel = alternateFuel + finalReserve;
        double taxiFuel = planeCategory.getTaxiFuel();
        double totalFuel = Math.round(tripFuel + contingencyFuel + reserveFuel + taxiFuel);
        int fuelRounding = (int) Math.round(totalFuel / 100.0) * 100;

        System.out.println("\nPLANNED FUEL");
        System.err.println("---------------------------------\r");
        System.out.println("Trip Fuel: " + Math.round(tripFuel) + "kg | Baseline: " + Math.round(baselineFuel));
        System.out.println("Climb Fuel: " + Math.round(climbFuel) + "kg");
        System.out.println("Contingency Fuel: " + Math.round(contingencyFuel) + "kg");
        System.out.println("Reserve Fuel: " + reserveFuel + "kg");
        System.out.println("Taxi Fuel: " + taxiFuel + "kg");
        System.out.println("Total fuel of " + planeType + " is: " + (fuelRounding) + "kg\n");
        System.err.println("Note that this calculation is for a specified flight simulator (RFS) purpose only\r\n");
        System.err.println("---------------------------------\r\n");
    }

    public void showAllPlanes() {
        for (int i = 0; i < listPlanes.size(); i++) {
            PlaneModel showPlane = listPlanes.get(i);
            System.out.println((i + 1) + ". " + showPlane.getPlaneType());
        }
    }
}
