package com.augmentum.oes.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String getDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = formatter.format(date);

        return formattedDate;
    }
}
