package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;

public class CF_592B {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        out.println(sqr((n - 3) + 1));
    }

    long sqr(int x) {
        return 1l * x * x;
    }
}
