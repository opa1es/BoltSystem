package bolt.system.database.dao;

import bolt.system.database.storage.Database;
import bolt.system.database.storage.ScootersStorage;
import bolt.system.entities.scooter.Scooter;
import bolt.system.entities.scooter.ScooterStatus;

import javax.xml.crypto.Data;
import java.util.List;

/**
 * @invariants: database
 */
public class ScootersDAO {


    private /*@ spec_public @*/ ScootersStorage database;

    public ScootersDAO(Database database) {
        this.database = database.getScootersStorage();
    }

    public ScootersDAO() {
        this.database = new Database().getScootersStorage();
    }

    /*@ public normal_behavior
     @ requires scooter != null;
     @ ensures database.getAllScooters().size() == \old(database.getAllScooters().size()) + 1;
     @*/
    public void addNewScooter(Scooter scooter) {
        this.database.addNewScooter(scooter);
    }

    /*@
     @ requires id >= 0L;
     @ ensures database.getAllScooters().size() - 1 == \old(database.getAllScooters().size());
     @*/
    public void deleteScooter(long id) {
        this.database.deleteScooter(id);
 
    }


    /*@
     @ requires id >= 0L;
     @ requires database.getScooterById(id) != null;
     @*/
    public Scooter getScooterById(long id) {
        return this.database.getScooterById(id);

    }

    /*@
     @ requires id >= 0L;
     @ requires database.getScooterById(id) != null;
     @*/
    public ScooterStatus getScooterStatus(long id) {
        return this.database.getScooterById(id).getCurrentStatus();
    }

    /**
     * require - can make connection with DB
     *
     * @return List of scooter objects
     */
    public List<Scooter> getAllScooters() {
        return this.database.getAllScooters();
    }

    /**
     * require - can make connection with DB
     *
     * @return List of scooter objects
     */
    public List<Scooter> getAvailableScooters() {

        return this.database.getAvailableScooters();
    }


}
