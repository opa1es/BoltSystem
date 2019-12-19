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

    //@ public invariant userFirstName != null;
    //@ public invariant userSecondName != null;
    //@ public invariant phoneNumber != null;
    //@ public invariant bankAccount != null;


    /*@ public normal_behavior
      @ requires userFirstName.length() > 0 && userFirstName.length() <= 50;
      @ requires userSecondName.length() > 0 && userSecondName.length() <= 50;
      @ requires phoneNumber.length() > 6 && phoneNumber.length() <= 20 ; 
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

    //@ ensures this.userId == \result;
    public long getUserId() {
        return userId;
    }

    //@ assignable this.userId;
    //@ ensures this.userId == userId;
    public void setUserId(long userId) {
        this.userId = userId;
    }

    //@ ensures this.userFirstName == \result;
    public String getUserFirstName() {
        return userFirstName;
    }

    //@ assignable this.userFirstName;
    //@ requires userFirstName.length() > 0 && userFirstName.length() <= 50;
    //@ ensures this.userFirstName == userFirstName;
    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    //@ ensures this.userSecondName == \result;
    public String getUserSecondName() {
        return userSecondName;
    }

    //@ assignable this.userSecondName;
    //@ requires userSecondName.length() > 0 && userSecondName.length() <= 50;
    //@ ensures this.userSecondName == userSecondName;
    public void setUserSecondName(String userSecondName) {
        this.userSecondName = userSecondName;
    }

    //@ ensures this.phoneNumber == \result;
    public String getPhoneNumber() {
        return phoneNumber;
    }

    //@ assignable this.phoneNumber;
    //@ requires phoneNumber.length() > 6 && phoneNumber.length() <= 20 ; 
    //@ ensures this.phoneNumber == phoneNumber;
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //@ ensures this.bankAccount == \result;
    public /*@ pure @*/ BankAccountData getBankAccount() {
        return bankAccount;
    }

    //@ assignable this.bankAccount;
    //@ requires bankAccount != null; 
    //@ ensures this.bankAccount == bankAccount;
    public void setBankAccount(BankAccountData bankAccount) {
        this.bankAccount = bankAccount;
    }


    //@ ensures this.coordinates == \result;
    public /*@ nullable @*/ Coordinates getCoordinates() {
        return coordinates;
    }

    //@ assignable this.coordinates;
    //@ requires coordinates != null; 
    //@ ensures this.coordinates == coordinates;
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