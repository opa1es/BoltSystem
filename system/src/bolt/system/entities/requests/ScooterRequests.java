package bolt.system.entities.requests;

import bolt.system.entities.coordinates.Coordinates;
import bolt.system.entities.scooter.ScooterStatus;

public class ScooterRequests {

    private long scooterId;
    private short chargeLevel;
    private Coordinates coordinates;
    private ScooterStatus currentStatus;


    public ScooterRequests(long scooterId, short chargeLevel, Coordinates coordinates, ScooterStatus currentStatus) {
        this.scooterId = scooterId;
        this.chargeLevel = chargeLevel;
        this.coordinates = coordinates;
        this.currentStatus = currentStatus;
    }

    public long getScooterId() {
        return scooterId;
    }

    public void setScooterId(long scooterId) {
        this.scooterId = scooterId;
    }

    public short getChargeLevel() {
        return chargeLevel;
    }

    public void setChargeLevel(short chargeLevel) {
        this.chargeLevel = chargeLevel;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public ScooterStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(ScooterStatus currentStatus) {
        this.currentStatus = currentStatus;
    }
}
