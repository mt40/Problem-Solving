package workspace;

import java.math.BigInteger;
import java.util.Scanner;
import java.io.PrintWriter;

public class SPOJ_FCTRL2 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        BigInteger ans = BigInteger.ONE;
        for(int i = 1; i <= n; ++i)
            ans = ans.multiply(BigInteger.valueOf(i));

        out.println(ans);
    }
}
