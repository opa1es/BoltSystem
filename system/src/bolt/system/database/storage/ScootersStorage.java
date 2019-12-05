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


    private List<Scooter> scootersStorage;


    public ScootersStorage(List<Scooter> scootersStorage) {
        this.scootersStorage = scootersStorage;
    }

    public ScootersStorage() {
        this.scootersStorage = new ArrayList<>();

    }

    /**
     * require - scooter not null; can make connection with DB
     * <p>
     * ensure - new scooter entity should be added to scooterStorage object storage;
     * new storage.size = old storage.size + 1
     *
     * @param scooter - scooter to add
     */
    public void addNewScooter(Scooter scooter) {
        if (scootersStorage.contains(scooter)) {
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

    /**
     * require - require in database scooterStorage exists Scooter object with id equals param id
     * ; can make connection with DB
     *
     * @param id - scooter id t delete
     */
    public void deleteScooter(long id) {
        Scooter scooterToRemove = this.scootersStorage.stream().filter(scooter -> scooter.getScooterId() == id).findFirst().orElse(null);
        this.scootersStorage.remove(scooterToRemove);
    }

    /**
     * require - can make connection with DB
     *
     * @return List of scooter objects
     */
    public List<Scooter> getAllScooters() {
        return this.scootersStorage;
    }

    /**
     * require - can make connection with DB
     *
     * @return List of scooter objects
     */
    public List<Scooter> addAvailableScooters() {

        return this.scootersStorage.stream().filter(scooter -> scooter.getChargeLevel() > 10 && scooter.getCurrentStatus() == ScooterStatus.FREE).collect(Collectors.toList());
    }

    public void changeScooterStatus(long id, ScooterStatus newStatus){
        for (Scooter scooter : scootersStorage) {
            if (scooter.getScooterId() == id) {
                scooter.setCurrentStatus(newStatus);
                break;
            }
        }

    }

}
