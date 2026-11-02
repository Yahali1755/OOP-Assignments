/**
 * DirectedLineSegment.
 *
 * @author Yahali Mashiach
 * ID: 214007346
 */
public class DirectedLineSegment {
    // attributes
    private LineSegment lineSegment;


    /**
     * return a copy of a point.
     *
     * @param point point to copy
     * @return copy of the same point
     */
    private static Point copyOf(Point point) {
        return new Point(point.getX(), point.getY());
    }

    /**
     * Constructor.
     *
     * @param start start point
     * @param end end point
     */
    public DirectedLineSegment(Point start, Point end) {
        this.lineSegment = new LineSegment(copyOf(start), copyOf(end));
    }

    /**
     * Getter for start point.
     *
     * @return start point
     */
    public Point getStart() {
        return copyOf(this.lineSegment.getP1());
    }

    /**
     * Getter for end point.
     *
     * @return end point
     */
    public Point getEnd() {
        return copyOf(this.lineSegment.getP2());
    }

    /**
     * Setter for start point.
     *
     * @param start start point
     *
     */
    public void setStart(Point start) {
        this.lineSegment.setP1(copyOf(start));
    }

    /**
     * Setter for end point.
     *
     * @param end end point
     */
    public void setEnd(Point end) {
        this.lineSegment.setP2(copyOf(end));
    }

    /**
     * Length of `this` line segment.
     *
     * @return length
     */
    public double length() {
        return this.lineSegment.length();
    }

    /**
     * Middle point of `this` line segment.
     *
     * @return middle
     */
    public Point middle() {
        return this.lineSegment.middle();
    }

    /**
     * Determine whether `this` has the same start-end-points as `other`.
     *
     * @param other directed line segment to compare against
     * @return `true` if line segments have the same start-end-points, `false` otherwise
     */
    public boolean isEqual(DirectedLineSegment other) {
        return DoubleUtils.isEqual(this.lineSegment.getP1().getX(), other.lineSegment.getP1().getX())
            && DoubleUtils.isEqual(this.lineSegment.getP1().getY(), other.lineSegment.getP1().getY())
            && DoubleUtils.isEqual(this.lineSegment.getP2().getX(), other.lineSegment.getP2().getX())
            && DoubleUtils.isEqual(this.lineSegment.getP2().getY(), other.lineSegment.getP2().getY());
    }

    /**
     * Return the inverse of `this`, e.g. swap `start` and `end`.
     *
     * @return return new directed line segment with swapped start and end points
     */
    public DirectedLineSegment inverse() {
        return new DirectedLineSegment(this.getEnd(), this.getStart());
    }

    /**
     * Return the line segment of `this`, direction does not matter.
     *
     * @return line segment
     */
    public LineSegment toLineSegment() {
        return new LineSegment(this.getStart(), this.getEnd());
    }
}
