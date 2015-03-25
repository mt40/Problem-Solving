package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class ExponentBySquaring {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int e = in.nextInt();
        out.println(pow((long)n, (long)e));
    }

    public long pow(long base, long exp) {
        long rs = 1;
        while(exp > 0) {
            if((exp & 1) != 0)
                rs *= base;
            exp >>= 1;
            base *= base;
        }
        return rs;
    }
}
