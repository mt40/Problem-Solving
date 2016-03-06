package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_MIDO {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        Time []a = new Time[3];
        for(int i = 0; i < a.length; ++i) a[i] = new Time(0,0);

        int []score = new int[3];
        int prev = 0; // who won?
        Time last = new Time(0,0);
        for(int i = 0; i < n; ++i) {
            int t = in.i();
            String s = in.s();
            String []parts = s.split(":");
            int min = Integer.valueOf(parts[0]);
            int sec = Integer.valueOf(parts[1]);
            score[t]++;

            int win = prev;

            Time now = new Time(min, sec);
            Time dif = now.minus(last);
            a[win].add(dif);

            last = now;
            prev = 0;
            if(score[1] > score[2]) prev = 1;
            else if(score[1] < score[2]) prev = 2;
        }
        Time end = new Time(48, 0);
        a[prev].add(end.minus(last));

        out.printf("%02d:%02d\n", a[1].m, a[1].s);
        out.printf("%02d:%02d\n", a[2].m, a[2].s);
    }

    class Time {
        int m, s;

        public Time(int m, int s) {
            this.m = m;
            this.s = s;
        }

        void add(Time t) {
            m += t.m;
            s += t.s;
            if(s > 59) {
                m++;
                s %= 60;
            }
        }

        Time minus(Time t) {
            int all = m*60 + s - t.m*60-t.s;
            int min = all/60;
            return new Time(min, all - 60*min);
        }

        @Override
        public String toString() {
            return String.format("%02d:%02d\n", m, s);
        }
    }
}