package bolt.system.database.storage;


/**
 * invariants: userStorage, scootersStorage
 */
public class Database {

    private /*@ spec_public @*/ UserStorage userStorage;
    private /*@ spec_public @*/ ScootersStorage scootersStorage;

    /*@ 
     @ public normal_behavior
     @ ensures this.userStorage == new UserStorage();
     @ ensures this.scootersStorage == new ScootersStorage();
     @*/ 
    public /*@ pure @*/ Database() {
        this.userStorage = new UserStorage();
        this.scootersStorage = new ScootersStorage();
    }

    /*@ 
    @ public normal_behavior
    @ requires userStorage != null;
    @ requires scootersStorage != null;
    @ ensures this.userStorage == userStorage;
    @ ensures this.scootersStorage == scootersStorage;
    @*/
    public Database(UserStorage userStorage, ScootersStorage scootersStorage) {
        this.userStorage = userStorage;
        this.scootersStorage = scootersStorage;
    }

    /*@ 
    @ public normal_behavior
    @ ensures this.userStorage == userStorage;
    @ ensures this.scootersStorage == scootersStorage;
    @*/
    public /*@ pure @*/ UserStorage getUserStorage() {
        return userStorage;
    }
    
    /*@
     @ requires userStorage != null;
     @*/
    public void setUserStorage(UserStorage userStorage) {
        this.userStorage = userStorage;
    }
    
    /*@
    @ ensures this.userStorage == userStorage;
    @*/
    public /*@ pure @*/ ScootersStorage getScootersStorage() {
        return scootersStorage;
    }
    
    /*@
    @ requires scootersStorage != scootersStorage;
    @*/
    public void setScootersStorage(ScootersStorage scootersStorage) {
        this.scootersStorage = scootersStorage;
    }
}
