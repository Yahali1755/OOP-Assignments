/**
 * Point.
 *
 * @author Yahali Mashiach
 * ID: 214007346
 * © [YYYY]
 */
public class Point {
    private double x;
    private double y;

    /**
     * Constructs a point with coordinates {(x, y)}.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter for coordinate x.
     *
     * @return coordinate x
     */
    public double getX() {
        return this.x;
    }

    /**
     * Getter for coordinate y.
     *
     * @return coordinate y
     */
    public double getY() {
        return this.y;
    }

    /**
     * Setter for coordinate x.
     *
     * @param x coordinate x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Setter for coordinate y.
     *
     * @param y coordinate y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Euclidean distance from `this` to `other`.
     *
     * @param other point to calculate distance from
     * @return distance
     */
    public double distance(Point other) {
        if (other == null) {
            return 0;
        }

        return Math.hypot(x - other.x, y - other.y);
    }

    /**
     * Determine whether `this` has the same coordinates as `other`.
     *
     * @param other point to compare against
     * @return `true` if points have the same coordinates, `false` otherwise
     */
    public boolean isEqual(Point other) {
        return DoubleUtils.isEqual(other.x, x) && DoubleUtils.isEqual(other.y, y);
    }

    /**
     * Determine whether `this` belongs to line segment `l`.
     *
     * @param l line segment to check
     * @return `true` if `this` belongs to `l`, `false` otherwise
     */
    public boolean belongsTo(LineSegment l) {
        if (l == null) {
            return false;
        }

        Point p1 = l.getP1();
        Point p2 = l.getP2();

        if (p1 == null || p2 == null) {
            return false;
        }

        double p1X = p1.getX();
        double p2X = p2.getX();
        double p1Y = p1.getY();
        double p2Y = p2.getY();

        // Edge case: if l is a vertical line ensure its y value is between the points the define l
        if (DoubleUtils.isEqual(p1X, p2X)) {
            return DoubleUtils.isEqual(this.x, p1X)
                    && DoubleUtils.isGreaterOrEqual(this.y, Math.min(p1Y, p2Y))
                    && DoubleUtils.isLessOrEqual(this.y, Math.max(p1Y, p2Y));
        }

            boolean isXInRange = DoubleUtils.isGreaterOrEqual(this.x, Math.min(p1X, p2X))
                && DoubleUtils.isLessOrEqual(this.x, Math.max(p1X, p2X));

        // Calculate the line equation y = mx + b for the segment
        double m = (p2Y - p1Y) / (p2X - p1X);
        double b = p1Y - m * p1X;

        // Check that this point's coordinates satisfy the line equation defintion y=mx+b
        boolean isYInRange = DoubleUtils.isEqual(this.y, (m * this.x) + b);

        return isXInRange && isYInRange;
    }
}
