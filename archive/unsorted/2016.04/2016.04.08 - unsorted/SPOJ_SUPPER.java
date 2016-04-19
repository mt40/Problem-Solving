package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.TreeSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_SUPPER {
    int inf = Integer.MAX_VALUE;
    int []length; // length of LIS ending at a[i]
    int []a;
    TreeSet<Integer> results;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        while(true) {
            int n;
            try{ n = in.i(); } catch(Exception e) { return; }
            a = in.arr(n);

            int []lis = new int[n + 1];
            Arrays.fill(lis, inf);
            length = new int[n];
            results = new TreeSet<>();

            int maxLen = 1;
            for(int i = 0; i < n; ++i) {
                int pos = find(lis, a[i]);
                maxLen = Math.max(pos, maxLen);
                lis[pos] = a[i];
                length[i] = pos;
            }

            int []reverse = new int[maxLen + 2];
            reverse[maxLen + 1] = inf;
            for(int i = n - 1; i >= 0; --i) {
                int len = length[i];
                if(a[i] < reverse[len + 1]) { // then a[i] is a part of a LIS
                    results.add(a[i]);
                    reverse[len] = Math.max(a[i], reverse[len]);
                }
            }

            out.println(results.size());
            for(int ri : results)
                out.print(ri + " ");
            out.println();
        }
    }

    int find(int []lis, int key) {
        int low = 1, hi = lis.length - 1, rs = hi;
        while(low <= hi) {
            int mid = low + (hi - low) / 2;
            if(lis[mid] >= key) {
                rs = mid;
                hi = mid - 1;
            }
            else low = mid + 1;
        }
        return rs;
    }
}