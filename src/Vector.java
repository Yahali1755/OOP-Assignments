/**
 * Vector.
 *
 * @author Yahali Mashiach
 * ID: 214007346
 */
public class Vector {
    /** attributes. */
    private double x;
    private double y;

    /**
     * Constructor.
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Create a vector from the origin to the supplied endpoint.
     * Changes to the endpoint and this vector must not affect each other.
     *
     * @param end non-null endpoint; its coordinates are the vector components
     */
    public Vector(Point end) {
        this.x = end.getX();
        this.y = end.getY();
    }

    /**
     * Create a vector with components end minus start.
     * Changes to the supplied points and this vector must not affect each other.
     *
     * @param start non-null start point
     * @param end non-null end point
     */
    public Vector(Point start, Point end) {
        this.y = end.getY() - start.getY();
        this.x = end.getX() - start.getX();
    }

    /**
     * Create a vector with the displacement from a segment's start to its end.
     * Changes to the supplied segment and this vector must not affect each other.
     *
     * @param line non-null directed line segment
     */
    public Vector(DirectedLineSegment line) {
        this.x = line.getEnd().getX() - line.getStart().getX();
        this.y = line.getEnd().getY() - line.getStart().getY();
    }

    /**
     * Return the `x` coordinate of this vector.
     *
     * @return coordinate x
     */
    public double getX() {
        return this.x;
    }

    /**
     * Return the `y` coordinate of this vector.
     *
     * @return coordinate y
     */
    public double getY() {
        return this.y;
    }

    /**
     * Return the length of this vector.
     *
     * @return length
     */
    public double getLength() {
        return Math.hypot(this.x, this.y);
    }

    /**
     * Return the direction of this vector represented as a signed angle
     * in radians(not degrees) between this vector and positive axis X.
     *
     * @return direction
     */
    public double getDirection() {
        return Math.atan2(this.y, this.x);
    }

    /**
     * Assign the `x` coordinate of this vector.
     *
     * @param x coordinate x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Assign the `y` coordinate of this vector.
     *
     * @param y coordinate y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Assign the length of this vector, don't forget to preserve the direction.
     *
     * @param length length
     */
    public void setLength(double length) {
        double currentLength = this.getLength();

        // if original length is 0, length can't be set, so no change
        if (currentLength != 0) {
            this.x = (length * this.x) / currentLength;
            this.y = (length * this.y) / currentLength;
        }
    }

    /**
     * Assign the direction of this vector, don't forget to preserve the length.
     *
     * @param direction direction (angle in radians)
     */
    public void setDirection(double direction) {
        double length = this.getLength();

        // if length is 0, the direction is undefined, so no change
        if (length != 0) {
            // cos(direction) is the x-coordinate of  vector in the direction of the angle in radians
            this.x = length * Math.cos(direction);
            // sin(direction) is the y-coordinate of  vector in the direction of the angle in radians
            this.y = length * Math.sin(direction);
        }
    }

    /**
     * Return the coordinates representation of this vector.
     *
     * @return point
     */
    public Point coordinates() {
        return new Point(this.x, this.y);
    }

    /**
     * Return `true` if `this` represents the same equivalence class as `other`.
     *
     * @param other vector to compare against
     * @return `true` if `this` and `other` are the same vector mathematically, `false` otherwise.
     */
    public boolean isEqual(Vector other) {
        return DoubleUtils.isEqual(this.x, other.getX())
            && DoubleUtils.isEqual(this.y, other.getY());
    }

    /**
     * Return the vector sum of `this` and `other`.
     *
     * @param other vector to add
     * @return vector sum
     */
    public Vector add(Vector other) {
        return new Vector(this.x + other.x, this.y + other.y);
    }

    /**
     * Return the vector sum of `first` and `second`.
     *
     * @param first first vector
     * @param second second vector
     * @return vector sum
     */
    public static Vector sum(Vector first, Vector second) {
        return new Vector(first.x + second.x, first.y + second.y);
    }

    /**
     * Return the scaled version of `this`, e.g. multiply `this` by `scalar`.
     *
     * @param scalar scalar to multiply by
     * @return scaled vector
     */
    public Vector scale(double scalar) {
        return new Vector(this.x * scalar, this.y * scalar);
    }

    /**
     * Return the cross product between `this` and `other`.
     * Note that order is important, `this` X `other` is not the same as `other` X `this`.
     *
     * @param other second vector
     * @return cross product `this` X `other`
     */
    public double crossProduct(Vector other) {
        return this.x * other.y - this.y * other.x;
    }

    /**
     * Return the dot product between `this` and `other`.
     *
     * @param other second vector
     * @return dot product `this` . `other`
     */
    public double dotProduct(Vector other) {
        return this.x * other.x + this.y * other.y;
    }
}
