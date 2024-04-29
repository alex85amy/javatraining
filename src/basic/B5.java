package basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class B5 {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        String format = "yyyy-MM-dd hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        System.out.println("當下時間 : "+simpleDateFormat.format(date));

        String dateTimeStr = "2003-11-10 20:18:23";
        Date dateObj = simpleDateFormat.parse(dateTimeStr);
        System.out.println("時間物件 : "+dateObj);

    }
}
