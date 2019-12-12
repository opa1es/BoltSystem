package bolt.system.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RidePriceCalculator {

    static final double EUROS_FOR_ONE_MINUTE = 0.07;

    public static BigDecimal getMoneyForRide(double differenceInMinutes) {
        return new BigDecimal(EUROS_FOR_ONE_MINUTE * differenceInMinutes).setScale(2, RoundingMode.HALF_UP);

    }

}
