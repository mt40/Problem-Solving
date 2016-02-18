package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_FACT0 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        long n;
        while((n = in.l()) > 0) {
            long sqrt = (long)Math.sqrt(n) + 1;
            for(int i = 2; i <= sqrt;) {
                int cnt = 0;
                while(n % i == 0) {
                    n /= i;
                    cnt++;
                }
                if(cnt > 0)
                    out.printf("%d^%d ", i, cnt);
                if((i & 1) == 0) i++;
                else i += 2;
            }
            if(n > 1)
                out.print(n + "^1");
            out.println();
        }
    }
}