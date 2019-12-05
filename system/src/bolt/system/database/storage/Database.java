package bolt.system.database.storage;

public class Database {

    private UserStorage userStorage;
    private ScootersStorage scootersStorage;

    public Database() {
        this.userStorage = new UserStorage();
        this.scootersStorage = new ScootersStorage();
    }


    public Database(UserStorage userStorage, ScootersStorage scootersStorage) {
        this.userStorage = userStorage;
        this.scootersStorage = scootersStorage;
    }

    public UserStorage getUserStorage() {
        return userStorage;
    }

    public void setUserStorage(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public ScootersStorage getScootersStorage() {
        return scootersStorage;
    }

    public void setScootersStorage(ScootersStorage scootersStorage) {
        this.scootersStorage = scootersStorage;
    }
}
