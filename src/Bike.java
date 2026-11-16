/**
 * Bike.
 *
 * @author Yahali Mashiach
 * ID: 214007346
 */
public class Bike extends Vehicle {
    /**
     * attributes.
     */
    private static final int BIKE_SIZE = 1;

    /**
     * Construct a Bike with the given license plate.
     *
     * @param licensePlate license plate string
     */
    public Bike(String licensePlate) {
        super(BIKE_SIZE, licensePlate);
    }

    /**
     * Return the vehicle size.
     *
     * @return vehicle size
     */
    @Override
    public int getSize() {
        return BIKE_SIZE;
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
