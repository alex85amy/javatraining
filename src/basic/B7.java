package basic;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class B7 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();//當下日期時間
        calendar.set(2003, Calendar.NOVEMBER, 10, 20, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long milliseconds = calendar.getTimeInMillis();
        System.out.println("自Epoch經過的milliseconds : " + milliseconds);//從1970年1月1日0時0分0秒起至現在的總秒數

        Calendar c1 = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(format.format(c1.getTime()));

        Calendar c2 = Calendar.getInstance();
        c2.add(Calendar.MONTH, -1);
        System.out.println(format.format(c2.getTime()));
    }
}
