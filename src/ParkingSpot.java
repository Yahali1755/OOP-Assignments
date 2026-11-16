/**
 * ParkingSpot.
 *
 * @author Yahali Mashiach
 * ID: 214007346
 */
public class ParkingSpot {
    /**
     * attributes.
     */
    private int maxVehicleSize;
    private int spotId;
    private boolean occupied;
    private Vehicle parkedVehicle;

    /**
     * Construct a ParkingSpot with the given max vehicle size and spot ID.
     * A newly created spot is unoccupied by default.
     *
     * @param maxVehicleSize max vehicle size this spot can hold
     * @param spotId         spot ID
     */
    public ParkingSpot(int maxVehicleSize, int spotId) {
        this.maxVehicleSize = maxVehicleSize;
        this.spotId = spotId;
        this.occupied = false;
        this.parkedVehicle = null;
    }

    /**
     * Return the max vehicle size this spot can hold.
     *
     * @return max vehicle size
     */
    public int getMaxVehicleSize() {
        return this.maxVehicleSize;
    }

    /**
     * Return the vehicle parked in this spot, or null if empty.
     *
     * @return get parked vehicle object
     */
    public Vehicle getParkedVehicle() {
        return this.parkedVehicle;
    }

    /**
     * Set the vehicle as parked for the current spot.
     *
     * @param vehicle vehicle to park
     */
    public void setParkedVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
    }

    /**
     * Return the spot ID.
     *
     * @return spot ID
     */
    public int getSpotId() {
        return this.spotId;
    }

    /**
     * Return `true` if the spot is currently occupied.
     *
     * @return `true` if occupied, `false` otherwise
     */
    public boolean isOccupied() {
        return this.occupied;
    }

    /**
     * Set the occupied status of this spot.
     *
     * @param occupied occupied status
     */
    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
