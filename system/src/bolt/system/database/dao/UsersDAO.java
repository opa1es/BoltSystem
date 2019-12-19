package bolt.system.database.dao;

import bolt.system.database.storage.Database;
import bolt.system.database.storage.UserStorage;

import bolt.system.entities.user.BankAccountData;
import bolt.system.entities.user.User;

import java.util.List;

/**
 * @invariants: userStorage
 */
public class UsersDAO {


    private /*@ spec_public @*/  UserStorage database;
    
    /*@
    @ requires database != null;
    @ 
    @ ensures this.database == database.getUserStorage();
    @
    @*/
    public UsersDAO(Database database) {
        this.database = database.getUserStorage();
    }
    
    /*@
    @ ensures this.database == new Database().getUserStorage();
    @
    @*/
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


    /*@
     @ requires id >= 0L;
     @ ensures this.database.getUserById(id) != null;
     @*/
    public User getUserById(long id) {
        return this.database.getUserById(id);

    }


    /*@
    @ ensures this.database.getAllUsers() != null;
    @*/
    public List<User> getAllSUsers() {
        return this.database.getAllUsers();
    } 


//    public boolean checkIfUserExists(U)
    /*@
    @ requires userId >= 0L;
    @ requires bankAccountData != null;
    @ ensures this.database.getUserById(userId).getBankAccount() != \old(database.getUserById(userId).getBankAccount());
    @*/
    public void changeUserBankAccount(long userId, BankAccountData bankAccountData) {
        this.database.changeUserBankAccount(userId, bankAccountData);
    }


}
