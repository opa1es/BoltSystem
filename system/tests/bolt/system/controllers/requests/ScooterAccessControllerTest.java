package bolt.system.controllers.requests;

import bolt.system.api.bank.BankAPI;
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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ScooterAccessControllerTest {


    static ScooterAccessController scooterAccessController;
    static BankAPI bankAPI;


    @BeforeEach
    void refreshStorage() {

        ScooterStatus activeStatus = ScooterStatus.FREE;
        ScooterStatus brokenStatus = ScooterStatus.BROKEN;


        BankAccountData bankAccount1 = new BankAccountData("user 1", "1111111111111111");
        BankAccountData bankAccount2 = new BankAccountData("user 2", "2222222222222222");

        User user1 = new User("user1", "user1", "56512341", bankAccount1);
        User user2 = new User("user2", "user2", "565151511", bankAccount2);
        user1.setBankAccount(bankAccount1);
        user2.setBankAccount(bankAccount2);
        user1.setCoordinates(new Coordinates(100, 100));
        user2.setCoordinates(new Coordinates(1000, 1000));


        bankAPI = new BankAPI();
        bankAPI.addNewBankAccountData(bankAccount1, BigDecimal.valueOf(50));
        bankAPI.addNewBankAccountData(bankAccount2, BigDecimal.valueOf(100));

        UserStorage userStorage = new UserStorage();
        ScootersStorage scootersStorage = new ScootersStorage();

        Scooter scooter1 = new Scooter((short) 100, new Coordinates(100, 200), activeStatus);
        Scooter scooter2 = new Scooter((short) 100, new Coordinates(200, 200), activeStatus);
        Scooter scooter3 = new Scooter((short) 100, new Coordinates(500, 200), brokenStatus);
        scootersStorage.addNewScooter(scooter1);
        scootersStorage.addNewScooter(scooter2);
        scootersStorage.addNewScooter(scooter3);


        userStorage.addNewUser(user1);
        userStorage.addNewUser(user2);


        Database database = new Database(userStorage, scootersStorage);
        UsersDAO usersDAO = new UsersDAO(database);
        ScootersDAO scootersDAO = new ScootersDAO(database);

        SessionController sessionController = new SessionController();

        scooterAccessController = new ScooterAccessController(scootersDAO, usersDAO, sessionController, bankAPI);


    }

    @Test
    void tryToGetScooter() {

        boolean check_1 = scooterAccessController.tryToGetScooter(1, 1);
        boolean check_2 = scooterAccessController.tryToGetScooter(1, 1);

        if (!check_1) {
            fail();
        }
        if (check_2) {
            fail();
        }

    }

    @Test
    void closeScooterSessionAndMakePayment1() {
        scooterAccessController.tryToGetScooter(1, 1);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!scooterAccessController.closeScooterSessionAndMakePayment(1)) {
            fail();
        }

        if (scooterAccessController.closeScooterSessionAndMakePayment(1)) {
            fail();
        }

    }

    @Test
    void closeScooterSessionAndMakePayment2() {


        scooterAccessController.tryToGetScooter(1, 1);
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        BigDecimal oldValue = bankAPI.getBankAccounts().get(scooterAccessController.getUsersDAO().getUserById(1).getBankAccount());


        if (!scooterAccessController.closeScooterSessionAndMakePayment(1)) {
            fail();
        }

        BigDecimal newValue = bankAPI.getBankAccounts().get(scooterAccessController.getUsersDAO().getUserById(1).getBankAccount());
        BigDecimal trueValue = oldValue.subtract(BigDecimal.valueOf(0.01)).setScale(3, BigDecimal.ROUND_HALF_UP);

        if (!newValue.equals(trueValue)) {
            fail();
        }

        if (scooterAccessController.closeScooterSessionAndMakePayment(1)) {
            fail();
        }


    }


    @Test
    void tryMakePayment() {

        BigDecimal oldValue = bankAPI.getBankAccounts().get(scooterAccessController.getUsersDAO().getUserById(1).getBankAccount());

        BigDecimal fstValueToSubstract = BigDecimal.valueOf(2).setScale(3, BigDecimal.ROUND_HALF_UP);
        BigDecimal sndValueToSubstract = BigDecimal.valueOf(3).setScale(3, BigDecimal.ROUND_HALF_UP);
        BigDecimal initValue = BigDecimal.valueOf(100);

        System.out.println(bankAPI.getBankAccounts().get(scooterAccessController.getUsersDAO().getUserById(1).getBankAccount()));

        scooterAccessController.tryMakePayment(1, fstValueToSubstract);

        BigDecimal trueValue1 = initValue.subtract(fstValueToSubstract);

        if (!bankAPI.getBankAccounts().get(scooterAccessController.getUsersDAO().getUserById(1).getBankAccount()).equals(trueValue1)) {
            fail();
        }

        BigDecimal trueValue2 = trueValue1.subtract(sndValueToSubstract);
        scooterAccessController.tryMakePayment(1, sndValueToSubstract);

        if (!bankAPI.getBankAccounts().get(scooterAccessController.getUsersDAO().getUserById(1).getBankAccount()).equals(trueValue2)) {
            fail();
        }

    }
}