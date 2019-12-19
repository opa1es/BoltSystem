package bolt.system.entities.coordinates;


/**
 * @invariants: x, y
 */

public class Coordinates {

    private /*@ spec_public @*/ double x;
    private /*@ spec_public @*/ double y;

    /*@ public normal_behavior
    @ ensures x == x;
    @ ensures y == y;
    @*/
    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //@ ensures this.x == \result;
    public double getX() {
        return x;
    }

    //@ assignable this.x;
    //@ ensures this.x == x;
    public void setX(double x) {
        this.x = x;
    }

    //@ ensures this.y == \result;
    public double getY() {
        return y;
    }

    //@ assignable this.y;
    //@ ensures this.y ==y;
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
