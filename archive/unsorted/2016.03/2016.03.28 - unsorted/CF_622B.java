package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_622B {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        String s = in.s();
        String []parts = s.split(":");
        int min = in.i();

//        Time time = new Time(Integer.valueOf(parts[0]), Integer.valueOf(parts[1]));
//        time.add(min);

        Calendar cld = new GregorianCalendar();
        cld.set(Calendar.YEAR, 2017);
        cld.set(Calendar.HOUR_OF_DAY, Integer.valueOf(parts[0])); // 24h format
        cld.set(Calendar.MINUTE, Integer.valueOf(parts[1]));
        cld.add(Calendar.MINUTE, min);

        out.printf("%02d:%02d\n", cld.get(Calendar.HOUR_OF_DAY), cld.get(Calendar.MINUTE));
    }

    class Time {
        int hour, minute;

        public Time(int hour, int minute) {
            this.hour = hour;
            this.minute = minute;
        }

        void add(int min) {
            int t = min / 60;
            min %= 60;
            if(minute + min >= 60)
                t++;
            hour = (hour + t) % 24;
            minute = (minute + min) % 60;
        }
    }
}