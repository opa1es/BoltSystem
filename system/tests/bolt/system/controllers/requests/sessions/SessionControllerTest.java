package bolt.system.controllers.requests.sessions;

import bolt.system.database.storage.ScootersStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SessionControllerTest {


    static SessionController sessionController;

    @BeforeEach
    void refreshStorage() {
        sessionController = new SessionController();
    }


    @Test
    void addNewSession() {
        ScooterActiveSessionData scooterSessionData1 = new ScooterActiveSessionData(1, 2);
        ScooterActiveSessionData scooterSessionData2 = new ScooterActiveSessionData(2, 3);

        sessionController.addNewSession(scooterSessionData1);


        if (!sessionController.getScooterActiveSessionDataStorage().contains(scooterSessionData1)) {
            fail();
        }

        sessionController.addNewSession(scooterSessionData2);
        if (sessionController.getSessionByUserId(scooterSessionData2.getUserId()).getScooterId() != scooterSessionData2.getScooterId()) {
            fail();
        }


    }

    @Test
    void checkIfSessionIsActive() {

        ScooterActiveSessionData scooterSessionData1 = new ScooterActiveSessionData(1, 2);


        sessionController.addNewSession(scooterSessionData1);

        if (!sessionController.checkIfSessionIsActive(scooterSessionData1)) {
            fail();
        }

        sessionController.closeSessionByScooterId(2);

        if (sessionController.checkIfSessionIsActive(scooterSessionData1)) {
            fail();
        }

    }

    @Test
    void closeSessionByUserId() {

        ScooterActiveSessionData scooterSessionData1 = new ScooterActiveSessionData(1, 2);
        ScooterActiveSessionData scooterSessionData2 = new ScooterActiveSessionData(2, 3);

        sessionController.addNewSession(scooterSessionData1);
        sessionController.addNewSession(scooterSessionData2);


        if (!sessionController.checkIfSessionIsActive(scooterSessionData1)) {
            fail();
        }

        if (!sessionController.checkIfSessionIsActive(scooterSessionData2)) {
            fail();
        }
        sessionController.closeSessionByUserId(1);
        sessionController.closeSessionByUserId(2);

        if (sessionController.checkIfSessionIsActive(scooterSessionData1)) {
            fail();
        }

        if (sessionController.checkIfSessionIsActive(scooterSessionData2)) {
            fail();
        }

    }

    @Test
    void closeSessionByScooterId() {

        ScooterActiveSessionData scooterSessionData1 = new ScooterActiveSessionData(1, 2);
        ScooterActiveSessionData scooterSessionData2 = new ScooterActiveSessionData(2, 3);

        sessionController.addNewSession(scooterSessionData1);
        sessionController.addNewSession(scooterSessionData2);


        if (!sessionController.checkIfSessionIsActive(scooterSessionData1)) {
            fail();
        }

        if (!sessionController.checkIfSessionIsActive(scooterSessionData2)) {
            fail();
        }
        sessionController.closeSessionByScooterId(2);
        sessionController.closeSessionByScooterId(3);

        if (sessionController.checkIfSessionIsActive(scooterSessionData1)) {
            fail();
        }

        if (sessionController.checkIfSessionIsActive(scooterSessionData2)) {
            fail();
        }


    }

    @Test
    void getSessionByUserId() {

        ScooterActiveSessionData scooterSessionData1 = new ScooterActiveSessionData(1, 2);
        ScooterActiveSessionData scooterSessionData2 = new ScooterActiveSessionData(2, 3);

        sessionController.addNewSession(scooterSessionData1);
        sessionController.addNewSession(scooterSessionData2);


        if (!sessionController.checkIfSessionIsActive(scooterSessionData1)) {
            fail();
        }

        if (!sessionController.checkIfSessionIsActive(scooterSessionData2)) {
            fail();
        }
        sessionController.closeSessionByScooterId(2);
        sessionController.closeSessionByScooterId(3);

        if (sessionController.checkIfSessionIsActive(scooterSessionData1)) {
            fail();
        }

        if (sessionController.checkIfSessionIsActive(scooterSessionData2)) {
            fail();
        }


    }

}