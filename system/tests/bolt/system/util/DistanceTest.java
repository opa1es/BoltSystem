package bolt.system.util;

import bolt.system.entities.coordinates.Coordinates;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistanceTest {

    @Test
    void testGetDistanceBetweenPoints() {

        Coordinates c1 = new Coordinates(0, 0);
        Coordinates c2 = new Coordinates(10, 10);
        Coordinates c3 = new Coordinates(-10, -10);
        Coordinates c4 = new Coordinates(200, 200);


        double distanceUtil1 = new Distance(c1, c2).getDistanceBetweenPoints();
        double distanceUtil2 = new Distance(c1, c3).getDistanceBetweenPoints();
        double distanceUtil3 = new Distance(c1, c4).getDistanceBetweenPoints();
        double distanceUtil4 = new Distance(c2, c3).getDistanceBetweenPoints();

        if (distanceUtil1 != trueDistanceFunc(c1, c2)) {
            fail();
        }
        if (distanceUtil2 != trueDistanceFunc(c1, c3)) {
            fail();
        }
        if (distanceUtil3 != trueDistanceFunc(c1, c4)) {
            fail();
        }
        if (distanceUtil4 != trueDistanceFunc(c2, c3)) {
            fail();
        }


    }


    private double trueDistanceFunc(Coordinates c1, Coordinates c2) {
        return Math.pow(Math.pow((c1.getX() - c2.getX()), 2) + Math.pow(c1.getY() - c2.getY(), 2), 0.5);

    }

}