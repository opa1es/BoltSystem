package bolt.system.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class TimeCalculator {

    //TODO: fix it. values overflow by some reason
	//@ requires datatime1.getTime() >= 0L && datatime1.getTime() < Long.MAX_VALUE;
	//@ requires datatime2.getTime() >= 0L && datatime2.getTime() < Long.MAX_VALUE;
	//@ requires (datatime1.getTime() - datatime2.getTime()) >= 0;
	//@ ensures \result >= 0;
 
	public static double getDifferenceInMinutes(Date datatime1, Date datatime2) { 
        return BigDecimal.valueOf((double)  Math.abs(datatime1.getTime() - datatime2.getTime())/ (1000 * 60)).setScale(3, RoundingMode.HALF_UP).doubleValue();
    }
}
