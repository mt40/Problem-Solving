package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class SPOJ_ANARC05H {
    int [][]dp;
    char []a;
    int n;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int cnt = 1;
        while(true) {
            a = in.next().toCharArray();
            if(a[0] == 'b') return;

            n = a.length;
            // dp[i,j] = dap an cho den i co tong truoc do la j
            dp = new int[n + 1][300];
            for(int i = 0; i < dp.length; ++i)
                Arrays.fill(dp[i], - 1);

            out.printf("%d. %d\n", cnt++, cal(0, 0));
        }
    }

    int cal(int i, int prevSum) {
        if(i == n)
            return 1;

        if(dp[i][prevSum] == -1) { // tức cái này chưa tính
            dp[i][prevSum] = 0;
            int c = 0, sum = 0;
            for(int j = i; j < n; ++j) {
                sum += a[j] - '0';
                if (sum >= prevSum)
                    c += cal(j + 1, sum);
            }
            dp[i][prevSum] = c;
        }
        return dp[i][prevSum];
    }
}
