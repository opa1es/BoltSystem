package bolt.system.entities.user;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * invariants: name, accountNumber
 */
public class BankAccountData {


    private String name;
    private String accountNumber;

    //TODO: JML: Check if input data length is ok
    public BankAccountData(String name, String accountNumber) {
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
}
