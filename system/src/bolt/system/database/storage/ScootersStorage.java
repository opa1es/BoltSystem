package bolt.system.database.storage;

import bolt.system.entities.scooter.Scooter;
import bolt.system.entities.scooter.ScooterStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * invariants: scooterStorage
 */
public class ScootersStorage {


    public static final short LOW_POWER_VALUE = 10;
    private /*@ spec_public @*/ List<Scooter> scootersStorage;
    private /*@ spec_public @*/ long scooterIdGenerator = 0L;

    /*@
    @ requires scootersStorage != null;
    @ ensures this.scootersStorage == scootersStorage;
    @*/
    public /*@ pure @*/ ScootersStorage(List<Scooter> scootersStorage) {
        this.scootersStorage = scootersStorage;
    }

    /*@
    @ ensures this.scootersStorage == new ArrayList<Scooter>();
    @*/
    public /*@ pure @*/ ScootersStorage() {
        this.scootersStorage = new ArrayList<>();

    }

    /*@
    @ requires scooter != null;
    @ ensures scootersStorage.size() == \old(scootersStorage.size()) + 1;
    @*/
    public void addNewScooter(Scooter scooter) {
        if (!scootersStorage.contains(scooter)) {
            scooter.setScooterId(this.scooterIdGenerator++);
            this.scootersStorage.add(scooter);
        }

    }


    /*@
    @ requires id >= 0L;
    @*/
    public /*@ pure @*/ Scooter getScooterById(long id) {
        return this.scootersStorage.stream().filter(scooter -> scooter.getScooterId() == id).findFirst().orElse(null);

    }

    /*@
    @ requires id >= 0L;
    @ ensures scootersStorage.size() == \old(scootersStorage.size()) - 1;
    @*/
    public void deleteScooter(long id) {
        Scooter scooterToRemove = this.scootersStorage.stream().filter(scooter -> scooter.getScooterId() == id).findFirst().orElse(null);
        this.scootersStorage.remove(scooterToRemove);
    }


    public /*@ pure @*/ List<Scooter> getAllScooters() {
        return this.scootersStorage;
    }


    public List<Scooter> getAvailableScooters() {
        return this.scootersStorage.stream().filter(scooter -> scooter.getChargeLevel() > LOW_POWER_VALUE && scooter.getCurrentStatus() == ScooterStatus.FREE).collect(Collectors.toList());
    }

    public void changeScooterStatus(long id, ScooterStatus newStatus) {
        for (Scooter scooter : scootersStorage) {
            if (scooter.getScooterId() == id) {
                scooter.setCurrentStatus(newStatus);
                break;
            }
        }

    }

}
