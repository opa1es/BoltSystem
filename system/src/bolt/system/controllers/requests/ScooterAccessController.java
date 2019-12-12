package bolt.system.controllers.requests;

import bolt.system.controllers.requests.sessions.ScooterActiveSessionData;
import bolt.system.controllers.requests.sessions.SessionController;
import bolt.system.database.dao.ScootersDAO;
import bolt.system.entities.scooter.Scooter;
import bolt.system.entities.scooter.ScooterStatus;
import bolt.system.util.RidePriceCalculator;
import bolt.system.util.TimeCalculator;

import java.math.BigDecimal;
import java.util.Date;

public class ScooterAccessController {


    private ScootersDAO scootersDAO;
    private SessionController sessionController;
    private static BigDecimal MAX_MONEY_FOR_RIDE = BigDecimal.valueOf(20);


    public ScooterAccessController(ScootersDAO scootersDAO, SessionController sessionController) {
        this.scootersDAO = scootersDAO;
        this.sessionController = sessionController;
    }


    public boolean tryToGetScooter(long userId, long requestedScooterId) {
        ScooterActiveSessionData session = new ScooterActiveSessionData(userId, requestedScooterId);
        if (!sessionController.checkIfSessionIsActive(session) && scootersDAO.getScooterStatus(requestedScooterId) == ScooterStatus.FREE) {
            sessionController.addNewSession(session);
            scootersDAO.getScooterById(requestedScooterId).setCurrentStatus(ScooterStatus.RENTED);
            return true;
        }
        return false;
    }

    public BigDecimal closeScooterSessionAndGetPrice(long userId, long requestedScooterId) {
        ScooterActiveSessionData session = sessionController.getSessionByUserId(userId);

        if (sessionController.checkIfSessionIsActive(session)) {
            System.out.println(session.getStarted() + "  || " + new Date(System.currentTimeMillis()));
            double timeDifferenceInMinutes = TimeCalculator.getDifferenceInMinutes(session.getStarted(), new Date(System.currentTimeMillis()));

            sessionController.closeSessionByUserId(userId);
            Scooter scooterToCheckAndUpdate = scootersDAO.getScooterById(requestedScooterId);

            if (scooterToCheckAndUpdate.checkIfScooterHaveEnoughCharge()) {
                scootersDAO.getScooterById(requestedScooterId).setCurrentStatus(ScooterStatus.FREE);
            } else {
                scooterToCheckAndUpdate.setCurrentStatus(ScooterStatus.NO_FUEL);
            }
//            System.out.println("time diff: " + timeDifferenceInMinutes);
            BigDecimal moneyForRide = RidePriceCalculator.getMoneyForRide(timeDifferenceInMinutes);

            //TODO: plz check here correctness. Im retarded
            if (moneyForRide.compareTo(MAX_MONEY_FOR_RIDE) > -1) {
                return MAX_MONEY_FOR_RIDE;
            }
//            System.out.println("money:" + moneyForRide);
            return moneyForRide;
        }
        //FIXME: maybe not the best solution??
        return null;
    }

    public ScootersDAO getScootersDAO() {
        return scootersDAO;
    }

    public SessionController getSessionController() {
        return sessionController;
    }


}
