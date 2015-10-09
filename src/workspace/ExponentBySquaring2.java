package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class ExponentBySquaring2 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), e = in.nextInt();

        out.println(pow(n, e));
        out.println(powRec(n, e));
    }

    long pow(int base, int e) {
        long ans = 1;
        while(e > 0) {
            if((e & 1) > 0)
                ans *= base;
            base *= base;
            e >>= 1;
        }
        return ans;
    }

    // recursive version
    long powRec(int base, int e) {
        if(e == 0) return 1;
        if((e & 1) > 0)
            return base * powRec(base * base, e >> 1);
        return powRec(base * base, e >> 1);
    }
}
