package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class MultiplicativeOrder {
    int n, m; // n mod m (m is prime)
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt();
        m = in.nextInt();

        out.println("Order is " + order(out));
    }

    public int order(PrintWriter out) {
        for(int i = 1; i < m - 1; ++i) {
            if((m - 1) % i == 0) {
                int rs = modPow(n, i, m);
                out.format("%d ^ %d mod %d = %d\n", n, i, m, rs);
                if(rs == 1)
                    return i;
            }
        }
        return m - 1;
    }

    // calculate n^k mod m without overflow
    public int modPow(int base, int k, int mod) {
        long rs = 1;
        while(k > 0) {
            if((k & 1) == 1)
                rs = (rs * base) % mod;
            k >>= 1;
            base = (int)(((long)base * base) % mod);
        }
        return (int)rs;
    }
}
