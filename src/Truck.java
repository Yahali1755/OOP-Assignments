/**
 * Truck.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public class Truck extends Vehicle {
    private static final int TRUCK_SIZE = 3;

    /**
     * Construct a Truck with the given license plate.
     *
     * @param licensePlate license plate
     */
    public Truck(String licensePlate) {
        super(TRUCK_SIZE, licensePlate);
    }

    /**
     * Return the vehicle size.
     *
     * @return vehicle size
     */
    @Override
    public int getSize() {
        return TRUCK_SIZE;
    }

    /**
     * Return the license plate string.
     *
     * @return license plate
     */
    @Override
    public String getLicensePlate() {
        return super.licensePlate;
    }
}
