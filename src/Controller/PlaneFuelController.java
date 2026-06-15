package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Model.PlaneModel;

public class PlaneFuelController {
    private ArrayList<PlaneModel> listPlanes;
    private Scanner scan;
    private boolean isValid;

    public PlaneFuelController() {
        scan = new Scanner(System.in);
        listPlanes = new ArrayList<>();
        // 8200
        listPlanes.add(new PlaneModel("B77W", 7500, false));
        listPlanes.add(new PlaneModel("B77L", 6800, false));
        listPlanes.add(new PlaneModel("B788", 4900, false));
        listPlanes.add(new PlaneModel("B789", 5600, false));
        listPlanes.add(new PlaneModel("B742", 11500, false));
        listPlanes.add(new PlaneModel("B744", 10800, false));
        listPlanes.add(new PlaneModel("B748", 9600 , false));
        listPlanes.add(new PlaneModel("B744(F)", 10900, false));
        listPlanes.add(new PlaneModel("A359", 5450, false));
        listPlanes.add(new PlaneModel("A35K", 6300, false));
        listPlanes.add(new PlaneModel("A313", 4500, false));
        listPlanes.add(new PlaneModel("B752", 3400, false));
        listPlanes.add(new PlaneModel("B38M", 2200, true));
        listPlanes.add(new PlaneModel("B38M", 2500, true));
        listPlanes.add(new PlaneModel("A342", 6600, false));
        listPlanes.add(new PlaneModel("A346", 8200, false));
        listPlanes.add(new PlaneModel("A21N", 2400, true));
        listPlanes.add(new PlaneModel("B772", 6800, false));
        listPlanes.add(new PlaneModel("A339", 5400, false));
        listPlanes.add(new PlaneModel("MD11", 7800, false));
        listPlanes.add(new PlaneModel("A332", 5800, false));
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
                        planeSelected.isNarrowBodies());
            } catch (Exception e) {
                System.out.println("Wrong input");
                scan.nextLine();
            }
        }
    }

    public void calculateFuel(double flightTimeDecimal, double fuelBurn, String planeType, boolean isNarrowBodies) {
        double climbFactor = 1;
        double windFactor = 1;
        double routeBuffer = 1;
        double hourOfFlight = flightTimeDecimal;
        double climbHours = isNarrowBodies ? (20.0/60.0) : (28.0 / 60.0);
        double cruiseHours = hourOfFlight - climbHours;
        double baselineFuel = fuelBurn * flightTimeDecimal;
        if (!isNarrowBodies) {
            if (hourOfFlight <= 3.0) {
                climbFactor = 1.08;
                windFactor = 1.01;
                routeBuffer = 1.00;
            } else if (hourOfFlight <= 6.0) {
                climbFactor = 1.05;
                windFactor = 1.03;
                routeBuffer = 1.01;
            } else if (hourOfFlight <= 16.0) {
                if (hourOfFlight < 7) {
                    climbFactor = 1.08;
                    windFactor = 1.04;
                    routeBuffer = 1.03;
                } else {
                    climbFactor = 1.10;
                    windFactor = 1.05;
                    routeBuffer = 1.03;
                }
            } else {
                climbFactor = 1.12;
                windFactor = 1.07;
                routeBuffer = 1.05;
            }
        } else {
            if (hourOfFlight <= 3.0) {
                climbFactor = 1.04;
                windFactor = 1.00;
                routeBuffer = 1.00;
            } else if (hourOfFlight <= 6.0) {
                climbFactor = 1.03;
                windFactor = 1.02;
                routeBuffer = 1.02;
            } else {
                climbFactor = 1.04;
                windFactor = 1.04;
                routeBuffer = 1.02;
            }
        }

        double climbFuel = fuelBurn * climbHours * climbFactor;
        double combinedFactor = 1.0 + (windFactor - 1.0) + (routeBuffer - 1.0);
        double cruiseFuel = fuelBurn * cruiseHours * combinedFactor;
        double tripFuel = (climbFuel + cruiseFuel);
        double contingencyFuel = baselineFuel * 0.05;
        double reserveFuel = fuelBurn * 0.60;
        double taxiFuel = isNarrowBodies ? 1000 : 2000;
        double totalFuel = Math.round(tripFuel + contingencyFuel + reserveFuel + taxiFuel);
        int fuelRounding = (int) Math.round(totalFuel / 100.0) * 100;

        System.out.println("\nPLANNED FUEL");
        System.err.println("---------------------------------\r");
        System.out.println("Trip Fuel: " + Math.round(tripFuel) + "kg | Baseline: " + Math.round(baselineFuel));
        System.out.println("Climb Fuel: " + Math.round(climbFuel) + "kg");
        System.out.println("Contingency Fuel: " + Math.round(contingencyFuel) + "kg");
        System.out.println("Reserve Fuel: " + reserveFuel + "kg");
        System.out.println("Taxi Fuel: " + taxiFuel + "kg");
        System.out.println("Total fuel of " + planeType + " is: " + (fuelRounding));
        System.err.println("---------------------------------\r\n");
    }

    public void showAllPlanes() {
        for (int i = 0; i < listPlanes.size(); i++) {
            PlaneModel showPlane = listPlanes.get(i);
            System.out.println((i + 1) + ". " + showPlane.getPlaneType());
        }
    }
}
