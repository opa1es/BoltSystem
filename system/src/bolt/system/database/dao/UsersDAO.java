package bolt.system.database.dao;

import bolt.system.controllers.requests.UserRequestController;
import bolt.system.database.storage.UserStorage;

import bolt.system.entities.user.BankAccountData;
import bolt.system.entities.user.User;

import java.util.List;

/**
 * invariants: userStorage
 */
public class UsersDAO {


    private UserStorage database;

    public UsersDAO(UserStorage database) {
        this.database = database;
    }

    /**
     * require - user not null; can make connection with DB
     *
     * ensure - new user entity should be added to UserStorage object storage;
     * new storage.size = old storage.size + 1
     *
     * @param user - user to add
     */
    public void addNewUser(User user){
        //FIXME
    }

    /**
     * require - require in database database exists User object with id equals param id
     * ; can make connection with DB
     * @param id - user id to delete
     */
    public void deleteUser(long id){
        //FIXME

    }


    /**
     * require -  in database database exists User object with id equals param id
     * ; can make connection with DB
     * @param id - id of user to select
     * @return user object with id: id
     */
    public User getUserById(long id){
        //FIXME

        return null;
    }

    /**
     * require - can make connection with DB
     *
     * @return List of User objects
     */
    public List<User> getAllSUsers(){
        //FIXME

        return null;
    }

    /**
     *
     * @param userId - user id in system
     * @param bankAccountData - new bank account
     */
    public void changeUserBankAccount(long userId, BankAccountData bankAccountData){

    }







}
