package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_535C {
    int[] readArr(int n,Scanner in){int []a=new int[n]; for(int i=0; i<n; ++i) a[i]=in.nextInt();return a;}
    class ShortScanner{Scanner in;ShortScanner(Scanner in){this.in=in;}int i(){return in.nextInt();}long l(){return in.nextLong();}double d(){return in.nextDouble();}String s(){return in.next();}}

    public void solve(int testNumber, Scanner input, PrintWriter out) {
        ShortScanner in = new ShortScanner(input);
        int a = in.i(), b = in.i(), n = in.i();
        int len = 1000001;
        long []s = new long[len], sum = new long[len];
        for(int i = 0; i < len; ++i) {
            s[i] = 1l*a + 1l*i*b;
            sum[i] = (i > 0) ? sum[i - 1] + s[i] : s[i];
        }
        while(n-- > 0) {
            int l = in.i()-1, t = in.i(), m = in.i();
            int low = l, hi = len-1, ans = -1;
            while(low <= hi) {
                int mid = low + (hi - low) / 2;
                long dif = (l == 0) ? sum[mid] : sum[mid] - sum[l - 1];
                if(dif - 1l*m*t <= 0 && s[mid] <= t) {
                    ans = mid;
                    low = mid + 1;
                }
                else
                    hi = mid - 1;
            }
            out.println(ans < 0 ? ans : ans + 1);
        }
    }
}
