package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_INCSEQ {
    int inf = Integer.MAX_VALUE;
    int mod = 5 * 1000 * 1000;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), k = in.i();
        int []a = in.arr(n);

        int mx = a[0];
        for(int ai : a) mx = Math.max(ai, mx);

        BIT []tree = new BIT[k + 1];
        for(int i = 1; i < tree.length; ++i) tree[i] = new BIT(mx);

        for (int i = 0; i < n; ++i) {
            tree[1].add(a[i]);
            for (int j = 2; j <= k; ++j) {
                int tmp = tree[j - 1].sum(a[i] - 1);
                tree[j].add(a[i], tmp);
            }
        }

        int ans = tree[k].all();

        out.println(ans % mod);
    }

    class BIT {
        int []arr;
        int n;

        public BIT(int n) {
            this.n = n;
            arr = new int[n + 2];
        }

        void add(int i) {
            add(i, 1);
        }

        void add(int i, int v) {
            i++;
            while(i <= n + 1) {
                arr[i] += v;
                if(arr[i] >= mod) arr[i] -= mod;
                i += i & (-i);
            }
        }

        int all() {
            return sum(arr.length - 2); // sum all
        }

        int sum(int i) {
            i++;
            int rs = 0;
            while(i > 0) {
                rs += arr[i];
                if(rs >= mod) rs -= mod;
                i -= i & (-i);
            }
            return rs;
        }
    }
}