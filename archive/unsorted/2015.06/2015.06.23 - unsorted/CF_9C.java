package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_9C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int digits = length(n);

        int ans = cal(digits, n, 1);

        out.println(ans);
    }

    int length(int x) {
        return (x > 0) ? 1 + length(x/10) : 0;
    }

    int cal(int len, int max, int cur) {
        if(len == 0 || cur > max)
            return 0;

        int count = 1;
        count += cal(len - 1, max, cur * 10);
        count += cal(len - 1, max, cur * 10 + 1);
        return count;
    }
}
