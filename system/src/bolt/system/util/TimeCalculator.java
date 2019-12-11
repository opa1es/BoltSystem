package bolt.system.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.ZonedDateTime;
import java.util.Date;

public class TimeCalculator {


    public static double getDifferenceInMinutes(Date datatime1, Date datatime2) {

        return BigDecimal.valueOf((double) Math.abs(datatime1.getTime() - datatime2.getTime()) / (1000 * 60)).setScale(3, RoundingMode.HALF_UP).doubleValue();
    }
}
