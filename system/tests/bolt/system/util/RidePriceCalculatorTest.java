package bolt.system.util;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class RidePriceCalculatorTest {

    final double price_for_minute = 0.07;

    @Test
    void testGetMoneyForRide() {
        BigDecimal case_1 = RidePriceCalculator.getMoneyForRide(0);
        BigDecimal case_2 = RidePriceCalculator.getMoneyForRide(10);
        BigDecimal case_3 = RidePriceCalculator.getMoneyForRide(0.5);

        BigDecimal true_1 = BigDecimal.valueOf(price_for_minute * 0.00).setScale(2, RoundingMode.HALF_UP);
        BigDecimal true_2 = BigDecimal.valueOf(price_for_minute * 10.0).setScale(2, RoundingMode.HALF_UP);
        BigDecimal true_3 = BigDecimal.valueOf(price_for_minute * 0.5).setScale(2, RoundingMode.HALF_UP);

        if (!case_1.equals(true_1)) {
            fail("not correct");
        }
        if (!case_2.equals(true_2)) {
            fail("not correct");
        }
        if (!case_3.equals(true_3)) {
            fail("not correct");
        }

    }
}