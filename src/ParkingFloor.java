import java.util.ArrayList;
import java.util.Collection;

/**
 * ParkingFloor.
 *
 * @author Yahali Mashiach
 * ID: 214007346
 */
public class ParkingFloor {
    /**
     * attributes.
     */
    private int floorNumber;
    private ArrayList<ParkingSpot> spots;

    /**
     * Construct a ParkingFloor with the given floor number.
     * A newly created floor has no parking spots.
     *
     * @param floorNumber floor number
     */
    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.spots = new ArrayList<>();
    }

    /**
     * Return the floor number.
     *
     * @return floor number
     */
    public int getFloorNumber() {
        return this.floorNumber;
    }

    /**
     * Return the collection of parking spots on this floor.
     *
     * @return collection of parking spots
     */
    public Collection<ParkingSpot> getSpots() {
        return this.spots;
    }

    /**
     * Add a parking spot to this floor.
     *
     * @param spot parking spot to add
     */
    public void addSpot(ParkingSpot spot) {
        this.spots.add(spot);
    }
}
