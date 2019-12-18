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


    private /*@ spec_public @*/  UserStorage database;

    public UsersDAO(Database database) {
        this.database = database.getUserStorage();
    }

    public UsersDAO() {
        this.database = new Database().getUserStorage();

    } 

    /*@
     @ requires user != null;
     @ 
     @ ensures database.getAllUsers().size() == \old(database.getAllUsers().size()) + 1;
     @
     @*/
    public void addNewUser(User user) {
        this.database.addNewUser(user);
    }

    /*@
    @ requires id >= 0L;
    @ ensures database.getAllUsers().size() - 1 == \old(database.getAllUsers().size());
    @*/
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
