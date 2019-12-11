package bolt.system.entities.scooter;

import bolt.system.entities.coordinates.Coordinates;

/**
 * invariants: scooterId, chargeLevel, coordinates, current status
 */
public class Scooter {

    private long scooterId;
    private short chargeLevel;
    private Coordinates coordinates;
    private ScooterStatus currentStatus;


    public Scooter(short chargeLevel, Coordinates coordinates, ScooterStatus currentStatus) {
//        this.scooterId = scooterId;
        this.chargeLevel = chargeLevel;
        this.coordinates = coordinates;
        this.currentStatus = currentStatus;
    }

    public boolean checkIfScooterHaveEnoughCharge() {
        if (this.chargeLevel < 10) {
          //  this.currentStatus = ScooterStatus.NO_FUEL;
            return false;
        }
        return true;

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


    @Override
    public String toString() {
        return "Scooter{" +
                "scooterId=" + scooterId +
                ", chargeLevel=" + chargeLevel +
                ", coordinates=" + coordinates +
                ", currentStatus=" + currentStatus +
                '}';
    }
}
