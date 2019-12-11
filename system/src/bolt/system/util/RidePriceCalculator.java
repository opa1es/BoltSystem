package bolt.system.util;

public class RidePriceCalculator {

    static final double EUROS_FOR_ONE_MINUTE = 0.07;

    public static double getMoneyForRide(double differenceInMinutes){
        return EUROS_FOR_ONE_MINUTE * differenceInMinutes;

    }

}
