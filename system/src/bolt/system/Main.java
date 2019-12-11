package bolt.system;

import bolt.system.api.map.MapAPI;
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
import bolt.system.util.TimeCalculator;

import javax.xml.crypto.Data;
import java.util.Date;

public class Main {

    public static void caseDataSetup() {
        //USERS:

        BankAccountData bankAccount1 = new BankAccountData("poopa loopa", "13372281313");
        BankAccountData bankAccount2 = new BankAccountData("artjom pekush", "000000000");

        User user1 = new User("user1", "user1", 56512341);
        User user2 = new User("user2", "user2", 565151511);

        user1.setCoordinates(new Coordinates(100, 100));
        user2.setCoordinates(new Coordinates(1000, 1000));


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
        Database database = new Database(userStorage, scootersStorage);
        UsersDAO usersDAO = new UsersDAO(database);
        ScootersDAO scootersDAO = new ScootersDAO(database);

        //MAP API
        MapAPI mapAPI = new MapAPI();

        //PRINT

        System.out.println(usersDAO.getAllSUsers());
        System.out.println(scootersDAO.getAllScooters());

        System.out.println(mapAPI.getCloseScooters(user2.coordinates, database));

    }
    private static void checkTime(){
        //case1();
        Date date1 = new Date(System.currentTimeMillis());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date date2 = new Date(System.currentTimeMillis());

        System.out.println(TimeCalculator.getDifferenceInMinutes(date1,date2));

    }
    public static void main(String[] args) throws InterruptedException {

    }


}
