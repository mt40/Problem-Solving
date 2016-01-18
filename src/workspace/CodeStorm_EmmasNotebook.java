package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class CodeStorm_EmmasNotebook {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int odd = n / 2;
        int even = n - odd;
        long ans = sum(even) + sum(odd + 1) - 1;
        out.println(ans);
    }

    long sum(int x) {
        return x * 1l * (x + 1) / 2;
    }
}
