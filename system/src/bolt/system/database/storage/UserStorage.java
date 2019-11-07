package bolt.system.database.storage;

import bolt.system.entities.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {


    public List<User> usersStorage;


    public UserStorage(List<User> usersStorage) {
        this.usersStorage = usersStorage;
    }

    public UserStorage(){
        usersStorage = new ArrayList<>();
    }


    public void addNewUser(User user){

    }

    public void deleteUser(long id){

    }

    public User getUserById(long id){

        return null;
    }

    public List<User> getAllUsers(){

        return null;
    }





}
