package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_659C {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i();
        int []a = in.arr(n);

        Arrays.sort(a);

        long []sum = new long[n + 1];
        for(int i = 1; i <= n; ++i)
            sum[i] = a[i - 1] + sum[i - 1];

        int bound = binSearch(a, sum, n, m);
        Set<Integer> set = new HashSet<>(n);
        for(int ai : a)
            set.add(ai);

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= bound; ++i) {
            if (!set.contains(i)) {
                sb.append(i).append(" ");
                cnt++;
            }
        }

        out.println(cnt);
        if(sb.length() > 0)
            out.println(sb);
    }

    int binSearch(int []a, long []sum, int n, int m) {
        int low = 0, hi = 1000*1000*1000, bound = low;
        while(low <= hi) {
            int mid = low + (hi - low) / 2;
            long total = 1L*mid * (mid + 1) / 2;
            int idx = Arrays.binarySearch(a, mid);
            long cost;
            if(idx >= 0) cost = sum[idx + 1];
            else {
                idx = ~idx;
                idx++;
                if(idx > n) cost = sum[n];
                else cost = sum[idx - 1];
            }
            long pay = total - cost;
            if(pay <= m) {
                bound = mid;
                low = mid + 1;
            }
            else hi = mid - 1;
        }
        return bound;
    }
}