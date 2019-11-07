package bolt.system.database.dao;

import bolt.system.database.storage.UserStorage;
import bolt.system.entities.scooter.Scooter;
import bolt.system.entities.scooter.ScooterStatus;

import java.util.List;

public class UsersDAO {


    private UserStorage database;

    public UsersDAO(UserStorage database) {
        this.database = database;
    }


    public void addNewScooter(Scooter scooter){
        //FIXME
    }


    public void deleteScooter(long id){
        //FIXME

    }



    public Scooter getScooterDataById(long id){
        //FIXME

        return null;
    }

    public ScooterStatus getScooterStatus(long id){
        //FIXME

        return null;
    }

    public List<Scooter> getAllScooters(){
        //FIXME

        return null;
    }

    public List<Scooter> getAvailableScooters(){
        //FIXME

        return null;
    }







}
