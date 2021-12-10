package com.desafiobackendjr.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    final private static String simpleDateFormatDefaultPattern = "dd/MM/yyyy";
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(simpleDateFormatDefaultPattern);

    private static Calendar calendar = Calendar.getInstance();

    public static Date getCurrentDate() {
        return calendar.getTime();
    }

    public static LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }

    public static String formatDate(Date date) {
        return simpleDateFormat.format(date);
    }
}
