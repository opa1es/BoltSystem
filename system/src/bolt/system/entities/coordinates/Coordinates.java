package bolt.system.entities.coordinates;


/**
 * @invariants: x, y
 */

public class Coordinates {

    private double x;
    private double y;

    /*@ public normal_behavior
    @ ensures x == x;
    @ ensures y == y;
    @*/
    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    //@ ensures x == x;
    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }
    // @ ensures y == y;
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
