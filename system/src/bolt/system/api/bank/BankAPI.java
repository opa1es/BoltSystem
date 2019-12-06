package bolt.system.api.bank;

import java.math.BigDecimal;

public class BankAPI {

    private String requestUrl = "http://banksite.com";
    private Boolean statusEXISTS = true;

    public BankAPI() {
    }

    public Boolean isValitCard(String accountNumber) {
        return (requestUrl + accountNumber).equals("EXIST");
    }

    public Boolean makePayment(String accountNumber, BigDecimal monye) {
        return false;
    }


    //TODO: create function to check if selecte contro exists in bank;
}
