/**
 * DoubleUtils.
 *
 * @author Yahali Mashiach
 * ID: 214007346
 * © [YYYY]
 */
public final class DoubleUtils {
    private static final double EPSILON = 1e-6;

    private DoubleUtils() { }

    /**
     * Compares two doubles within a margin.
     *
     * @param a the first value
     * @param b the second value
     * @return if values are equal within a margin
     */
    public static boolean isEqual(double a, double b) {
        return Math.abs(a - b) < EPSILON;
    }

    /**
     * Checks if 'a' is greater than or equal to 'b' within a margin.
     *
     * @param a the first value
     * @param b the second value to compare against
     * @return true if a is greater than or equal to b, false otherwise
     */
    public static boolean isGreaterOrEqual(double a, double b) {
        return a > b || DoubleUtils.isEqual(a, b);
    }

    /**
     * Checks if 'a' is less than or equal to 'b' within a margin.
     *
     * @param a the first value
     * @param b the second value to compare against
     * @return true if a is less than or equal to b, false otherwise
     */
    public static boolean isLessOrEqual(double a, double b) {
        return a < b || DoubleUtils.isEqual(a, b);
    }
}