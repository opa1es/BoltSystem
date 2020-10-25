package bolt.system.controllers.requests.sessions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScooterActiveSessionDataTest {

    @Test
    void testToString() {

        ScooterActiveSessionData scooterSessionData = new ScooterActiveSessionData(1,2);

        scooterSessionData.setSessionId(0);

        String trueString = "ScooterActiveSessionData{sessionId=0, userId=1, scooterId=2}";
        if(!trueString.equals(scooterSessionData.toString())){
            fail();
        }
    }
}