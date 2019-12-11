package bolt.system.entities.requests;

import bolt.system.controllers.requests.ScooterActiveSessionData;
import bolt.system.controllers.requests.SessionController;
import bolt.system.database.dao.ScootersDAO;
import bolt.system.entities.coordinates.Coordinates;
import bolt.system.entities.scooter.Scooter;
import bolt.system.entities.scooter.ScooterStatus;
import bolt.system.util.RidePriceCalculator;
import bolt.system.util.TimeCalculator;

import java.util.Date;

public class ScooterAccessController {

    private ScootersDAO scootersDAO;
    private long userId;
    //private long requestedScooterId;
    private SessionController sessionController;

    public ScooterAccessController(ScootersDAO scootersDAO, long userId, SessionController sessionController) {
        this.scootersDAO = scootersDAO;
        this.userId = userId;

        this.sessionController = sessionController;
    }


    public boolean tryToGetScooter(long requestedScooterId) {
        ScooterActiveSessionData session = new ScooterActiveSessionData(this.userId, requestedScooterId);
        if (!sessionController.checkIfSessionIsActive(session)) {
            sessionController.addNewSession(session);
            scootersDAO.getScooterById(requestedScooterId).setCurrentStatus(ScooterStatus.RENTED);
            return true;
        }
        return false;
    }

    public double closeScooterSessionAndGetPrice(long requestedScooterId) {
        ScooterActiveSessionData session = new ScooterActiveSessionData(this.userId, requestedScooterId);

        if (sessionController.checkIfSessionIsActive(session)) {
            double timeDifferenceInMinutes = TimeCalculator.getDifferenceInMinutes(session.getStarted(), new Date(System.currentTimeMillis()));

            sessionController.closeSessionByUserId(userId);
            Scooter scooterToCheckAndUpdate = scootersDAO.getScooterById(requestedScooterId);

            if (scooterToCheckAndUpdate.checkIfScooterHaveEnoughFuel()) {
                scootersDAO.getScooterById(requestedScooterId).setCurrentStatus(ScooterStatus.FREE);
            } else {
                scooterToCheckAndUpdate.setCurrentStatus(ScooterStatus.NO_FUEL);
            }
            return RidePriceCalculator.getMoneyForRide(timeDifferenceInMinutes);
        }
        throw new IllegalArgumentException("unknown session");
    }


}
