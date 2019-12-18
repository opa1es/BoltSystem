package bolt.system.api.map.representers;

import bolt.system.api.map.MapAPI;
import bolt.system.database.dao.ScootersDAO;
import bolt.system.entities.coordinates.Coordinates;
import bolt.system.entities.scooter.Scooter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @invariants: scootersDAO
 */

public class ScootersRepresenter {

    private /*@ spec_public @*/ ScootersDAO scootersDAO;
    private /*@ spec_public @*/ MapAPI mapAPI;
    
    /*@ public normal_behavior
    @ requires scootersDAO != null;
    @ ensures this.scootersDAO == scootersDAO;
    @ ensures this.mapAPI.getClass() == MapAPI.class;
    @*/
    public ScootersRepresenter(ScootersDAO scootersDAO) {
        this.scootersDAO = scootersDAO;

        this.mapAPI = new MapAPI();
    }

    /*@ 
      @ requires userCoordinates != null;
      @*/
    public List<Long> getAvailableScootersForUser(Coordinates userCoordinates) {
        return mapAPI.getCloseScooters(userCoordinates, scootersDAO);
    }
    
    /*@ 
      @ requires userCoordinates != null;
      @*/
    public List<ScootersRepresentationObj> getAvailableScootersRepresentationData(Coordinates userCoordinates) {
        return scootersDAO.getAvailableScooters().stream().map(scooter ->
                new ScootersRepresentationObj(scooter.getScooterId(), scooter.getChargeLevel(), scooter.getCoordinates()))
                .collect(Collectors.toList());
    }

}
