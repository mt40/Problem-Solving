package workspace;

import java.math.BigInteger;
import java.util.Scanner;
import java.io.PrintWriter;

public class FibonacciModified {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        int n = in.nextInt();

        BigInteger[]fibo = new BigInteger[n + 1];
        fibo[1] = BigInteger.valueOf(a);
        fibo[2] = BigInteger.valueOf(b);

        for(int i = 3; i <= n; ++i) {
            fibo[i] = fibo[i - 1].multiply(fibo[i - 1]).add(fibo[i - 2]);
        }

        out.println(fibo[n]);
    }
}
