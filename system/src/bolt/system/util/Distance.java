package bolt.system.util;

import bolt.system.entities.coordinates.Coordinates;

public class Distance {

    private Coordinates p1;
    private Coordinates p2;
    public Distance(Coordinates p1, Coordinates p2){
        this.p1 = p1;
        this.p2 = p2;


    }

    public double getDistanceBetweenPoints(){
        return Math.pow(Math.pow((p1.getX() - p2.getX()),2) + Math.pow(p1.getY() - p2.getY(),2),0.5);
    }




}
