package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_SPCQ {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        long n = in.l();
        while(true) {
            if(n % sum(n) == 0) {
                out.println(n);
                return;
            }
            n++;
        }
    }

    int sum(long n) {
        int rs = 0;
        while(n > 0) {
            rs += n % 10;
            n /= 10;
        }
        return rs;
    }
}