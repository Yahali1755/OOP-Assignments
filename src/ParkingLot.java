import java.util.Collection;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * ParkingLot.
 *
 * @author Yahali Mashiach
 * ID: 214007346
 */
public class ParkingLot {
        /**
     * attributes.
     */
    public static final int HOURLY_RATE = 10;
    private Collection<ParkingFloor> floors;
    private Collection<ParkingSpot> activeRecords;

    /**
     * Default constructor. Initializes an empty lot.
     */
    public ParkingLot() {
        this.floors = new ArrayList<>();
        this.activeRecords = new LinkedList<>();
    }

    /**
     * Return the collection of floors in the parking lot.
     *
     * @return collection of floors
     */
    public Collection<ParkingFloor> getFloors() {
        return this.floors;
    }

    /**
     * Add a floor to the parking lot.
     *
     * @param floor floor to add
     */
    public void addFloor(ParkingFloor floor) {
        this.floors.add(floor);
    }

    /**
     * Attempt to park the provided vehicle in the parking lot.
     *
     * @param v vehicle to park
     * @return `true` if successful, `false` otherwise
     */
    public boolean parkVehicle(Vehicle v) {
        ParkingSpot bestSpot = null;

        for (ParkingFloor floor : this.floors) {
            for (ParkingSpot spot : floor.getSpots()) {
                // Check if spot is empty and vehicle fits
                if (!spot.isOccupied() && v.getSize() <= spot.getMaxVehicleSize()) {
                    boolean isBetterSpot = bestSpot == null || spot.getMaxVehicleSize() < bestSpot.getMaxVehicleSize();

                    if (isBetterSpot) {
                        bestSpot = spot;
                    }
                }
            }
        }

        // If a valid spot was found, park the vehicle
        if (bestSpot != null) {
            bestSpot.setOccupied(true);

            // Park the vehicle
            bestSpot.setParkedVehicle(v);
            // Add to active records linked list
            this.activeRecords.add(bestSpot);

            return true;
        }

        // return false if no suitable spot was found on this floor
        return false;
    }

    /**
     * Unpark the vehicle associated with the given license plate.
     * Return the calculated parking fee, or `-1` if not found.
     *
     * @param licensePlate   license plate of the vehicle to unpark
     * @param durationInMinutes duration the vehicle was parked
     * @return parking fee, or `-1` if not found
     */
    public int unparkVehicle(String licensePlate, int durationInMinutes) {
        for (ParkingSpot spot : this.activeRecords) {
            if (spot.getParkedVehicle() != null && spot.getParkedVehicle().getLicensePlate().equals(licensePlate)) {
                // Free spot
                spot.setOccupied(false);
                spot.setParkedVehicle(null);
                // Remove from active records
                this.activeRecords.remove(spot);

                // Free parking for the first 15 minutes
                if (durationInMinutes <= 15) {
                    return 0;
                }

                // Get the full hours
                int hours = durationInMinutes / 60;

                // If there are any leftover minutes, round up to the next hour
                if (durationInMinutes % 60 > 0) {
                    hours++;
                }

                // Calculate and return the parking fee (loop exits instantly)
                return hours * HOURLY_RATE;
            }
        }

        // Return -1 if vehicle with the given license plate is not found
        return -1;
    }

    /**
     * Print all currently active parking records.
     */
    public void displayParkingRecords() {
        for (ParkingSpot spot : this.activeRecords) {
            Vehicle v = spot.getParkedVehicle();

            System.out.println(spot.getSpotId() + " : " + v.getLicensePlate());
        }
    }
}
