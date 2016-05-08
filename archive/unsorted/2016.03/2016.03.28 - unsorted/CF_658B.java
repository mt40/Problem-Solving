package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.TreeMap;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_658B {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), k = in.i(), q = in.i();
        int []relation = in.arr(n);

        boolean []online = new boolean[n];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < q; ++i) {
            int type = in.i(), id = in.i() - 1;
            if(type == 1) {
                map.put(relation[id], id);
                online[id] = true;
            }
            else {
                if(online[id])
                    out.println("YES");
                else
                    out.println("NO");
            }
            while(map.size() > k) {
                int low = map.firstKey();
                int idx = map.get(low);
                map.remove(low);
                online[idx] = false;
            }
        }
    }
}