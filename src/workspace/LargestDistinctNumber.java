package workspace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class LargestDistinctNumber {
    /**
     * Find the largest number smaller than k and has distinct digits
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int k = in.nextInt();
        List<Integer> list = gen(k);
        Integer []distinct = new Integer[list.size()];
        list.toArray(distinct);

        out.println(largest(distinct, k));
    }

    /**
     * binary search for the largest value <= k
     */
    int largest(Integer []a, int k) {
        int n = a.length, low = 0, hi = n - 1;
        int ans = a[0];
        while(low <= hi) {
            int mid = low + (hi - low) / 2;
            if(a[mid] < k) {
                ans = a[mid];
                low = mid + 1;
            }
            else
                hi = mid - 1;
        }
        return ans;
    }

    /**
     * Generate a sorted list of distinct digits number < k
     */
    List<Integer> gen(int k) {
        int len = 0;
        int x = k;
        while (x > 0) {
            len++;
            x /= 10;
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 1; i <= len; ++i) {
            gen(ans, k, 0, i, new boolean[10]);
        }
        return ans;
    }

    void gen(List<Integer> ans, int k, int cur, int len, boolean[] count) {
        for (int i = 0; i <= 9; ++i) {
            if ((cur == 0 && i == 0) || count[i]) continue;
            if (cur * 10 + i >= k) return;
            count[i] = true;
            if (len == 1)
                ans.add(cur * 10 + i);
            gen(ans, k, cur * 10 + i, len - 1, count);
            count[i] = false;
        }
    }
}
