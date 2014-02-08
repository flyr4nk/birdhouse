package com.hlx.birdhouse.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static Integer getDateValue(Date date, int field) {
        if (date == null) {
            return -1;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        switch (field) {
            case 1:
                return cal.get(Calendar.YEAR);
            case 2:
                return cal.get(Calendar.MONTH);
            case 3:
                return cal.get(Calendar.DAY_OF_MONTH);
            case 4:
                return cal.get(Calendar.HOUR_OF_DAY);
            case 5:
                return cal.get(Calendar.MINUTE);
            case 6:
                return cal.get(Calendar.SECOND);
            default:
                return -1;
        }
    }

    /**
     * 格式化日期
     * @param date
     * @param pattern
     * @return
     */
    public static String toLocaleString(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        try {
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            return format.format(date);
        } catch (Exception ex) {
             ex.printStackTrace();
        }
        return "";
    }
    
    /**
     * 返回年月日字符串 比如20121010
     * @return
     */
    public static String getDateStr(){
        Calendar cal=Calendar.getInstance();
        cal.setTime(new Date());
        return String.valueOf(cal.get(Calendar.YEAR))+String.valueOf(cal.get(Calendar.MONTH)+1)+String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
    }

}
