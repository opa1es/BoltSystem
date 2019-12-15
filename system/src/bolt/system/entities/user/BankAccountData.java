package bolt.system.entities.user;

import java.math.BigDecimal;
import java.util.Objects;

public class BankAccountData {

    /*@ public static invariant
      @ (\forall BankAccountData p1, p2;
      @     p1 != p2 ==> p1.name != p2.name)
      @*/

    private /*@ spec_public @*/ String name;
    private /*@ spec_public @*/ String accountNumber;

    //@ public invariant name != null;
    //@ public invariant accountNumber != null;

    /*@ public normal_behavior
      @ requires name.length > 0;
      @ requires accountNumber.length > 0;
      @ assignable this.name;
      @ assignable this.accountNumber;
      @ ensures this.name == name;
      @ ensures this.accountNumber == accountNumber;
      @*/
    public BankAccountData(/*@ non_null @*/ String name, /*@ non_null @*/ String accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal wallet() {
        return BigDecimal.valueOf(0);
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + accountNumber.hashCode();
    }

    @Override
    public String toString() {
        return "BankAccountData{" +
                "name='" + name + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
