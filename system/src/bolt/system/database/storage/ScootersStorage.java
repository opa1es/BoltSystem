package bolt.system.database.storage;

import bolt.system.entities.scooter.Scooter;

import java.util.ArrayList;
import java.util.List;

public class ScootersStorage {


    private List<Scooter> scootersStorage;




    public ScootersStorage(List<Scooter> scootersStorage) {
        this.scootersStorage = scootersStorage;
    }

    public ScootersStorage(){
        this.scootersStorage = new ArrayList<>();

    }


    public void addNewScooter(Scooter scooter){

    }

    public Scooter getScoterById(long id){

        return null;
    }

    public void deleteScooter(long id){

    }

    public List<Scooter> getAllScooters(){
        return null;
    }

    public List<Scooter> addAvailableScooters(){

        return null;
    }










}
