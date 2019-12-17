package bolt.system.entities.user;

import bolt.system.entities.coordinates.Coordinates;


/**
 * @invariants: userId, userFirstName, userSecondName, phoneNumber, bankAccount
 */

public class User {


    private /*@ spec_public @*/ long userId;
    private /*@ spec_public @*/ String userFirstName;
    private /*@ spec_public @*/ String userSecondName;
    private /*@ spec_public @*/ String phoneNumber;
    private /*@ spec_public @*/ BankAccountData bankAccount;
    private /*@ spec_public nullable @*/ Coordinates coordinates;

    //@ public invariant userId >= 0;
    //@ public invariant userFirstName != null;
    //@ public invariant userSecondName != null;
    //@ public invariant phoneNumber != null;
    //@ public invariant coordinates != null;

    /*@ public normal_behavior
      @ requires userFirstName.length() > 0;
      @ requires userSecondName.length() > 0;
      @ requires phoneNumber != null;
      @ requires bankAccount != null;
      @ ensures this.userFirstName == userFirstName;
      @ ensures this.userSecondName == userSecondName;
      @ ensures this.phoneNumber == phoneNumber;
      @ ensures this.bankAccount == bankAccount;
      @*/
    
    public User(String userFirstName, String userSecondName, String phoneNumber, BankAccountData bankAccount) {
        this.userFirstName = userFirstName;
        this.userSecondName = userSecondName;
        this.phoneNumber = phoneNumber;
        this.bankAccount = bankAccount;
    }

    /*@ public normal_behavior
      @ requires userFirstName.length() > 0;
      @ requires userSecondName.length() > 0;
      @ requires phoneNumber.length() > 0 ;
      @ ensures this.userFirstName == userFirstName;
      @ ensures this.userSecondName == userSecondName;
      @ ensures this.phoneNumber == phoneNumber;
      @*/
    
    public User(String userFirstName, String userSecondName, String phoneNumber) {
        this.userFirstName = userFirstName;
        this.userSecondName = userSecondName;
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
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