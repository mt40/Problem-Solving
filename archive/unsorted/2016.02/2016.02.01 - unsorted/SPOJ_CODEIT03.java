package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_CODEIT03 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int d = in.i(), m = in.i(), y = in.i();

        Calendar cal = new GregorianCalendar();
        cal.set(y, m - 1, d);
        int ans = cal.get(Calendar.DAY_OF_WEEK);
        String []map = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        out.println(map[ans - 1]);
    }
}