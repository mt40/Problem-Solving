package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class CF_478B {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        long max = f((long)n - (m - 1));
        // đây là cách chia sao cho số phần tử mỗi nhóm là ít nhất
        // và đều phải > 1
        long min = (m - (n % m)) * f(n / m) + (n % m) * f(n/m + 1);

        out.println(min + " " + max);
    }

    long f(long x) {
        // actually it is combination xC2
        return x * (x - 1) / 2;
    }
}
