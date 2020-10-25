package bolt.system.database.storage;

import bolt.system.entities.user.BankAccountData;
import bolt.system.entities.user.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserStorageTest {

    static UserStorage usersStorage;

    @BeforeEach
    void refreshStorage() {
        usersStorage = new UserStorage();

    }

    @Test
    void addNewUser() {

        BankAccountData bankAccount1 = new BankAccountData("user1", "13372281313");
        BankAccountData bankAccount2 = new BankAccountData("user2", "000000000");


        User user1 = new User("user1", "user1", "56512341", bankAccount1);
        User user2 = new User("user2", "user2", "565151511", bankAccount2);

        user1.setBankAccount(bankAccount1);
        user2.setBankAccount(bankAccount2);

        usersStorage.addNewUser(user1);
        usersStorage.addNewUser(user1);
        if (usersStorage.getAllUsers().size() != 1) {
            fail();
        }
        if (!usersStorage.getAllUsers().contains(user1)) {
            fail();
        }

        usersStorage.addNewUser(user2);

        usersStorage.addNewUser(user1);
        usersStorage.addNewUser(user1);

        if (usersStorage.getAllUsers().size() != 2) {
            fail();
        }
        if (!usersStorage.getAllUsers().contains(user2) || !usersStorage.getAllUsers().contains(user1)) {
            fail();
        }


    }

    @Test
    void deleteUser() {
        System.out.println(usersStorage.getAllUsers());

        BankAccountData bankAccount1 = new BankAccountData("user1", "13372281313");
        BankAccountData bankAccount2 = new BankAccountData("user2", "000000000");


        User user1 = new User("user1", "user1", "56512341", bankAccount1);
        User user2 = new User("user2", "user2", "565151511", bankAccount2);

        user1.setBankAccount(bankAccount1);
        user2.setBankAccount(bankAccount2);

        usersStorage.addNewUser(user1);
        usersStorage.addNewUser(user2);

        usersStorage.deleteUser(user1.getUserId());

        if (usersStorage.getAllUsers().size() != 1) {
            fail();
        }

        usersStorage.deleteUser(user2.getUserId());

        if (usersStorage.getAllUsers().contains(user2) || usersStorage.getAllUsers().contains(user1)) {
            fail();
        }

        if (usersStorage.getAllUsers().size() != 0) {
            fail();
        }
    }

    @Test
    void getUserById() {

        BankAccountData bankAccount1 = new BankAccountData("user1", "13372281313");
        BankAccountData bankAccount2 = new BankAccountData("user2", "000000000");


        User user1 = new User("user1", "user1", "56512341", bankAccount1);
        User user2 = new User("user2", "user2", "565151511", bankAccount2);


        user1.setBankAccount(bankAccount1);
        user2.setBankAccount(bankAccount2);

        if (usersStorage.getUserById(0) != null) {
            fail();
        }
        if (usersStorage.getUserById(1) != null) {
            fail();
        }

        usersStorage.addNewUser(user1);
        usersStorage.addNewUser(user2);

        if (usersStorage.getUserById(0) != user1) {
            fail();
        }
        if (usersStorage.getUserById(1) != user2) {
            fail();
        }

    }

    @Test
    void getAllUsers() {
        BankAccountData bankAccount1 = new BankAccountData("user1", "13372281313");
        BankAccountData bankAccount2 = new BankAccountData("user2", "000000000");


        User user1 = new User("user1", "user1", "56512341", bankAccount1);
        User user2 = new User("user2", "user2", "565151511", bankAccount2);


        user1.setBankAccount(bankAccount1);
        user2.setBankAccount(bankAccount2);

        usersStorage.addNewUser(user1);
        usersStorage.addNewUser(user2);

        if (!usersStorage.getAllUsers().contains(user1) || !usersStorage.getAllUsers().contains(user2)) {
            fail();
        }

        if (usersStorage.getAllUsers().size() != 2) {
            fail();
        }

    }

    @Test
    void changeUserBankAccount() {
        BankAccountData bankAccount1 = new BankAccountData("user1", "13372281313");
        BankAccountData bankAccount2 = new BankAccountData("user2", "000000000");


        User user1 = new User("user1", "user1", "56512341", bankAccount1);


        user1.setBankAccount(bankAccount1);

        if (!user1.getBankAccount().equals(bankAccount1)) {
            fail();
        }

        user1.setBankAccount(bankAccount2);
        if (!user1.getBankAccount().equals(bankAccount2)) {
            fail();
        }


    }
}