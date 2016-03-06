package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_DCEPCA03 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int t = in.i();
        sieve(20000); // important!
        while(t-- > 0) {
            int n = in.i();
            long ans = sumPhi[n] * sumPhi[n];
            out.println(Long.toUnsignedString(ans));
        }
    }

    long []phi;
    long []sumPhi;

    void sieve(int limit) {
        phi = new long[limit + 1];
        sumPhi = new long[limit + 1];

        phi[1] = 1;
        for(int i = 2; 2*i <= limit;) {
            if(phi[i] == 0) { // this is a prime
                phi[i] = i - 1;
                for (int j = 2 * i; j <= limit; j += i) {
                    if (phi[j] == 0) phi[j] = j;
                    phi[j] = phi[j] / i * (i - 1);
                }
            }
            if(i == 2) i++;
            else i += 2;
        }

        for(int i = 1; i <= limit; ++i)
            sumPhi[i] = sumPhi[i - 1] + phi[i];
    }
}