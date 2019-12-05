package bolt.system.entities.requests;

import bolt.system.controllers.requests.ScooterActiveSessionData;
import bolt.system.controllers.requests.SessionController;
import bolt.system.database.dao.ScootersDAO;
import bolt.system.entities.coordinates.Coordinates;
import bolt.system.entities.scooter.Scooter;
import bolt.system.entities.scooter.ScooterStatus;

public class ScooterAccessController {


    public ScooterAccessController(ScootersDAO scootersDAO, long userId, long requestedScooterId, SessionController sessionController) {
        this.scootersDAO = scootersDAO;
        this.userId = userId;
        this.requestedScooterId = requestedScooterId;
        this.sessionController = sessionController;
    }

    private ScootersDAO scootersDAO;
    private long userId;
    private long requestedScooterId;
    private SessionController sessionController;



    public boolean tryToGetScooter(){
        ScooterActiveSessionData session = new ScooterActiveSessionData(this.userId,this.requestedScooterId);
        if(!sessionController.checkIfSessionIsActive(session)){
            sessionController.addNewSession(session);
            scootersDAO.getScooterById(requestedScooterId).setCurrentStatus(ScooterStatus.RENTED);
            return true;
        }
        return false;
    }

    public double closeScooterSessionAndGetSessionLengthIsMinutes(){
        ScooterActiveSessionData session = new ScooterActiveSessionData(this.userId,this.requestedScooterId);

        if(sessionController.checkIfSessionIsActive(session)){
            //FIXME: change this, to calculate real time
            double timeDifferenceInMinutes = 1;
            sessionController.closeSessionByUserId(userId);
            //FIXME: dynamically check scooter status and set it here
            scootersDAO.getScooterById(requestedScooterId).setCurrentStatus(ScooterStatus.FREE);
            return timeDifferenceInMinutes;
        }
        //TODO: change in future to not cause bugs
        return -1;
    }



}
