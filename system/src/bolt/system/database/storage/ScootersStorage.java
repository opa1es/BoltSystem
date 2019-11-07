package bolt.system.database.storage;

import bolt.system.entities.scooter.Scooter;

import java.util.ArrayList;
import java.util.List;

/**
 * invariants: scooterStorage
 *
 */
public class ScootersStorage {


    private List<Scooter> scootersStorage;




    public ScootersStorage(List<Scooter> scootersStorage) {
        this.scootersStorage = scootersStorage;
    }

    public ScootersStorage(){
        this.scootersStorage = new ArrayList<>();

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

    }

    /**
     * require -  in database scooterStorage exists Scooter object with id equals param id
     * ; can make connection with DB
     * @param id - id of scooter to select
     * @return scooter object with id: id
     */
    public Scooter getScoterById(long id){

        return null;
    }

    /**
     * require - require in database scooterStorage exists Scooter object with id equals param id
     * ; can make connection with DB
     * @param id - scooter id t delete
     */
    public void deleteScooter(long id){

    }

    /**
     * require - can make connection with DB
     *
     * @return List of scooter objects
     */
    public List<Scooter> getAllScooters(){
        return null;
    }
    /**
     * require - can make connection with DB
     *
     * @return List of scooter objects
     */
    public List<Scooter> addAvailableScooters(){

        return null;
    }










}
