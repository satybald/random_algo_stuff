/*************************************************************************
 * Name:
 * Email:
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new Comparator<>(){
        @Override
        public int compare(Object v, Object w) {
            Point pv = (Point) v;
            Point pw = (Point) w;
            double slopeV = Point.this.slopeTo(pv);
            double slopeW = Point.this.slopeTo(pw);
            if (slopeV < slopeW)
                return -1;
            else if (slopeV > slopeW)
                return 1;
            else
                return 0;
        }
    }

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        if (compareTo(that) == 0)
            return Double.NEGATIVE_INFINITY;
        else if (this.y == that.y)
            return +0;
        else if (this.x == that.x)
            return Double.POSITIVE_INFINITY;
        else
            return new Double(that.y - this.y)
            / new Double(that.x - this.x);
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        if (that == null) throw new NullPointerException();
        if ((this.y > that.y) || (this.y == that.y && this.x > that.x)) return 1;
        else if (this.y < that.y) return -1;
        else return 0;
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
}