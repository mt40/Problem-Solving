package workspace;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CF_540B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int p = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int[] a = new int[k];
        for (int i = 0; i < k; ++i) {
            a[i] = in.nextInt();
        }

        /**
         * ý t??ng: tìm s? i nh? nh?t mà l?n h?n y, ta ch?n s? này làm median
         * N?u i mu?n thành median thì ph?i có (n - 1) / 2 s? l?n h?n nó và
         * c?ng nhiêu ?ó s? nh? h?n nó. V?y ch?n s? l?n h?n nó chính là y
         * và s? nh? h?n là 1 là t?i ?u nh?t
         */

        Arrays.sort(a);
        int pos = -1, med = y;
        for (int i = 0; i < k; ++i) {
            if (a[i] >= y) {
                pos = i;
                break;
            }
        }

        boolean rs = true;
        int mid = n / 2; // n is always odd
        int[] ans = new int[n - k];
        int id = 0;
        if(pos == -1) {
            ans[id++] = med;
            pos = k;
            k++;
        }
        int larger = (n - 1) / 2 - (k - pos - 1);
        for(int i = 0; i < larger; ++i) {
            if(id == ans.length) { // not enough space
                rs = false;
                break;
            }
            ans[id++] = med;
        }
        for(int i = id; i < ans.length; ++i)
            ans[id++] = 1;

        // Check conditions
        int sum = 0;
        for(int i = 0; i < a.length; ++i)
            sum += a[i];
        for(int i = 0; i < ans.length; ++i) {
            sum += ans[i];
            if(ans[i] > p)
                rs = false; // no element can be > p
        }
        if(sum > x)
            rs = false; // sum exceed

        if(rs) {
            for(int i = 0; i < ans.length; ++i)
                out.print(ans[i] + " ");
            out.println();
        }
        else {
            out.println(-1);
        }
    }
}
