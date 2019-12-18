package bolt.system.util;

import bolt.system.entities.coordinates.Coordinates;
/**
 * @invariants: p1, p2
 */
public class Distance {

    private /*@ spec_public @*/Coordinates p1;
    private /*@ spec_public @*/Coordinates p2;

    //@ public invariant p1 != null;
    //@ public invariant p2 != null;
    
    
    /*@ public normal_behavior
    @ requires p1 != null;
    @ requires p2 != null; 
    @ ensures this.p1 == p1;
    @ ensures this.p2 == p2;
    @*/
    public Distance(Coordinates p1, Coordinates p2) {
        this.p1 = p1;
        this.p2 = p2;

    }
    // OPENJML BUG HERE: JUST DON'T TOUCH IT!
    public /*@ pure code_safe_math @*/ double getDistanceBetweenPoints() {
        return Math.pow(Math.pow((p1.getX() - p2.getX()), 2) + Math.pow(p1.getY() - p2.getY(), 2), 0.5);
    }


}
