package bolt.system.api.bank;

import bolt.system.controllers.requests.ScooterAccessController;
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

class BankAPITest {

    static BankAPI bankAPI;
    static BankAccountData bankAccount1;
    static BankAccountData bankAccount2;


    @BeforeEach
    void refreshStorage() {


        bankAccount1 = new BankAccountData("user 1", "1111111111111111");
        bankAccount2 = new BankAccountData("user 2", "2222222222222222");

        User user1 = new User("user1", "user1", "56512341", bankAccount1);
        User user2 = new User("user2", "user2", "565151511", bankAccount2);

        user1.setBankAccount(bankAccount1);
        user2.setBankAccount(bankAccount2);
        user1.setCoordinates(new Coordinates(100, 100));
        user2.setCoordinates(new Coordinates(1000, 1000));


        bankAPI = new BankAPI();


    }


    @Test
    void addNewBankAccountData() {


        if (bankAPI.getBankAccounts().size() != 0) {
            fail();
        }
        bankAPI.addNewBankAccountData(bankAccount1, BigDecimal.valueOf(50));
        bankAPI.addNewBankAccountData(bankAccount2, BigDecimal.valueOf(100));

        if (bankAPI.getBankAccounts().size() != 2) {
            fail();
        }
        if (!bankAPI.getBankAccounts().containsKey(bankAccount1)) {
            fail();
        }
        if (!bankAPI.getBankAccounts().containsKey(bankAccount2)) {
            fail();
        }

    }


    @Test
    void checkIfAccountExists() {
        if (bankAPI.getBankAccounts().size() != 0) {
            fail();
        }
        bankAPI.addNewBankAccountData(bankAccount2, BigDecimal.valueOf(100));

        if (!bankAPI.getBankAccounts().containsKey(bankAccount2)) {
            fail();
        }

    }
}