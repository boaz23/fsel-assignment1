package il.ac.bgu.cs.fsen211.hw1;

import java.util.Calendar;
import java.util.Date;

public class Utils {
//    public static final int MS_TO_HOUR = 1000 * 60 * 60;
    // just not to make it actually too long
    public static final int MS_TO_HOUR = 1000 * 5;

    public static Date createDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return calendar.getTime();
    }
}
