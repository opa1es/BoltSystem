package bolt.system.api.map;

import bolt.system.database.dao.ScootersDAO;
import bolt.system.database.storage.Database;
import bolt.system.entities.coordinates.Coordinates;
import bolt.system.entities.scooter.Scooter;
import bolt.system.util.Distance;
import java.util.List;
import java.util.stream.Collectors;

public class MapAPI {

    private final double CLOSURE_VALUE = 400;

    public List<Long> getCloseScooters(Coordinates userCoordinates, ScootersDAO scootersDAO){
        return scootersDAO.getAvailableScooters().stream().filter(scooter ->
                new Distance(scooter.getCoordinates(),userCoordinates).getDistanceBetweenPoints() <= CLOSURE_VALUE)
                .map(Scooter::getScooterId)
                .collect(Collectors.toList());

    }

}
