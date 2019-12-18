package bolt.system.api.bank;

import bolt.system.entities.user.BankAccountData;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @ invariants: bankAccounts
 */
public class BankAPI {

    private /*@ spec_public @*/ String requestUrl = "http://banksite.com";
    private /*@ spec_public @*/ Map<BankAccountData, BigDecimal> bankAccounts;

    //@ public invariant bankAccounts != null;


    public BankAPI() {
        bankAccounts = new HashMap<>();
    }

    //@ requires newBankAccount != null;
    //@ requires moneyAmount != null;
    //@ requires moneyAmount.compareTo(new BigDecimal(0)) > 0;
    public void addNewBankAccountData(BankAccountData newBankAccount, BigDecimal moneyAmount) {
        if (!bankAccounts.containsKey(newBankAccount)) {
            bankAccounts.put(newBankAccount, moneyAmount);
        }
    }

    //@ requires bankAccount != null;
    //@ requires money != null;
    public boolean makePayment(BankAccountData bankAccount, BigDecimal money) {
        if (bankAccounts.containsKey(bankAccount)) {
            BigDecimal oldMoneyValue = bankAccounts.get(bankAccount);
            bankAccounts.replace(bankAccount, oldMoneyValue.subtract(money));
//            System.out.println("payment was made!");
        } else {
            return false;
        }
        return true;
    }

    //@ requires bankAccount != null;
    //@ requires bankAccounts != null;
    public boolean checkIfAccountExists(BankAccountData bankAccount) {
        return bankAccounts.containsKey(bankAccount);
    }


    public Map<BankAccountData, BigDecimal> getBankAccounts() {
        return bankAccounts;
    }
}
