package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_407B {
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}int[] readArr(int n){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}}

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int n = in.i();
        int []p = in.readArr(n);
        long m = 1000000007;

        long []dp = new long[n + 2];
        for(int i = 1; i <= n; ++i) {
            dp[i + 1] = (2L *dp[i])%m + 2 - dp[p[i-1]]%m + m;
            dp[i + 1] %= m;
        }

        out.println(dp[n + 1]);
    }
}
