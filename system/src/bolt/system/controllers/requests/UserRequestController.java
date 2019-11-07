package bolt.system.controllers.requests;

import bolt.system.entities.user.User;

public class UserRequestController {

    private User user;

    public UserRequestController(User user) {
        this.user = user;
    }

    /**
     * Requires: User status = Offline
     * Ensures: -
     * Result: User status = Authorized
     * @param data
     * @return
     */
    public String signIn(String data) {
        return "Authorized";
    }

    /**
     * Requires: User status = Authorized
     * Ensures: -
     * Result: User status = Offline
     * @param data
     * @return
     */
    public String logOut(String data) {
        return "LogOut";
    }

    public String getUsername(String data) {
        return "Username";
    }

    public String getUserWallet(String data) {
        return "Wallet";
    }
}
