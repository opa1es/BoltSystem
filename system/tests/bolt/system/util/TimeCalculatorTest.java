package bolt.system.util;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TimeCalculatorTest {

    @org.junit.jupiter.api.Test
    void testUsualCases() {

        long diff_1 = 5000L;
        long diff_2 = 1000L;
        long diff_3 = 100000L;


        Date date1 = new Date(System.currentTimeMillis());
        Date date2 = new Date(System.currentTimeMillis() + diff_1);
        Date date3 = new Date(System.currentTimeMillis() + diff_2);
        Date date4 = new Date(System.currentTimeMillis() + diff_3);

        double true_1 = 0.083;
        double true_2 = 0.017;
        double true_3 = 1.667;


        double check_1 = TimeCalculator.getDifferenceInMinutes(date2, date1);
        double check_2 = TimeCalculator.getDifferenceInMinutes(date3, date1);
        double check_3 = TimeCalculator.getDifferenceInMinutes(date4, date1);
        double check_4 = TimeCalculator.getDifferenceInMinutes(date1, date4);


        if (true_1 != check_1) {
            fail("answer is not correct");
        }
        if (true_2 != check_2) {
            fail("answer is not correct");
        }
        if (true_3 != check_3) {
            fail("answer is not correct");
        }
        if (check_4 != check_3) {
            fail("answer is not correct");
        }


    }

    @org.junit.jupiter.api.Test
    void testNonNegativeValues() {

        long diff_1 = 5000L;


        Date date1 = new Date(System.currentTimeMillis());
        Date date2 = new Date(System.currentTimeMillis() + diff_1);

        double true_1 = 0.083;
        double true_2 = 0.017;
        double true_3 = 1.667;


        double check_1 = TimeCalculator.getDifferenceInMinutes(date2, date1);
        double check_2 = TimeCalculator.getDifferenceInMinutes(date1, date2);


        if (check_1 <= 0) {
            fail("answer is not correct");
        }

        if (check_2 <= 0) {
            fail("answer is not correct");
        }


    }


}