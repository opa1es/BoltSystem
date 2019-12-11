package bolt.system.api.map.representers;

import bolt.system.entities.coordinates.Coordinates;

public class ScootersRepresentationObj {

    private long id;
    private short chargeLevel;
    private Coordinates coordinates;

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
