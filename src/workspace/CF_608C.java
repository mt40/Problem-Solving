package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_608C {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}int[] readArr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i(), m = 1000001;
        int []tmp = new int[n];
        int []a = new int[m], b = new int[m];
        for(int i = 0; i < n; ++i) {
            int x = in.i();
            a[x] = 1;
            b[x] = in.i();
        }

        /**
         * dp[i] = number of beacons remain if beacon at i exploded
         */
        int []dp = new int[m];
        int max = 0;
        for(int i = 0; i < m; ++i) {
            if(b[i] > 0) {
                dp[i] = (i - b[i] - 1 >= 0) ? dp[i - b[i] - 1] + 1 : 1;
            }
            else if(i > 0)
                dp[i] = dp[i - 1];
            max = Math.max(dp[i], max);
        }

        int ans = n - max;

        out.println(ans);
    }
}
