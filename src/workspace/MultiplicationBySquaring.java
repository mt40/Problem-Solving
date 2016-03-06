package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class MultiplicationBySquaring {
    /**
     * Sometimes, even the multiplication is overflow before
     * we modulo it to a prime
     * ex: (a * b) % m, if a*b is overflow then %m is useless
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long a = in.nextLong(), b = in.nextLong();
        long m = 1000*1000*1000+7;
        long product = modMul(a, b, m);
        out.println(product);
    }

    long modMul(long a, long b, long m) {
        long rs = 0, y = a % m;
        while(b > 0) {
            if((y & 1) > 0)
                rs = (rs + y) % m;
            y = (y << 1) % m;
            b >>= 1;
        }
        return rs;
    }
}
