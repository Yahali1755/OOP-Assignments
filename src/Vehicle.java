/**
 * Vehicle.
 *
 * @author Yahali Mashiach
 * ID: 214007346
 */
public abstract class Vehicle {
    /**
     * attributes.
     */
    protected String licensePlate;
    protected int size;

    /**
     * Construct a new vehicle.
     *
     * @param size vehicle size
     * @param licensePlate license plate string
     */
    public Vehicle(int size, String licensePlate) {
        this.size = size;
        this.licensePlate = licensePlate;
    }
    /**
     * Return the vehicle size.
     *
     * @return vehicle size
     */
    public abstract int getSize();

    /**
     * Return the license plate.
     *
     * @return license plate
     */
    public abstract String getLicensePlate();
}
