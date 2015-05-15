package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_244A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int []a = new int[k];
        for(int i = 0; i < k; ++i)
            a[i] = in.nextInt();

        int []num = new int[n * k + 1];

        // mark used number
        for(int i = 0; i < k; ++i)
            num[a[i]] = 1;

        for(int i = 0; i < k; ++i) {
            out.print(a[i]);
            for(int j = 1, cnt = 1; j <= n * k && cnt < n; ++j) {
                if(num[j] == 0) {
                    out.print(" " + j);
                    num[j] = 1;
                    cnt++;
                }
            }
            out.println();
        }
    }
}
