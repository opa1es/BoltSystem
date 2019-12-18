package bolt.system.controllers.requests.sessions;


import bolt.system.controllers.requests.sessions.ScooterActiveSessionData;

import java.util.ArrayList;
import java.util.List;

public class SessionController {

	
    private /*@ spec_public @*/ List<ScooterActiveSessionData> scooterActiveSessionDataStorage;
    private /*@ spec_public @*/ long sessionIdGenerator = 0L;

    
    //@ ensures this.scooterActiveSessionDataStorage.getClass() == ArrayList.class;
    public SessionController() {
        this.scooterActiveSessionDataStorage = new ArrayList<>();

    }

    public SessionController(List<ScooterActiveSessionData> scooterActiveSessionDataStorage) {
        this.scooterActiveSessionDataStorage = scooterActiveSessionDataStorage;
    }
    
    
    public void addNewSession(ScooterActiveSessionData session) {
        if (!checkIfSessionIsActive(session)) {
            session.setSessionId(sessionIdGenerator++);
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
        ScooterActiveSessionData sessionToDelete = this.scooterActiveSessionDataStorage.stream().filter(session -> session.getScooterId() == scooterId).findFirst().orElse(null);
        scooterActiveSessionDataStorage.remove(sessionToDelete);
    }

    public ScooterActiveSessionData getSessionByUserId(long userId) {
        return this.scooterActiveSessionDataStorage.stream().filter(session -> session.getUserId() == userId).findFirst().orElse(null);
    }

    public ScooterActiveSessionData getSessionByScooterId(long scooterId) {
        return this.scooterActiveSessionDataStorage.stream().filter(session -> session.getScooterId() == scooterId).findFirst().orElse(null);
    }

    public List<ScooterActiveSessionData> getScooterActiveSessionDataStorage() {
        return scooterActiveSessionDataStorage;
    }
}
