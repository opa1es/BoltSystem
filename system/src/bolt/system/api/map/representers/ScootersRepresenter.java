package bolt.system.api.map.representers;

import bolt.system.api.map.MapAPI;
import bolt.system.database.dao.ScootersDAO;
import bolt.system.entities.coordinates.Coordinates;
import bolt.system.entities.scooter.Scooter;

import java.util.List;
import java.util.stream.Collectors;

public class ScootersRepresenter {

    private ScootersDAO scootersDAO;
    private MapAPI mapAPI;

    public ScootersRepresenter(ScootersDAO scootersDAO) {
        this.scootersDAO = scootersDAO;
        this.mapAPI = new MapAPI();
    }

    public List<Long> getAvailableScootersForUser(Coordinates userCoordinates) {
        return mapAPI.getCloseScooters(userCoordinates, scootersDAO);
    }

    public List<ScootersRepresentationObj> getAvailableScootersRepresentationData(Coordinates userCoordinates) {
        return scootersDAO.getAvailableScooters().stream().map(scooter ->
                new ScootersRepresentationObj(scooter.getScooterId(), scooter.getChargeLevel(), scooter.getCoordinates()))
                .collect(Collectors.toList());
    }

}
