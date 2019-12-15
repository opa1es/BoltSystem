package bolt.system.api.bank;

import bolt.system.entities.user.BankAccountData;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankAPI {
    private /*@ spec_public @*/ String requestUrl = "http://banksite.com";
    private /*@ spec_public nullable @*/ Map<BankAccountData, BigDecimal> bankAccounts;

    /*@ assignable bankAccount;
     */
    public BankAPI() {
        bankAccounts = new HashMap<>();
    }

    public void addNewBankAccountData(BankAccountData newBankAccount, BigDecimal moneyAmount) {
        if (!bankAccounts.containsKey(newBankAccount)) {
            bankAccounts.put(newBankAccount, moneyAmount);
        }
    }

    public boolean makePayment(BankAccountData bankAccount, BigDecimal money) {
        if (bankAccounts.containsKey(bankAccount)) {
            BigDecimal oldMoneyValue = bankAccounts.get(bankAccount);
            bankAccounts.replace(bankAccount, oldMoneyValue.subtract(money));
            System.out.println("Payment was made!");
        } else {
            return false;
        }
        return true;
    }

    public boolean checkIfAccountExists(BankAccountData bankAccount) {
        return bankAccounts.containsKey(bankAccount);
    }

    public Map<BankAccountData, BigDecimal> getBankAccounts() {
        return bankAccounts;
    }
}
