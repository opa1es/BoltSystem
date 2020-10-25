package bolt.system.entities.coordinates;

import bolt.system.entities.scooter.Scooter;
import bolt.system.entities.scooter.ScooterStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    @Test
    void testToString() {


        ScooterStatus activeStatus = ScooterStatus.FREE;
        ScooterStatus brokenStatus = ScooterStatus.BROKEN;

        Coordinates coord1 = new Coordinates(1034, 200);
        Coordinates coord2 = new Coordinates(20, 5006);

        String true_string1 = "Coordinates{x=1034.0, y=200.0}";
        String true_string2 = "Coordinates{x=20.0, y=5006.0}";


        if (!coord1.toString().equals(true_string1)) {
            fail();
        }
        if (!coord2.toString().equals(true_string2)) {
            fail();
        }

    }
}