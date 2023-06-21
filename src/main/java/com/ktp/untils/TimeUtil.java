package com.ktp.untils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

    public static String UUTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format(date);
        return time;
    }
}
