package bolt.system.database.storage;

import bolt.system.entities.user.BankAccountData;
import bolt.system.entities.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class  UserStorage {
    private /*@ spec_public nullable @*/ List<User> usersStorage;
    private /*@ spec_public nullable @*/ Long userIdGenerator = 0L;

    /*@ public normal_behavior
      @ requires usersStorage.length > 0;
      @ assignable this.usersStorage;
      @ ensures this.usersStorage = usersStorage;
      @*/
    public UserStorage(List<User> usersStorage) {
        this.usersStorage = usersStorage;
    }

    /*@ public normal_behavior
      @ requires usersStorage != null;
      @ assignable usersStorage;
      @*/
    public UserStorage() {
        usersStorage = new ArrayList<>();
    }

    /*@ public normal_behavior
      @ requires usersStorage != null && !contains(usersStorage)
      @ ensures \result contains(usersStorage)
      @ ensures (\forall UsersStorage usersStorages;
      @                  usersStorages != usersStorage;
      @                  contains(usersStorages) <==> \old(contains(usersStorages)));
      @ ensures usersStorage.size == \old(usersStorage.size) + 1
      @ ensures userIdGenerator == \old(userIdGenerator) + 1
      @*/
    public void addNewUser(User user) {
        if (!usersStorage.contains(user)) {
            user.setUserId(this.userIdGenerator++);
            this.usersStorage.add(user);
        }

    }

    /*@ public normal_behavior
      @ requires (\forall long i; 0 < i && i < userStorage.size;
      @                            userStorage.get(i - 1) <= userStorage.get(i));
      @ ensures !contains(id)
      @ ensures (\forall long index;
      @                  index != id;
      @                  contains(index) <==> \old(contains(index)));
      @ ensures \old(contains(id)) ==>
      @         userStorage.size == \old(userStorage.size) - 1;
      @ ensures !\old(contains(id)) ==>
      @         userStorage.size == \old(userStorage.size);
      @ ensures (\forall long i; 0 < i && i < userStorage.size;
      @                            userStorage.get(i - 1) <= userStorage.get(i));
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
    public User getUserById(long id) {
        return this.usersStorage.stream().filter(user -> user.getUserId() == id).findFirst().orElse(null);

    }

    /**
     * require - can make connection with DB
     *
     * @return List of User objects
     */
    public List<User> getAllUsers() {
        return this.usersStorage;
    }

    /**
     * @param userId             - user id in system
     * @param newBankAccountData - new bank account
     */
    public void changeUserBankAccount(long userId, BankAccountData newBankAccountData) {
        for (User user : usersStorage) {
            if (user.getUserId() == userId) {
                user.setBankAccount(newBankAccountData);
                break;
            }
        }
    }


}
