package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class SPOJ_7676_CPCRC1C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long a, b;
        while(true) {
            a = in.nextLong();
            b = in.nextLong();
            if(a < 0) return;

            long x1 = cal(a - 1);
            long x2 = cal(b);
            out.println(x2 - x1);
        }
    }

    long cal(long x) {
        int len = length(x);
        long tmp = x;
        int []a = new int[len + 1];
        for(int i = len; i > 0; --i) {
            a[i] = (int)(tmp % 10);
            tmp /= 10;
        }

        int []dp = new int[len + 1];
        for(int i = 1; i <= len; ++i)
            dp[i] += dp[i - 1] + a[i];

        int []sum = new int[10];
        for(int i = 1; i <= 9; ++i)
            sum[i] = i + sum[i - 1];

        int multiplier = 1;
        long ans = 0;
        for(int i = len; i > 0; --i) {
            if(x < 0) break;
            long rs = dp[i - 1] * ((int)(x % 10) + 1) + (x / 10) * 45 + sum[(int)(x % 10)];
            rs *= multiplier;
            ans += rs;
            x = x / 10 - 1;
            multiplier *= 10;
        }

        return ans;
    }

    int length(long x) {
        int len = 0;
        while(x > 0) {
            len++;
            x /= 10;
        }
        return len;
    }
}
