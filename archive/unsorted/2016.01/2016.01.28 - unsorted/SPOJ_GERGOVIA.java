package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_GERGOVIA {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n;
        while((n = in.i()) > 0) {
            int[] a = in.arr(n);
            List<Deal> sell = new ArrayList<>(), buy = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                if (a[i] < 0) sell.add(new Deal(i, -a[i]));
                if (a[i] > 0) buy.add(new Deal(i, a[i]));
            }

            int i = 0, j = 0;
            long ans = 0;
            while (true) {
                Deal b = buy.get(i), s = sell.get(j);
                int d = Math.abs(b.id - s.id);
                if (b.val == s.val) {
                    ans += b.val * d;
                    i++;
                    j++;
                }
                else if (b.val < s.val) {
                    ans += b.val * d;
                    s.val -= b.val;
                    i++;
                }
                else {
                    ans += s.val * d;
                    b.val -= s.val;
                    j++;
                }
                if (i == buy.size() || j == sell.size()) break;
            }

            out.println(ans);
        }
    }

    class Deal {
        int id, val;

        public Deal(int id, int val) {
            this.id = id;
            this.val = val;
        }
    }
}