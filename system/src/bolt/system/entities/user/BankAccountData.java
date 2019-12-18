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

    public String getName() {
        return name;
    }
    //@ requires name.length() > 0 &&  name.length() <= 50;
    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    //@ requires accountNumber.length() <=16 && accountNumber.length() >= 14;
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    
//
//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((name == null) ? 0 : name.hashCode());
//        result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
//        return result;
//        //        //return 31 * name.hashCode() + accountNumber.hashCode();
//    }

    @Override
    public String toString() {
        return "BankAccountData{" +
                "name='" + name + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}