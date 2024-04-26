package basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class B5 {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        String format = "yyyy-MM-dd hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        System.out.println(simpleDateFormat.format(date));

        String dateTimeStr = "2024-04-26 13:30:00";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date dateObj = dateFormat.parse(dateTimeStr);
        System.out.println(dateObj);

    }
}
