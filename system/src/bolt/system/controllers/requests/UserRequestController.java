package bolt.system.controllers.requests;


import bolt.system.api.bank.BankAPI;
import bolt.system.api.map.representers.ScootersRepresentationObj;
import bolt.system.api.map.representers.ScootersRepresenter;
import bolt.system.database.dao.UsersDAO;
import bolt.system.entities.user.BankAccountData;
import bolt.system.entities.user.User;

import java.math.BigDecimal;
import java.util.List;

/**
 * here user requests. Communication point with user <-> controller
 */
public class UserRequestController {


    private ScooterAccessController scooterAccessController;
    private UsersDAO usersDAO;
    private ScootersRepresenter scootersRepresenter;

    public UserRequestController(ScooterAccessController scooterAccessController, UsersDAO usersDAO, ScootersRepresenter scootersRepresenter, BankAPI bankAPI) {
        this.scooterAccessController = scooterAccessController;
        this.usersDAO = usersDAO;
        this.scootersRepresenter = scootersRepresenter;
    }


    public boolean tryRentScooter(long userId, long scooterId) {
        return scooterAccessController.tryToGetScooter(userId, scooterId);
    }

    public boolean tryStopScooterRenting(long scooterId) {
        return scooterAccessController.closeScooterSessionAndMakePayment(scooterId);

    }

    public List<ScootersRepresentationObj> getAvailableScooters(long userId) {
        User selectedUser = usersDAO.getUserById(userId);
        return scootersRepresenter.getAvailableScootersRepresentationData(selectedUser.getCoordinates());
    }


}
