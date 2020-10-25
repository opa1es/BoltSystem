package bolt.system.entities.user;

import bolt.system.entities.coordinates.Coordinates;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testToString() {
        BankAccountData bankAccount1 = new BankAccountData("user1", "13372281313");
        BankAccountData bankAccount2 = new BankAccountData("user2", "000000000");


        User user1 = new User("user1", "user1", "56512341", bankAccount1);
        User user2 = new User("user2", "user2", "565151511", bankAccount2);

        user1.setBankAccount(bankAccount1);
        user2.setBankAccount(bankAccount2);


        String str1 = "User{userId=0, userFirstName='user1', userSecondName='user1', phoneNumber=56512341}";
        String str2 = "User{userId=0, userFirstName='user2', userSecondName='user2', phoneNumber=565151511}";

        if (!str1.equals(user1.toString())) {
            fail();
        }

        if (!str2.equals(user2.toString())) {
            fail();
        }
    }
}