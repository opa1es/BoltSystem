package bolt.system.controllers.requests.sessions;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

public class ScooterActiveSessionData {

    private long sessionId;
    private long userId;
    private long scooterId;
    private Date started;


    public ScooterActiveSessionData(long userId, long scooterId) {
        this.userId = userId;
        this.scooterId = scooterId;
        this.started = new Date(System.currentTimeMillis());
    }

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public long getUserId() {
        return userId;
    }

    public long getScooterId() {
        return scooterId;
    }

    public Date getStarted() {
        return started;
    }
}
