package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_586A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i) a[i] = in.nextInt();

        int i = 0, j = n - 1;
        while(i < n && a[i] == 0) i++;
        while(j >= 0 && a[j] == 0) j--;
        int ans = 0, zero = 0;
        while(i <= j) {
            if(a[i] == 1) {
                ans++;
                zero = 0;
                ++i;
            }
            else {
                while(a[i] == 0) {
                    i++;
                    zero++;
                }
                if(zero == 1)
                    ans++;
            }
        }
        out.println(ans);
    }
}
