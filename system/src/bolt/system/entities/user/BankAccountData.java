package bolt.system.entities.user;

/**
 *  invariants: name, accountNumber
 */
public class BankAccountData {


    private String name;
    private String accountNumber;


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
}
