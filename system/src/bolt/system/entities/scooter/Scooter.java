package bolt.system.entities.scooter;

import bolt.system.entities.coordinates.Coordinates;

/**
 * @invariants: scooterId, chargeLevel, coordinates, currentStatus
 */

public class Scooter {

    private /*@ spec_public @*/ long scooterId;
    private /*@ spec_public @*/ short chargeLevel;
    private /*@ spec_public @*/ Coordinates coordinates;
    private /*@ spec_public @*/ ScooterStatus currentStatus;


    //@ public invariant coordinates != null;
    //@ public invariant currentStatus != null;

    /*@ public normal_behavior
    @ requires chargeLevel >= 0 && chargeLevel <= 100;
    @ requires coordinates != null ; 
    @ requires currentStatus != null;
    @ ensures this.chargeLevel == chargeLevel;
    @ ensures this.coordinates == coordinates;
    @ ensures this.currentStatus == currentStatus;
    @*/
    public Scooter(short chargeLevel, Coordinates coordinates, ScooterStatus currentStatus) {
        this.chargeLevel = chargeLevel;
        this.coordinates = coordinates;
        this.currentStatus = currentStatus;
    }

    /*@
    @ requires chargeLevel >= 0;
    @ ensures this.chargeLevel == chargeLevel;
    @ also
    @ requires chargeLevel <= 100;
    @*/
    public boolean checkIfScooterHaveEnoughCharge() {
        if (this.chargeLevel < 10) {
            return false;
        }
        return true;


    }

    //@ ensures \result == scooterId;
    public long getScooterId() {
        return scooterId;
    }

    /*@
    @ assignable this.scooterId;
    @ ensures this.scooterId == scooterId;
    @*/
    public void setScooterId(long scooterId) {
        this.scooterId = scooterId;
    }


    //@ ensures \result == chargeLevel;
    public short getChargeLevel() {
        return chargeLevel;
    }

    /*@
    @ assignable  this.chargeLevel;
    @ requires chargeLevel >= 0 && chargeLevel <= 100;
    @ ensures this.chargeLevel == chargeLevel;
    @*/
    public void setChargeLevel(short chargeLevel) {
        this.chargeLevel = chargeLevel;
    }

    /*@
    @ requires coordinates != null;
    @ ensures this.coordinates == coordinates;
    @ ensures \result == this.coordinates;
    @*/
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /*@
    @ assignable this.coordinates;
    @ requires coordinates != null;
    @ ensures this.coordinates == coordinates;
    @*/
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /*@
    @ ensures \result == this.currentStatus;
    @*/
    public ScooterStatus getCurrentStatus() {
        return currentStatus;
    }

    /*@
	@ assignable this.currentStatus;
    @ requires currentStatus != null;
    @ ensures this.currentStatus == currentStatus;
    @*/
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
