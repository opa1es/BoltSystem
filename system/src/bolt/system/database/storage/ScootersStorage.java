package bolt.system.database.storage;

import bolt.system.entities.scooter.Scooter;
import bolt.system.entities.scooter.ScooterStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScootersStorage {
    private static final short LOW_POWER_VALUE = 10;
    private /*@ spec_public @*/ List<Scooter> scootersStorage;
    private /*@ spec_public @*/ long scooterIdGenerator = 0L;

    //@ public invariant scootersStorage != null;
    //@ public invariant scooterIdGenerator >= 0;

    /*@ public normal_behavior
      @ requires scootersStorage != null;
      @ assignable this.scootersStorage;
      @ ensures this.scootersStorage = scootersStorage;
      @*/
    public ScootersStorage(List<Scooter> scootersStorage) {
        this.scootersStorage = scootersStorage;
    }

    /*@ public normal_behavior
      @ requires scootersStorage != null;
      @ assignable this.scootersStorage;
      @*/
    public ScootersStorage() {
        this.scootersStorage = new ArrayList<>();
    }

    /*@ public normal_behavior
      @ requires scooter != null && !contains(scooter) && scooterIdGenerator != null;
      @ ensures \result contains(scooter);
      @ ensures (\forall Scooter scooters;
      @                  scooters != scooter;
      @                  contains(scooters) <==> \old(contains(scooters)));
      @ ensures scootersStorage.size == \old(scooterStorage.size) + 1;
      @ ensures scooterIdGenerator == \old(scooterIdGenerator) + 1;
      @*/
    public void addNewScooter(Scooter scooter) {
        if (!scootersStorage.contains(scooter)) {
            scooter.setScooterId(this.scooterIdGenerator++);
            this.scootersStorage.add(scooter);
        }

    }

    /**
     * require -  in database scooterStorage exists Scooter object with id equals param id
     * ; can make connection with DB
     *
     * @param id - id of scooter to select
     * @return scooter object with id: id
     */
    public Scooter getScooterById(long id) {
        return this.scootersStorage.stream().filter(scooter -> scooter.getScooterId() == id).findFirst().orElse(null);

    }

    /*@ public normal_behavior
      @ requires (\forall long i; 0 < i && i < scootersStorage.size;
      @                            scootersStorage.get(i - 1) <= scootersStorage.get(i));
      @ ensures !contains(id)
      @ ensures (\forall long index;
      @                  index != id;
      @                  contains(index) <==> \old(contains(index)));
      @ ensures \old(contains(id)) ==>
      @         scootersStorage.size == \old(scootersStorage.size) - 1;
      @ ensures !\old(contains(id)) ==>
      @         scootersStorage.size == \old(scootersStorage.size);
      @ ensures (\forall long i; 0 < i && i < scootersStorage.size;
      @                            scootersStorage.get(i - 1) <= scootersStorage.get(i));
      @*/
    public void deleteScooter(long id) {
        Scooter scooterToRemove = this.scootersStorage.stream().filter(scooter -> scooter.getScooterId() == id).findFirst().orElse(null);
        this.scootersStorage.remove(scooterToRemove);
    }

    /**
     * require - can make connection with DB
     *
     * @return List of scooter objects
     */
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

    public List<Scooter> getAllScooters() {
        return this.scootersStorage;
    }
}
