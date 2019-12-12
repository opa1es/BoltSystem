package bolt.system.entities.user;

import bolt.system.entities.coordinates.Coordinates;


/**
 * invariants: userId, userFirstName, userSecondName, phoneNumber, bankAccount
 */
public class User {


    private long userId;
    private String userFirstName;
    private String userSecondName;
    private int phoneNumber;
    private BankAccountData bankAccount;
    public Coordinates coordinates;


    public User(String userFirstName, String userSecondName, int phoneNumber, BankAccountData bankAccount) {
//        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userSecondName = userSecondName;
        this.phoneNumber = phoneNumber;
        this.bankAccount = bankAccount;
    }

    public User(String userFirstName, String userSecondName, int phoneNumber) {
//        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userSecondName = userSecondName;
        this.phoneNumber = phoneNumber;
//        this.bankAccount = bankAccount;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserSecondName() {
        return userSecondName;
    }

    public void setUserSecondName(String userSecondName) {
        this.userSecondName = userSecondName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BankAccountData getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccountData bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userFirstName='" + userFirstName + '\'' +
                ", userSecondName='" + userSecondName + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }


}
