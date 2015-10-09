package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

import static java.lang.Math.sqrt;

public class DividingTheSpoil {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }
        int total = sum(a);

        /**
         * dp[i][j] = có th? ??t ???c t?ng j n?u ch? xét ??n item th? i hay ko?
         * http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
         *
         * Th?c ra ch? c?n m?ng 1 chi?u là ??
         */

        boolean []dp = new boolean[total + 1];
        dp[0] = true;
        for(int i = 0; i < n - 1; ++i) {
            for(int j = 0; j <= total / 2 + 1; ++j) {
                if(j >= a[i])
                    dp[j] = dp[j - a[i]] || dp[j];
            }
        }

        int min = Integer.MAX_VALUE;
        int x = 0, y = 0;
        for(int j = 0; j <= total; ++j) {
            if(dp[j]) {
                int diff = (int)Math.abs(total - 2 * j);
                if(diff < min) {
                    min = diff;
                    x = j;
                    y = total - x;
                }
            }
        }

        out.printf("%d %d\n", x, y);
    }

    int sum(int []a) {
        int rs = 0;
        for(int x : a)
            rs += x;
        return rs;
    }
}
