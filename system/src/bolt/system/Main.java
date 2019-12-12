package bolt.system;

import bolt.system.api.bank.BankAPI;
import bolt.system.api.map.MapAPI;
import bolt.system.api.map.representers.ScootersRepresentationObj;
import bolt.system.api.map.representers.ScootersRepresenter;
import bolt.system.controllers.requests.ScooterAccessController;
import bolt.system.controllers.requests.UserRequestController;
import bolt.system.controllers.requests.sessions.SessionController;
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
import bolt.system.util.RidePriceCalculator;
import bolt.system.util.TimeCalculator;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Main {

    public static void caseDataSetup() {
        //USERS:

        BankAccountData bankAccount1 = new BankAccountData("poopa loopa", "13372281313");
        BankAccountData bankAccount2 = new BankAccountData("artjom pekush", "000000000");
        // System.out.println(bankAccount1.hashCode());
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

        //System.out.println(mapAPI.getCloseScooters(user2.coordinates, database));

    }


    private static void checkSystem() {
        // caseDataSetup();
        //checkTimeGetPrice();

        BankAccountData bankAccount1 = new BankAccountData("poopa loopa", "13372281313");
        BankAccountData bankAccount2 = new BankAccountData("artjom pekuch", "000000000");

        BankAPI bankAPI = new BankAPI();
        bankAPI.addNewBankAccountData(bankAccount1, BigDecimal.valueOf(50));
        bankAPI.addNewBankAccountData(bankAccount2, BigDecimal.valueOf(100));

        User user1 = new User("user1", "user1", 56512341);
        User user2 = new User("user2", "user2", 565151511);
        user1.setBankAccount(bankAccount1);
        user2.setBankAccount(bankAccount2);
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
        Scooter scooter2 = new Scooter((short) 100, new Coordinates(200, 200), activeStatus);
        Scooter scooter3 = new Scooter((short) 100, new Coordinates(500, 200), brokenStatus);
        ScootersStorage scootersStorage = new ScootersStorage();
        scootersStorage.addNewScooter(scooter1);
        scootersStorage.addNewScooter(scooter2);
        scootersStorage.addNewScooter(scooter3);

        //DATABASE:
        Database database = new Database(userStorage, scootersStorage);
        UsersDAO usersDAO = new UsersDAO(database);
        ScootersDAO scootersDAO = new ScootersDAO(database);

        //SYSTEM SETUP:
        SessionController sessionController = new SessionController();
        ScooterAccessController scooterAccessController = new ScooterAccessController(scootersDAO, sessionController);
        ScootersRepresenter scootersRepresenter = new ScootersRepresenter(scootersDAO);
        UserRequestController userRequestController = new UserRequestController(scooterAccessController, usersDAO, scootersRepresenter, bankAPI);

        //---------------------------------------------------RUN--------------------------------------------------
        long userId = 0;
        long requesterScooterId = 1;


        List<ScootersRepresentationObj> availableScootersForUser = userRequestController.getAvailableScooters(userId);
        System.out.println(availableScootersForUser);
        System.out.println(userRequestController.tryRentScooter(userId, requesterScooterId));
        System.out.println(sessionController.getScooterActiveSessionDataStorage());
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(userRequestController.tryStopScooterRenting(userId, requesterScooterId));
        System.out.println(sessionController.getScooterActiveSessionDataStorage());

        System.out.println(bankAPI.getBankAccounts());
        //System.out.println(usersDAO.getUserById(0).getBankAccount());
    }

    private static void checkTimeGetPrice() {

        Date date1 = new Date(System.currentTimeMillis());
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Date date2 = new Date(System.currentTimeMillis());
        Date date3 = new Date(new Date(System.currentTimeMillis()).getTime() + 60000);
        double timeDiff = TimeCalculator.getDifferenceInMinutes(date1, date3);
        BigDecimal price = RidePriceCalculator.getMoneyForRide(timeDiff);

        System.out.println(price);

    }

    private static void checkBankPayment(){
        BankAccountData bankAccount1 = new BankAccountData("poopa loopa", "13372281313");
        BankAccountData bankAccount2 = new BankAccountData("artjom pekuch", "000000000");

        BankAPI bankAPI = new BankAPI();
        bankAPI.addNewBankAccountData(bankAccount1, BigDecimal.valueOf(50));
        bankAPI.addNewBankAccountData(bankAccount2, BigDecimal.valueOf(100));

        User user1 = new User("user1", "user1", 56512341);
        User user2 = new User("user2", "user2", 565151511);
        user1.setBankAccount(bankAccount1);
        user2.setBankAccount(bankAccount2);
        user1.setCoordinates(new Coordinates(100, 100));
        user2.setCoordinates(new Coordinates(1000, 1000));

        UserStorage userStorage = new UserStorage();
        userStorage.addNewUser(user1);
        userStorage.addNewUser(user2);
        userStorage.addNewUser(user1);

        System.out.println(bankAPI.makePayment(bankAccount1, BigDecimal.valueOf(20)));
        System.out.println(bankAPI.getBankAccounts());
    }


    public static void main(String[] args) throws InterruptedException {
        checkSystem();
//        checkTimeGetPrice();
    }


}
