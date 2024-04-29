package basic;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class B7 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();//當下日期時間
        calendar.set(2003, 11, 10, 20, 00, 00);
        long milliseconds = calendar.getTimeInMillis();
        System.out.println("自Epoch經過的milliseconds : " + milliseconds);//從1970年1月1日0時0分0秒起至現在的總秒數

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(format.format(calendar.getTime()));

        Calendar c2 = Calendar.getInstance();
        c2.add(Calendar.MONTH, -1);
        System.out.println(format.format(c2.getTime()));
    }
}
