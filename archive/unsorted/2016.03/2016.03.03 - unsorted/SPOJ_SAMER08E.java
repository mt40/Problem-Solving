package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.time.LocalDate;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_SAMER08E {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n;
        while((n = in.i()) > 0) {
            LocalDate []a = new LocalDate[n];
            int []consumption = new int[n];
            for(int i = 0; i < n; ++i) {
                int day = in.i(), mon = in.i(), year = in.i();
                a[i] = LocalDate.of(year, mon, day);
                consumption[i] = in.i();
            }

            int rsDay = 0, rsAmt = 0;
            for(int i = 0; i < n; ++i) {
                if(i < n - 1) {
                    if(a[i].plusDays(1).equals(a[i + 1])) {
                        rsDay++;
                        rsAmt += consumption[i+1] - consumption[i];
                    }
                }
            }

            out.printf("%d %d\n", rsDay, rsAmt);
        }
    }
}