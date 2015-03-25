package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class SPOJ_FIBSUM {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        double g = 1.61803398875; //golden ratio
        double sqrt5 = 2.2360679775;
        int n = in.nextInt();
        long tmp = (long)((Math.pow(g, n+6) - Math.pow(-g, -n-6)) / sqrt5);
        long ans = tmp % 10;
        for(int i = n; i <= n+9; ++i) {
            long ith_fib = (long) ((Math.pow(g, i) - Math.pow(-g, -i)) / sqrt5);
            if(ith_fib == 0) ith_fib = 1;
            ans += ith_fib;
        }
        out.println(ans);
    }
}
