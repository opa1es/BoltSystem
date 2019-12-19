package bolt.system.entities.user;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @invariants: name, accountNumber
 */
public class BankAccountData {


    private  /*@ spec_public @*/ String name;
    private  /*@ spec_public @*/ String accountNumber;

    //@ public invariant name != null ;
    //@ public invariant accountNumber != null;

    /*@ public normal_behavior 
    @ requires name.length() > 0 &&  name.length() <= 100;
    @ requires accountNumber.length() <=16 && accountNumber.length() >= 14;
    @ requires name != null;
    @ requires accountNumber != null;
    @ ensures this.name == name;
    @ ensures this.accountNumber == accountNumber;
    @*/
    public BankAccountData(String name, String accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    //@ ensures this.name == \result;
    public String getName() {
        return name;
    }

    //@ assignable this.name;
    //@ requires name.length() > 0 &&  name.length() <= 50;
    //@ ensures this.name == name;
    public void setName(String name) {
        this.name = name;
    }

    //@ requires accountNumber.length() <=16 && accountNumber.length() >= 14;
    //@ ensures this.accountNumber == \result;
    public String getAccountNumber() {
        return accountNumber;
    }

    //@ assignable this.accountNumber;
    //@ requires accountNumber.length() <=16 && accountNumber.length() >= 14;
    //@ ensures this.accountNumber == accountNumber;
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }


    @Override
    public String toString() {
        return "BankAccountData{" +
                "name='" + name + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}