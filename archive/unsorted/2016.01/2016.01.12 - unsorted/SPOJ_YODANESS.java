package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_YODANESS {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        String []s = new String [n];
        for(int i = 0; i < n; ++i) s[i] = in.s();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; ++i) {
            map.put(in.s(), i);
        }

        int []a = new int[n];
        for(int i = 0; i < n; ++i) a[i] = map.get(s[i]);

        ans = 0;
        a = mergeSort(a);
        /* we can also use the TreeSet but it looks like the
        tailSet() method is too slow
         */
//        TreeSet<Integer> set = new TreeSet<>();
//        for(int i = 0; i < n; ++i) {
//            int cnt = set.tailSet(a[i], false).size();
//            ans += cnt;
//            set.add(a[i]);
//        }

        out.println(ans);
    }

    int ans = 0;

    int[] mergeSort(int []a) {
        if(a.length <= 1) return a;
        int []l = mergeSort(Arrays.copyOfRange(a, 0, a.length / 2));
        int []r = mergeSort(Arrays.copyOfRange(a, a.length / 2, a.length));
        return merge(l, r);
    }

    int[] merge(int []l, int []r) {
        int n = l.length, m = r.length;
        int []mrg = new int[n + m];
        int i = 0, j = 0, k = 0;
        for(; i < n && j < m; ++k) {
            if(l[i] <= r[j])
                mrg[k] = l[i++];
            else {
                mrg[k] = r[j++];
                ans += n - i;
            }
        }
        while(i < n) mrg[k++] = l[i++];
        while(j < m) mrg[k++] = r[j++];

        return mrg;
    }
}