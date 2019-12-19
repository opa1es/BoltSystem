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
 * @invariants: scooterAccessController, usersDAO, scootersRepresenter
 */
public class UserRequestController {


    private /*@ spec_public @*/ ScooterAccessController scooterAccessController;
    private /*@ spec_public @*/ UsersDAO usersDAO;
    private /*@ spec_public @*/ ScootersRepresenter scootersRepresenter;

    //@ public invariant scooterAccessController != null;
    //@ public invariant usersDAO != null;
    //@ public invariant scootersRepresenter != null;


    /*@ public normal_behavior
    @ requires scooterAccessController != null;
    @ requires usersDAO != null;
    @ requires scootersRepresenter != null;
    @ ensures this.scooterAccessController == scooterAccessController;
    @ ensures this.usersDAO == usersDAO;
    @ ensures this.scootersRepresenter == scootersRepresenter;
    @*/
    public UserRequestController(ScooterAccessController scooterAccessController, UsersDAO usersDAO, ScootersRepresenter scootersRepresenter) {
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
