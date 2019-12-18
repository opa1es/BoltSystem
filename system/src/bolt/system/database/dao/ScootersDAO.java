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

    /*@
    @ requires database != null;
    @ ensures this.database == database.getScootersStorage();
    @*/
    public ScootersDAO(Database database) { 
        this.database = database.getScootersStorage();
    }
    
    /*@ 
    @ ensures this.database == new Database().getScootersStorage();
    @*/
    public ScootersDAO() {
        this.database = new Database().getScootersStorage();
    } 

    /*@
     @ requires scooter != null;
     @ requires database != null;
     @ ensures database.getAllScooters().size() == \old(database.getAllScooters().size()) + 1;
     @*/
    public /*@ pure @*/ void addNewScooter(Scooter scooter) {
        this.database.addNewScooter(scooter);
    }

    /*@ 
     @ requires database != null;
     @ requires id >= 0L;
     @ ensures database.getAllScooters().size() - 1 == \old(database.getAllScooters().size());
     @*/
    public /*@ pure @*/ void deleteScooter(long id) {
        this.database.deleteScooter(id);
 
    }


    /*@
     @ requires id >= 0L;
     @ requires database.getScooterById(id) != null;
     @*/
    /*+INFERRED@
      @ public normal_behavior
      @   requires id >= 0L; 
      @   requires database.getScooterById(id) != null; 
      @     ensures `exception == null; 
      @     ensures `terminationPosition == 1329; 
      @     
      @*/
    public Scooter getScooterById(long id) {
        return this.database.getScooterById(id);

    }

    /*@
     @ requires id >= 0L;
     @ requires database.getScooterById(id) != null;
     @*/
    /*+INFERRED@
      @ public normal_behavior
      @   requires id >= 0L; 
      @   requires database.getScooterById(id) != null; 
      @     ensures `exception == null; 
      @     ensures `terminationPosition == 1544; 
      @     
      @*/
    public ScooterStatus getScooterStatus(long id) {
        return this.database.getScooterById(id).getCurrentStatus();
    }

    /**
     * require - can make connection with DB
     *
     * @return List of scooter objects
     */
    /*+INFERRED@
      @ public normal_behavior
      @     ensures `exception == null; 
      @     ensures `terminationPosition == 1779; 
      @     
      @*/
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
