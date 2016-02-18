package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class EulerPhi_UsingSieve {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        out.println(phi[n]);
    }

    int limit = 1000*1000;
    long []phi = new long[limit + 1];
    {
        sieve();
    }

    /**
     * Base on Euler's product formula
     * https://www.wikiwand.com/en/Euler's_totient_function#/Euler.27s_product_formula
     */
    void sieve() {
        phi[1] = 1;
        for(int i = 2; (i << 1) <= limit;) {
            if(phi[i] == 0) {
                phi[i] = i - 1;
                for(int j = 2*i; j <= limit; j += i) {
                    if(phi[j] == 0) phi[j] = j;
                    phi[j] = phi[j] / i * (i - 1);
                }
            }

            // update i
            if(i > 2) i += 2;
            else i++;
        }
    }
}