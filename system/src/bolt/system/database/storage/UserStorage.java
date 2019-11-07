package bolt.system.database.storage;

import bolt.system.entities.user.BankAccountData;
import bolt.system.entities.user.User;

import java.util.ArrayList;
import java.util.List;

/**
 * invariants: userStorage
 */
public class UserStorage {


    private List<User> usersStorage;


    public UserStorage(List<User> usersStorage) {
        this.usersStorage = usersStorage;
    }

    public UserStorage(){
        usersStorage = new ArrayList<>();
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

    }
    /**
     * require - require in database database exists User object with id equals param id
     * ; can make connection with DB
     * @param id - user id to delete
     */
    public void deleteUser(long id){

    }
    /**
     * require -  in database database exists User object with id equals param id
     * ; can make connection with DB
     * @param id - id of user to select
     * @return user object with id: id
     */
    public User getUserById(long id){

        return null;
    }
    /**
     * require - can make connection with DB
     *
     * @return List of User objects
     */
    public List<User> getAllUsers(){

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
