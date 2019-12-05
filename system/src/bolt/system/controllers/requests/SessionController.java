package bolt.system.controllers.requests;


import java.util.ArrayList;
import java.util.List;

public class SessionController {

    private List<ScooterActiveSessionData> scooterActiveSessionDataStorage;


    public SessionController() {
        this.scooterActiveSessionDataStorage = new ArrayList<>();

    }

    public SessionController(List<ScooterActiveSessionData> scooterActiveSessionDataStorage) {
        this.scooterActiveSessionDataStorage = scooterActiveSessionDataStorage;
    }

    public void addNewSession(ScooterActiveSessionData session) {
        if (!checkIfSessionIsActive(session)) {
            scooterActiveSessionDataStorage.add(session);
        }

    }

    public boolean checkIfSessionIsActive(ScooterActiveSessionData session) {
        return scooterActiveSessionDataStorage.stream().anyMatch(activeSession -> activeSession.getUserId() == session.getUserId() || activeSession.getScooterId() == session.getScooterId());
    }

    public void closeSessionByUserId(long userId) {
        ScooterActiveSessionData sessionToDelete = this.scooterActiveSessionDataStorage.stream().filter(session -> session.getUserId() == userId).findFirst().orElse(null);
        scooterActiveSessionDataStorage.remove(sessionToDelete);
    }

    public void closeSessionByScooterId(long scooterId) {
        ScooterActiveSessionData sessionToDelete = this.scooterActiveSessionDataStorage.stream().filter(session -> session.getUserId() == scooterId).findFirst().orElse(null);
        scooterActiveSessionDataStorage.remove(sessionToDelete);

    }
}
