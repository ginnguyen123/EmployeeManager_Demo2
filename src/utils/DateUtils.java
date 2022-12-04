package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {
    private static final String DATE_FORMAT = "dd-MM-yyyy hh:mm:ss";
    private static final String INSTANT_FORMAT = "dd-MM-yyyy hh:mm:ss";
    private static final String BIRTHDAY_FORMAT = "dd-MM-yyyy";
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
    private static final DateTimeFormatter dateTimeFormatter =
            DateTimeFormatter.ofPattern(INSTANT_FORMAT).withZone(ZoneId.systemDefault());

    public static String dateToString(Date date){
        return simpleDateFormat.format(date);
    }
    public static String instantToString(Instant instant){
        String formatInstance = dateTimeFormatter.format(instant);
        return formatInstance;
    }
    public static Date stringToDate(String date){
        try{
            return simpleDateFormat.parse(date);
        }catch(ParseException parseException){
            throw new RuntimeException();
        }
    }
    public static Instant stringToInstant(String stringInstant){
        return Instant.from(dateTimeFormatter.parse(stringInstant));
    }
    public static Date stringBirthDayToDate(String birthday){
        try{
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(BIRTHDAY_FORMAT);
            return simpleDateFormat1.parse(birthday);
        }catch (ParseException parseException){
            throw new RuntimeException();
        }
    }
}
