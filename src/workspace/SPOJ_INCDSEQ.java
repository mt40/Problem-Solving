package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.*;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_INCDSEQ {
    int inf = Integer.MAX_VALUE;
    int mod = 5 * 1000 * 1000;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), k = in.i();
        int []a = in.arr(n);

        compress(a);
        int max = Util.max(a);

        BIT []trees = new BIT[k + 1];
        for(int i = 1; i <= k; ++i)
            trees[i] = new BIT(max);

        int [][]dp  = new int[k + 1][max + 1];
        for(int ai : a)
            trees[k].increase(ai, 1);
        for(int len = k - 1; len >= 1; --len) {
            for(int ai : a) {
                dp[len][ai] = trees[len + 1].sumFrom(ai + 1);
                trees[len].increase(ai, dp[len][ai]);
            }
        }

        int ans = 0;
        for(int ai : a)
            ans = add(ans, dp[1][ai]);

        out.println(ans);
    }

    void compress(int []a) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int ai : a)
            set.add(ai);

        Map<Integer, Integer> map = new HashMap<>();
        for(int ai : set) {
            if(!map.containsKey(ai))
                map.put(ai, map.size() + 1);
        }

        for(int i = 0; i < a.length; ++i)
            a[i] = map.get(a[i]);
    }

    int add(int a, int b) {
        int rs = a + b;
        return (rs >= mod) ? rs - mod : rs;
    }

    class BIT {
        int []arr;
        int size;

        public BIT(int size) {
            this.size = size;
            arr = new int[size + 1];
        }

        void increase(int idx, int val) {
            while(idx <= size) {
                arr[idx] = add(arr[idx], val);
                idx += idx & (-idx);
            }
        }

        int sumFrom(int idx) {
            return sum(size) - sum(idx - 1);
        }

        // sum from 0 to @idx
        int sum(int idx) {
            int rs = 0;
            while(idx > 0) {
                rs = add(rs, arr[idx]);
                idx -= idx & (-idx);
            }
            return rs;
        }
    }
}