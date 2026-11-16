/**
 * Car.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public class Car extends Vehicle {
    private static final int CAR_SIZE = 2;

    /**
     * Construct a Car.
     *
     * @param licensePlate license plate string
     */
    public Car(String licensePlate) {
        super(CAR_SIZE, licensePlate);
    }

    /**
     * Return the vehicle size.
     *
     * @return vehicle size
     */
    @Override
    public int getSize() {
        return CAR_SIZE;
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
