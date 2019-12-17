package bolt.system.controllers.requests;

import bolt.system.api.bank.BankAPI;
import bolt.system.controllers.requests.sessions.ScooterActiveSessionData;
import bolt.system.controllers.requests.sessions.SessionController;
import bolt.system.database.dao.ScootersDAO;
import bolt.system.database.dao.UsersDAO;
import bolt.system.entities.scooter.Scooter;
import bolt.system.entities.scooter.ScooterStatus;
import bolt.system.entities.user.BankAccountData;
import bolt.system.util.RidePriceCalculator;
import bolt.system.util.TimeCalculator;

import java.math.BigDecimal;
import java.util.Date;

public class ScooterAccessController {


    private static final BigDecimal MAX_MONEY_FOR_RIDE = BigDecimal.valueOf(20);
    private /*@ spec_public nullable @*/ ScootersDAO scootersDAO;
    private /*@ spec_public nullable @*/ UsersDAO usersDAO;
    private /*@ spec_public nullable @*/ SessionController sessionController;
    private /*@ spec_public nullable @*/ BankAPI bankAPI;

    /*@ requires scootersDAO != null;
      @ requires usersDAO != null;
      @ requires sessionController != null;
      @ requires bankAPI != null;
      @ ensures this.scootersDAO == scootersDAO;
      @ ensures this.usersDAO == usersDAO;
      @ ensures this.sessionController == sessionController;
      @ ensures this.bankAPI == bankAPI;
     */
    public ScooterAccessController(ScootersDAO scootersDAO, UsersDAO usersDAO, SessionController sessionController, BankAPI bankAPI) {
        this.scootersDAO = scootersDAO;
        this.usersDAO = usersDAO;
        this.sessionController = sessionController;
        this.bankAPI = bankAPI;
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

    public boolean closeScooterSessionAndMakePayment(long requestedScooterId) {
        ScooterActiveSessionData session = sessionController.getSessionByScooterId(requestedScooterId);
        BigDecimal moneyForRide;
        if (sessionController.checkIfSessionIsActive(session)) {
            System.out.println(session.getStarted() + "  || " + new Date(System.currentTimeMillis()));
            double timeDifferenceInMinutes = TimeCalculator.getDifferenceInMinutes(session.getStarted(), new Date(System.currentTimeMillis()));

            sessionController.closeSessionByScooterId(requestedScooterId);
            Scooter scooterToCheckAndUpdate = scootersDAO.getScooterById(requestedScooterId);

            if (scooterToCheckAndUpdate.checkIfScooterHaveEnoughCharge()) {
                scootersDAO.getScooterById(requestedScooterId).setCurrentStatus(ScooterStatus.FREE);
            } else {
                scooterToCheckAndUpdate.setCurrentStatus(ScooterStatus.NO_FUEL);
            }
            moneyForRide = RidePriceCalculator.getMoneyForRide(timeDifferenceInMinutes);

            //TODO: plz check here correctness. Im retarded

            if (moneyForRide.compareTo(MAX_MONEY_FOR_RIDE) > -1) {
                moneyForRide = MAX_MONEY_FOR_RIDE;
            }
            //TODO: make payment

            return tryMakePayment(session.getUserId(), moneyForRide);

        }
        return false;
    }

    public boolean tryMakePayment(long userId, BigDecimal moneyAmount) {

        BankAccountData userBankAccount = usersDAO.getUserById(userId).getBankAccount();
        if (!bankAPI.checkIfAccountExists(userBankAccount)) {

            return false;
        }
        //TODO: check correctness later, currently too lazy
        return bankAPI.makePayment(userBankAccount, moneyAmount);
    }

    public ScootersDAO getScootersDAO() {
        return scootersDAO;
    }

    public SessionController getSessionController() {
        return sessionController;
    }


}
