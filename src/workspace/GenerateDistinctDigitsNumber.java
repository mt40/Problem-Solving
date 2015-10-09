package workspace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class GenerateDistinctDigitsNumber {
    /**
     * Generate distinct digit number <= k
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int k = in.nextInt();
        List<Integer> ans = gen(k);

        out.printf("Is sorted? %b\n", isSorted(ans));
        out.println(ans.size());
    }

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
            if (cur * 10 + i > k) return;
            count[i] = true;
            if (len == 1)
                ans.add(cur * 10 + i);
            gen(ans, k, cur * 10 + i, len - 1, count);
            count[i] = false;
        }
    }

    boolean isSorted(List<Integer> list) {
        int prev = list.get(0);
        for(int x : list) {
            if(x < prev)
                return false;
            prev = x;
        }
        return true;
    }
}
