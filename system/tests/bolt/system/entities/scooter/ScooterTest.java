package bolt.system.entities.scooter;

import bolt.system.entities.coordinates.Coordinates;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScooterTest {

    @Test
    void testToString() {

        ScooterStatus activeStatus = ScooterStatus.FREE;
        ScooterStatus brokenStatus = ScooterStatus.BROKEN;

        Scooter scooter1 = new Scooter((short) 100, new Coordinates(100, 200), activeStatus);
        Scooter scooter2 = new Scooter((short) 100, new Coordinates(200, 200), brokenStatus);

        String true_string1 = "Scooter{scooterId=0, chargeLevel=100, coordinates=Coordinates{x=100.0, y=200.0}, currentStatus=FREE}";
        String true_string2 = "Scooter{scooterId=0, chargeLevel=100, coordinates=Coordinates{x=200.0, y=200.0}, currentStatus=BROKEN}";


        if(!scooter1.toString().equals(true_string1)){
            fail();
        }
        if(!scooter2.toString().equals(true_string2)){
            fail();
        }


    }
}