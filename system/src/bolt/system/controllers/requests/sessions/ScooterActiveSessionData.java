package bolt.system.controllers.requests.sessions;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;


/**
 * @invariants: userId, userFirstName, userSecondName, phoneNumber, bankAccount
 */
public class ScooterActiveSessionData {

    private /*@ spec_public @*/ long sessionId;
    private /*@ spec_public @*/ long userId;
    private /*@ spec_public @*/ long scooterId;
    private /*@ spec_public @*/ Date started;

    /*@ public normal_behavior
    @ requires userId >= 0;
    @ requires scooterId >= 0;
    @ ensures this.userId == userId;
    @ ensures this.started.getClass() == Date.class;
    @ ensures this.scooterId == scooterId;
    @*/
    public ScooterActiveSessionData(long userId, long scooterId) {
        this.userId = userId;
        this.scooterId = scooterId;
        this.started = new Date(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "ScooterActiveSessionData{" +
                "sessionId=" + sessionId +
                ", userId=" + userId +
                ", scooterId=" + scooterId +
                '}';
    }
    //@ ensures this.sessionId == \result;
    public long getSessionId() {
        return sessionId;
    }

    //@ ensures this.userId == \result;
    public long getUserId() {
        return userId;
    }
    //@ ensures this.scooterId == \result;
    public long getScooterId() {
        return scooterId;
    }
    //@ ensures this.started == \result;
    public Date getStarted() {
        return started;
    }
    //@ ensures this.sessionId == sessionId;
    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }
}
