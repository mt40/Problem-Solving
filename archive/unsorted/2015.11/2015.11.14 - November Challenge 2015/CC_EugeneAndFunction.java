package workspace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 * CodeChef - KFUNC
 */
public class CC_EugeneAndFunction {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long a1 = in.nextLong();
        long d = in.nextLong();
        long l = in.nextLong();
        long r = in.nextLong();
        long a_l = a1 + (l - 1) * d;
        int first = cal(a_l);
        List<Long> cumul = new ArrayList<>();
        long ans = first, len = 1;
        for (long i = 2; i <= r - l + 1; ++i) {
            int tmp = cal(a_l + (i - 1) * d);
            if (tmp == first) {
                long times = (r - l + 1) / len;
                ans *= times;
                long left = (r - l + 1) - times * len;
                ans += cumul.get((int)left);
                break;
            }
            ans += tmp;
            cumul.add(ans);
            len++;
        }
        out.println(ans);
    }

    int cal(long x) {
        int sd = sum(x);
        return sd < 10 ? sd : cal(sd);
    }

    // Sum digit
    int sum(long x) {
        int rs = 0;
        while (x > 0) {
            rs += x % 10;
            x /= 10;
        }
        return rs;
    }
}
