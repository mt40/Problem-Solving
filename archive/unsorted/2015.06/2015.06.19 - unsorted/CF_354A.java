package workspace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_354A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int l = in.nextInt();
        int r = in.nextInt();
        int q1 = in.nextInt();
        int q2 = in.nextInt();

        int []a = new int[n];
        for(int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }

        int []sum_left = new int[n + 1];
        int []sum_right = new int[n + 1];
        for(int i = 0; i < n; ++i) {
            sum_left[i + 1] = a[i] + sum_left[i];
        }
        for(int i = n - 1; i >= 0; --i) {
            sum_right[n - i] = a[i] + sum_right[n - i - 1];
        }

        /**
         * Ý t??ng: ?? t?i ?u thì nên pick xen k? LRLRLRLR... ?? ko b? + thêm q1(ho?c q2)
         */
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= n; ++i) {
            int l_picks = i;
            int r_picks = n - i;

            int total = sum_left[l_picks] * l + sum_right[r_picks] * r;
            if(l_picks > r_picks) {
                total += (l_picks - r_picks - 1) * q1;
            }
            else if(r_picks > l_picks){
                total += (r_picks - l_picks - 1) * q2;
            }

            ans = Math.min(total, ans);
        }
        out.println(ans);
    }
}
