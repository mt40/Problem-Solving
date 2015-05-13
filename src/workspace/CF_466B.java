package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class CF_466B {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        long n = in.nextInt();
        long A = in.nextInt();
        long B = in.nextInt();

        long a = Math.min(A, B);
        long b = Math.max(A, B);

        if(a * b >= 6 * n) {
            out.printf("%d\n%d %d\n", a * b, a, b);
        }
        else {
            long ans = Long.MAX_VALUE;
            long sqrt = (long)Math.ceil(Math.sqrt(6 * n));
            for (long i = a; i <= sqrt; ++i) {
                long j = (long)Math.floor(6 * n * 1.0 / i);
                if(i * j < 6 * n)
                    j = (long)Math.ceil(6 * n * 1.0 / i);
                if(i * j >= 6 * n && i * j < ans) {
                    ans = i * j;
                    a = i;
                    b = j;
                }
            }

            if(a < A)
                out.printf("%d\n%d %d\n", ans, b, a);
            else
                out.printf("%d\n%d %d\n", ans, a, b);
        }
    }
}
