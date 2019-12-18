package bolt.system.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class TimeCalculator {

    //TODO: fix it. values overflow by some reason
	//@ requires datatime1 != null;
	//@ requires datatime2 != null;
	//@ requires datatime1.getTime() >= 0L;
	//@ requires datatime2.getTime() >= 0L;
	//@ requires datatime1.getTime() <= Long.MAX_VALUE;
	//@ requires datatime2.getTime() <= Long.MAX_VALUE;
	//@ signals_only \nothing;

	public /*@ code_safe_math @*/ static double getDifferenceInMinutes(Date datatime1, Date datatime2) { 
        return BigDecimal.valueOf((double)  (datatime1.getTime() - datatime2.getTime())/ (1000 * 60)).setScale(3, RoundingMode.HALF_UP).doubleValue();
    }
}
