package bolt.system.api.bank;

import bolt.system.entities.user.BankAccountData;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankAPI {

    private String requestUrl = "http://banksite.com";
    private Map<BankAccountData, BigDecimal> bankAccounts;


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
        } else {
            return false;
        }
        return true;
    }


    public boolean checkIfAccountExists(BankAccountData bankAccount) {
        return bankAccounts.containsKey(bankAccount);
    }
}
