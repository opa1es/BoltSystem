package bolt.system.controllers.requests;


import bolt.system.api.map.MapAPI;
import bolt.system.entities.scooter.Scooter;

/**
 *
 */
public class ScooterRequestController {

    private boolean scooterStatus = false;
    private MapAPI currentPosition;
    private Scooter scooter;

    public ScooterRequestController(Scooter scooter, MapAPI currentPosition) {
        this.scooter = scooter;
        this.currentPosition = currentPosition;
    }

    public void setScooterStatus(boolean status) {
        this.scooterStatus = status;
    }

    //public MapAPI getCurrentPosition() {
    //    return this.currentPosition.getCoordinates();
    //}

    public short getScooterCharge() {
        return this.scooter.getChargeLevel();
    }

    public boolean getScooterStatus() {
        return this.scooterStatus;
    }


}
