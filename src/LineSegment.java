/**
 * LineSegment.
 *
 * @author Yahali Mashiach
 * ID: 214007346
 *  * © [YYYY]
 */
public class LineSegment {
    // attributes
    private Point p1;
    private Point p2;

    private static Point copyOf(Point point) {
        return new Point(point.getX(), point.getY());
    }

    /**
     * Construct a LineSegment with ends `p1` and `p2`.
     *
     * @param p1 first point
     * @param p2 second point
     */
    public LineSegment(Point p1, Point p2) {
        this.p1 = copyOf(p1);
        this.p2 = copyOf(p2);
    }

    /**
     * Getter for first point.
     *
     * @return point p1
     */
    public Point getP1() {
        return copyOf(this.p1);
    }

    /**
     * Getter for second point.
     *
     * @return point p2
     */
    public Point getP2() {
        return copyOf(this.p2);
    }

    /**
     * Setter for point p1.
     *
     * @param p1 first point
     */
    public void setP1(Point p1) {
        this.p1 = copyOf(p1);
    }

    /**
     * Setter for point p2.
     *
     * @param p2 second point
     */
    public void setP2(Point p2) {
        this.p2 = copyOf(p2);
    }

    /**
     * Length of `this` line segment.
     *
     * @return length
     */
    public double length() {
        return this.p1.distance(this.p2);
    }

    /**
     * Middle point of `this` line segment.
     *
     * @return middle
     */
    public Point middle() {
        double middleX = (this.p1.getX() + this.p2.getX()) / 2;
        double middleY = (this.p1.getY() + this.p2.getY()) / 2;

        return new Point(middleX, middleY);
    }

    /**
     * Determine whether `this` has the same end-points as `other`.
     *
     * @param other line segment to compare against
     * @return `true` if line segments have the same end-points, `false` otherwise
     */
    public boolean isEqual(LineSegment other) {
        return (other.getP1().isEqual(this.p1) && other.getP2().isEqual(this.p2))
        || (other.getP1().isEqual(this.p2) && other.getP2().isEqual(this.p1));
    }

    /**
     * Determine whether point `p` belongs to `this` line segment.
     *
     * @param p point to check
     * @return `true` if `p` belongs to `this`, `false` otherwise
     */
    public boolean contains(Point p) {
        return p.belongsTo(this);
    }
}
