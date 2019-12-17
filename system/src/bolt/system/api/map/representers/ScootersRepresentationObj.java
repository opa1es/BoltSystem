package bolt.system.api.map.representers;

import bolt.system.entities.coordinates.Coordinates;

public class ScootersRepresentationObj {

	private /*@ spec_public @*/ long id;
    private /*@ spec_public @*/ short chargeLevel;
    private /*@ spec_public nullable @*/ Coordinates coordinates;

    /*@ requires 0 < id;
    @ requires coordinates != null;
    @ requires 0 <= chargeLevel;
    @ ensures this.id == id;
    @ ensures this.chargeLevel == chargeLevel;
    @ ensures this.coordinates == coordinates;
    @*/
    public ScootersRepresentationObj(long id, short chargeLevel, Coordinates coordinates) {
        this.id = id;
        this.chargeLevel = chargeLevel;
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "ScootersRepresentationData{" +
                "id=" + id +
                ", chargeLevel=" + chargeLevel +
                ", coordinates=" + coordinates +
                '}';
    }
}
