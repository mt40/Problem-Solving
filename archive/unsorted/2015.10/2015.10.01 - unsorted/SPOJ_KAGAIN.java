package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class SPOJ_KAGAIN {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        int []left = new int[n], right = new int[n];
        for(int i = 0; i < n; ++i) {
            left[i] = i;
            while(left[i] > 0 && a[left[i] - 1] >= a[i])
                left[i] = left[left[i] - 1];
        }

        for(int i = n - 1; i >= 0; --i) {
            right[i] = i;
            while(right[i] < n - 1 && a[right[i] + 1] >= a[i])
                right[i] = right[right[i] + 1];
        }

        int ans = 0, L = 0, R = 0;
        for(int i = 0; i < n; ++i) {
            int tmp = a[i] * (right[i] - left[i] + 1);
            if(ans < tmp || (ans == tmp && a[left[i]] < a[L] )) {
                ans = a[i] * (right[i] - left[i] + 1);
                L = left[i];
                R = right[i];
            }
        }

        out.printf("%d %d %d\n", ans, L + 1, R + 1);
    }
}
