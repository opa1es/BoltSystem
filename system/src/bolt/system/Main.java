package bolt.system;

import bolt.system.database.dao.ScootersDAO;
import bolt.system.database.dao.UsersDAO;
import bolt.system.database.storage.Database;
import bolt.system.database.storage.ScootersStorage;
import bolt.system.database.storage.UserStorage;
import bolt.system.entities.coordinates.Coordinates;
import bolt.system.entities.scooter.Scooter;
import bolt.system.entities.scooter.ScooterStatus;
import bolt.system.entities.user.BankAccountData;
import bolt.system.entities.user.User;

import javax.xml.crypto.Data;

public class Main {


    public static void main(String[] args) {

        //USERS:

        BankAccountData bankAccount1 = new BankAccountData("poopa loopa", "13372281313");
        BankAccountData bankAccount2 = new BankAccountData("artjom pekush", "000000000");

        User user1 = new User("user1", "user1", 56512341);
        User user2 = new User("user2", "user2", 565151511);

        UserStorage userStorage = new UserStorage();
        userStorage.addNewUser(user1);
        userStorage.addNewUser(user2);
        userStorage.addNewUser(user1);


        //SCOOTERS:
        ScooterStatus activeStatus = ScooterStatus.FREE;
        ScooterStatus brokenStatus = ScooterStatus.BROKEN;


        Scooter scooter1 = new Scooter((short) 100, new Coordinates(100, 200), activeStatus);
        Scooter scooter2 = new Scooter((short) 100, new Coordinates(200, 200), brokenStatus);

        ScootersStorage scootersStorage = new ScootersStorage();
        scootersStorage.addNewScooter(scooter1);
        scootersStorage.addNewScooter(scooter2);

        //DATABASE:
        Database database = new Database(userStorage,scootersStorage);
        UsersDAO usersDAO = new UsersDAO(database);
        ScootersDAO scootersDAO = new ScootersDAO(database);

        //PRINT

        System.out.println(usersDAO.getAllSUsers());
        System.out.println(scootersDAO.getAllScooters());

        //System.out.println(scootersStorage.getAllScooters());
        //scootersStorage.deleteScooter(1);
        //System.out.println(scootersStorage.getAllScooters());

    }


}
