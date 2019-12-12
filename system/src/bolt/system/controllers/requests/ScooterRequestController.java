package bolt.system.controllers.requests;

public class ScooterRequestController {

    ScooterAccessController scooterAccessController;


    public ScooterRequestController(ScooterAccessController scooterAccessController) {
        this.scooterAccessController = scooterAccessController;
    }

    public boolean abortRide(long scooterId) {
        return scooterAccessController.closeScooterSessionAndMakePayment(scooterId);
    }

}
