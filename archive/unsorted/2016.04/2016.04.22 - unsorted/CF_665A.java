package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_665A {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int fA = in.i(), tA = in.i();
        int fB = in.i(), tB = in.i();
        String []parts = in.s().split(":");
        Time me = new Time(Integer.valueOf(parts[0]), Integer.valueOf(parts[1]));

        int offset = new Time(5, 0).toMinutes();
        int start = me.toMinutes() - offset;
        int end = start + tA;
        int last = new Time(23, 59).toMinutes() - offset;

        int cnt = 0;
        for(int cur = 0; cur <= last; cur += fB) {
            int curEnd = cur + tB;
            if(curEnd <= start || cur >= end)
                continue;
            cnt++;
        }

        out.println(cnt);
    }

    class Time {
        int hour, minute;

        public Time(int hour, int minute) {
            this.hour = hour;
            this.minute = minute;
        }

        int toMinutes() {
            return hour * 60 + minute;
        }
    }
}