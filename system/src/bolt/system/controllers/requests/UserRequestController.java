package bolt.system.controllers.requests;

import bolt.system.entities.User;

public class UserRequestController {

    private User user;

    public UserRequestController(User user) {
        this.user = user;
    }

    public String signIn(String data) {
        return "Authorized";
    }

    public String logOut(String data) {
        return "Sign Out";
    }

    public String getUsername(String data) {
        return "Username";
    }

    public String getUserWallet(String data) {
        return "Wallet";
    }
}
