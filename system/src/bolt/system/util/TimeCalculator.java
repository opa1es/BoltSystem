package bolt.system.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class TimeCalculator {

    //TODO: fix it. values overflow by some reason
	//@ requires datatime1.getTime() >= 0L && datatime1.getTime() < Long.MAX_VALUE;
	//@ requires datatime2.getTime() >= 0L && datatime2.getTime() < Long.MAX_VALUE;
	//@ signals_only \nothing;

    // OPENJML BUG HERE: JUST DON'T TOUCH IT!
	public /*@ code_safe_math @*/ static double getDifferenceInMinutes(Date datatime1, Date datatime2) { 
        return BigDecimal.valueOf((double)  (datatime1.getTime() - datatime2.getTime())/ (1000 * 60)).setScale(3, RoundingMode.HALF_UP).doubleValue();
    }
}
