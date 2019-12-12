package bolt.system.database.dao;

import bolt.system.database.storage.Database;
import bolt.system.database.storage.UserStorage;

import bolt.system.entities.user.BankAccountData;
import bolt.system.entities.user.User;

import java.util.List;

/**
 * invariants: userStorage
 */
public class UsersDAO {


    private UserStorage database;

    public UsersDAO(Database database) {
        this.database = database.getUserStorage();
    }

    public UsersDAO() {
        this.database = new Database().getUserStorage();

    }

    /**
     * require - user not null; can make connection with DB
     * <p>
     * ensure - new user entity should be added to UserStorage object storage;
     * new storage.size = old storage.size + 1
     *
     * @param user - user to add
     */
    public void addNewUser(User user) {
        this.database.addNewUser(user);
    }

    /**
     * require - require in database database exists User object with id equals param id
     * ; can make connection with DB
     *
     * @param id - user id to delete
     */
    public void deleteUser(long id) {
        this.database.deleteUser(id);

    }


    /**
     * require -  in database database exists User object with id equals param id
     * ; can make connection with DB
     *
     * @param id - id of user to select
     * @return user object with id: id
     */
    public User getUserById(long id) {
        return this.database.getUserById(id);

    }

    /**
     * require - can make connection with DB
     *
     * @return List of User objects
     */
    public List<User> getAllSUsers() {
        return this.database.getAllUsers();
    }

    /**
     * @param userId          - user id in system
     * @param bankAccountData - new bank account
     */

//    public boolean checkIfUserExists(U)
    public void changeUserBankAccount(long userId, BankAccountData bankAccountData) {
        this.database.changeUserBankAccount(userId, bankAccountData);
    }


}
