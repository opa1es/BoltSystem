package bolt.system.database.storage;

import bolt.system.entities.coordinates.Coordinates;
import bolt.system.entities.scooter.Scooter;
import bolt.system.entities.scooter.ScooterStatus;
import bolt.system.entities.user.BankAccountData;
import bolt.system.entities.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScootersStorageTest {

    static ScootersStorage scootersStorage;

    @BeforeEach
    void refreshStorage() {
        scootersStorage = new ScootersStorage();
    }


    @Test
    void addNewScooter() {

        ScooterStatus activeStatus = ScooterStatus.FREE;
        ScooterStatus brokenStatus = ScooterStatus.BROKEN;

        Scooter scooter1 = new Scooter((short) 100, new Coordinates(100, 200), activeStatus);
        Scooter scooter2 = new Scooter((short) 100, new Coordinates(200, 200), brokenStatus);


        scootersStorage.addNewScooter(scooter1);
        scootersStorage.addNewScooter(scooter1);
        if (scootersStorage.getAllScooters().size() != 1) {
            fail();
        }
        if (!scootersStorage.getAllScooters().contains(scooter1)) {
            fail();
        }

        scootersStorage.addNewScooter(scooter2);

        scootersStorage.addNewScooter(scooter1);
        scootersStorage.addNewScooter(scooter1);

        if (scootersStorage.getAllScooters().size() != 2) {
            fail();
        }
        if (!scootersStorage.getAllScooters().contains(scooter2) || !scootersStorage.getAllScooters().contains(scooter1)) {
            fail();
        }


    }

    @Test
    void getScooterById() {


        ScooterStatus activeStatus = ScooterStatus.FREE;
        ScooterStatus brokenStatus = ScooterStatus.BROKEN;

        Scooter scooter1 = new Scooter((short) 100, new Coordinates(100, 200), activeStatus);
        Scooter scooter2 = new Scooter((short) 100, new Coordinates(200, 200), brokenStatus);

        if (scootersStorage.getScooterById(0) != null) {
            fail();
        }
        if (scootersStorage.getScooterById(1) != null) {
            fail();
        }

        scootersStorage.addNewScooter(scooter1);
        scootersStorage.addNewScooter(scooter2);

        if (scootersStorage.getScooterById(0) != scooter1) {
            fail();
        }
        if (scootersStorage.getScooterById(1) != scooter2) {
            fail();
        }
    }

    @Test
    void deleteScooter() {


        ScooterStatus activeStatus = ScooterStatus.FREE;
        ScooterStatus brokenStatus = ScooterStatus.BROKEN;

        Scooter scooter1 = new Scooter((short) 100, new Coordinates(100, 200), activeStatus);
        Scooter scooter2 = new Scooter((short) 100, new Coordinates(200, 200), brokenStatus);

        scootersStorage.addNewScooter(scooter1);
        scootersStorage.addNewScooter(scooter2);

        scootersStorage.deleteScooter(scooter1.getScooterId());

        if (scootersStorage.getAllScooters().size() != 1) {
            fail();
        }

        scootersStorage.deleteScooter(scooter2.getScooterId());

        if (scootersStorage.getAllScooters().contains(scooter2) || scootersStorage.getAllScooters().contains(scooter1)) {
            fail();
        }

        if (scootersStorage.getAllScooters().size() != 0) {
            fail();
        }

    }

    @Test
    void getAllScooters() {


        ScooterStatus activeStatus = ScooterStatus.FREE;
        ScooterStatus brokenStatus = ScooterStatus.BROKEN;

        Scooter scooter1 = new Scooter((short) 100, new Coordinates(100, 200), activeStatus);
        Scooter scooter2 = new Scooter((short) 100, new Coordinates(200, 200), brokenStatus);


        scootersStorage.addNewScooter(scooter1);
        scootersStorage.addNewScooter(scooter2);

        if (!scootersStorage.getAllScooters().contains(scooter1) || !scootersStorage.getAllScooters().contains(scooter2)) {
            fail();
        }

        if (scootersStorage.getAllScooters().size() != 2) {
            fail();
        }

    }

    @Test
    void getAvailableScooters() {


        ScooterStatus activeStatus = ScooterStatus.FREE;
        ScooterStatus brokenStatus = ScooterStatus.BROKEN;

        Scooter scooter1 = new Scooter((short) 100, new Coordinates(100, 200), activeStatus);
        Scooter scooter2 = new Scooter((short) 100, new Coordinates(200, 200), brokenStatus);

        scootersStorage.addNewScooter(scooter1);
        scootersStorage.addNewScooter(scooter2);

        if (scootersStorage.getAvailableScooters().size() != 1) {
            fail();
        }

        scootersStorage.deleteScooter(0);
        System.out.println(scootersStorage.getAllScooters());
        if (scootersStorage.getAvailableScooters().size() != 0) {
            fail();
        }


    }

    @Test
    void changeScooterStatus() {


        ScooterStatus activeStatus = ScooterStatus.FREE;
        ScooterStatus brokenStatus = ScooterStatus.BROKEN;

        Scooter scooter1 = new Scooter((short) 100, new Coordinates(100, 200), activeStatus);
        Scooter scooter2 = new Scooter((short) 100, new Coordinates(200, 200), brokenStatus);

        scootersStorage.addNewScooter(scooter1);
        scootersStorage.addNewScooter(scooter2);

        if (scootersStorage.getAvailableScooters().size() != 1) {
            fail();
        }
        scootersStorage.changeScooterStatus(0, brokenStatus);

        if (scootersStorage.getAvailableScooters().size() != 0) {
            fail();
        }
    }
}