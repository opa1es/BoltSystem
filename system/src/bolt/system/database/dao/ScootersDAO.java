package bolt.system.database.dao;

import bolt.system.database.storage.ScootersStorage;
import bolt.system.entities.scooter.Scooter;
import bolt.system.entities.scooter.ScooterStatus;

import java.util.List;

/**
 * invariants: database
 */
public class ScootersDAO {


    private ScootersStorage database;

    public ScootersDAO(ScootersStorage database) {
        this.database = database;
    }

    /**
     * require - scooter not null; can make connection with DB
     *
     * ensure - new scooter entity should be added to scooterStorage object storage;
     * new storage.size = old storage.size + 1
     *
     * @param scooter - scooter to add
     */
    public void addNewScooter(Scooter scooter){
        //FIXME
    }

    /**
     * require - require in database database exists Scooter object with id equals param id
     * ; can make connection with DB
     * @param id - scooter id to delete
     */
    public void deleteScooter(long id){
        //FIXME

    }


    /**
     * require -  in database database exists Scooter object with id equals param id
     * ; can make connection with DB
     * @param id - id of scooter to select
     * @return scooter object with id: id
     */
    public Scooter getScooterById(long id){
        //FIXME

        return null;
    }

    /**
     * require - in database database exists scooter entity with id = id
     *
     * @param id - scooter to select
     * @return return selected scooter status
     */
    public ScooterStatus getScooterStatus(long id){
        //FIXME

        return null;
    }
    /**
     * require - can make connection with DB
     *
     * @return List of scooter objects
     */
    public List<Scooter> getAllScooters(){
        //FIXME

        return null;
    }
    /**
     * require - can make connection with DB
     *
     * @return List of scooter objects
     */
    public List<Scooter> getAvailableScooters(){
        //FIXME

        return null;
    }
    



}
