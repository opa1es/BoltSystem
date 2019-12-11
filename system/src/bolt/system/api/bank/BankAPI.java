package bolt.system.api.bank;

import bolt.system.entities.user.BankAccountData;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankAPI {

    private String requestUrl = "http://banksite.com";
    private Boolean statusEXISTS = true;
    private Map<BankAccountData,Double> bankAccounts;


    public BankAPI() {
        bankAccounts =new HashMap<>();
    }

    public void addNewBankAccountData(BankAccountData newBankAccount, double moneyAmount) {
        if (!bankAccounts.containsValue(newBankAccount)) {
            bankAccounts.put(newBankAccount, moneyAmount);
        }
    }



    public Boolean isValitCard(String accountNumber) {
        return (requestUrl + accountNumber).equals("EXIST");
    }

    public Boolean makePayment(String accountNumber, BigDecimal money) {
        return false;
    }


    public boolean checkIfAccountExists(BankAccountData bankAccountData){
        return bankAccounts.containsKey(bankAccountData);
    }
}
