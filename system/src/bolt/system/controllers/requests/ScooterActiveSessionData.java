package bolt.system.controllers.requests;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class ScooterActiveSessionData {

    private long userId;
    private long scooterId;
    private ZonedDateTime started;


    public ScooterActiveSessionData(long userId, long scooterId) {
        this.userId = userId;
        this.scooterId = scooterId;
        this.started = ZonedDateTime.now();
    }

    public long getUserId() {
        return userId;
    }

    public long getScooterId() {
        return scooterId;
    }

    public ZonedDateTime getStarted() {
        return started;
    }
}
