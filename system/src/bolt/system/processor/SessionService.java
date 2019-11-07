package bolt.system.processor;

import bolt.system.entities.scooter.Scooter;

import java.util.ArrayList;
import java.util.List;

public class SessionService {

    private String sessionId;
    private List<Scooter> availableScooters;

    public SessionService(String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * Requires: -
     * Ensures: -
     *
     * @return list of available scooters
     */
    public List<Scooter> getAvailableScooters() {
        return this.availableScooters;
    }
}
