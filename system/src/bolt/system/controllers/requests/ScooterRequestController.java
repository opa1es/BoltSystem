package bolt.system.controllers.requests;

/**
 * @invariants: scooterAccessController
 */

public class ScooterRequestController {

    /*@ spec_public @*/ ScooterAccessController scooterAccessController;

    //@ requires scooterAccessController != null;
    public ScooterRequestController(ScooterAccessController scooterAccessController) {
        this.scooterAccessController = scooterAccessController;
    }

    public boolean abortRide(long scooterId) {
        return scooterAccessController.closeScooterSessionAndMakePayment(scooterId);
    }

}
