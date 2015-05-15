package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_157B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        Arrays.sort(a);
        double ans = 0;
        boolean flag = true;
        for(int i = n - 1; i >= 0; --i) {
            if(flag)
                ans += area(a[i]);
            else
                ans -= area(a[i]);
            flag = !flag;
        }

        out.printf("%.10f", ans);
    }

    double area(int r) {
        return Math.PI * r * r;
    }
}
