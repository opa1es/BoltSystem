package bolt.system.database.storage;

import bolt.system.entities.user.BankAccountData;
import bolt.system.entities.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * invariants: userStorage
 */
public class UserStorage {


    private /*@ spec_public @*/ List<User> usersStorage;
    private /*@ spec_public @*/ Long userIdGenerator = 0L;

    /*@
    @ requires usersStorage != null;
    @ ensures this.usersStorage == usersStorage;
    @*/
    public  /*@ pure @*/ UserStorage(List<User> usersStorage) {
        this.usersStorage = usersStorage;
    }

    /*@
    @ ensures usersStorage == new ArrayList<User>();
    @*/
    public  /*@ pure @*/ UserStorage() {
        usersStorage = new ArrayList<>();
    }

    /**
     * require - user not null; can make connection with DB
     * <p>
     * ensure - new user entity should be added to UserStorage object storage;
     * new storage.size = old storage.size + 1
     *
     * @param user - user to add
     */
    /*@
     @ requires user != null;
    @ ensures usersStorage.size() == \old(usersStorage.size()) + 1;
    @*/
    public void addNewUser(User user) {
        if (!usersStorage.contains(user)) {
            user.setUserId(this.userIdGenerator++);
            this.usersStorage.add(user);
        }

    }

    /**
     * require - require in database database exists User object with id equals param id
     * ; can make connection with DB
     *
     * @param id - user id to delete
     */
    /*@
    @ requires id >= 0L;
   @ ensures usersStorage.size() == \old(usersStorage.size()) - 1;
   @*/
    public void deleteUser(long id) {
        User userToRemove = this.usersStorage.stream().filter(user -> user.getUserId() == id).findFirst().orElse(null);
        this.usersStorage.remove(userToRemove);
    }

    /**
     * require -  in database database exists User object with id equals param id
     * ; can make connection with DB
     *
     * @param id - id of user to select
     * @return user object with id: id
     */
    /*@
    @ requires id >= 0L;
   @*/
    public /*@ pure @*/ User getUserById(long id) {
        return this.usersStorage.stream().filter(user -> user.getUserId() == id).findFirst().orElse(null);

    }

    /**
     * require - can make connection with DB
     *
     * @return List of User objects
     */
    /*@
    @ requires this.usersStorage != null;
   @*/
    public /*@ pure @*/  List<User> getAllUsers() {
        return this.usersStorage;
    }

    /**
     * @param userId             - user id in system
     * @param newBankAccountData - new bank account
     */
    /*@
    @ requires userId >= 0L;
    @ requires newBankAccountData != null;
   @*/
    public void changeUserBankAccount(long userId, BankAccountData newBankAccountData) {
        for (User user : usersStorage) {
            if (user.getUserId() == userId) {
                user.setBankAccount(newBankAccountData);
                break;
            }
        }
    }


}
