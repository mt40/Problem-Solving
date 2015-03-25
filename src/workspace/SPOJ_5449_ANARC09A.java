package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class SPOJ_5449_ANARC09A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = "";
        int cnt = 1;
        while(true) {
            s = in.next();
            if(s.charAt(0) == '-') return;

            int n = s.length();
            char []a = s.toCharArray();
            int ans = 0;
            int []dp = new int[n + 1];
            for(int i = 1; i <= n; ++i) {
                dp[i] = dp[i - 1];
                if(dp[i] == 0 && a[i - 1] == '}') {
                    ans++;
                    a[i - 1] = '{';
                }
                if(a[i - 1] == '{') dp[i]++;
                if(a[i - 1] == '}') dp[i]--;
            }

            out.printf("%d. %d\n", cnt, ans + dp[n] / 2);
            cnt++;
        }
    }
}
