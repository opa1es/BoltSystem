package bolt.system.database.dao;

import bolt.system.database.storage.Database;
import bolt.system.database.storage.ScootersStorage;
import bolt.system.entities.scooter.Scooter;
import bolt.system.entities.scooter.ScooterStatus;

import javax.xml.crypto.Data;
import java.util.List;

/**
 * invariants: database
 */
public class ScootersDAO {
    private ScootersStorage database;

    public ScootersDAO(Database database) {
        this.database = database.getScootersStorage();
    }

    public ScootersDAO() {
        this.database = new Database().getScootersStorage();
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
        this.database.addNewScooter(scooter);
    }

    /**
     * require - require in database database exists Scooter object with id equals param id
     * ; can make connection with DB
     *
     * @param id - scooter id to delete
     */
    public void deleteScooter(long id) {
        this.database.deleteScooter(id);

    }


    /**
     * require -  in database database exists Scooter object with id equals param id
     * ; can make connection with DB
     *
     * @param id - id of scooter to select
     * @return scooter object with id: id
     */
    public Scooter getScooterById(long id) {
        return this.database.getScooterById(id);

    }

    /**
     * require - in database database exists scooter entity with id = id
     *
     * @param id - scooter to select
     * @return return selected scooter status
     */
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
