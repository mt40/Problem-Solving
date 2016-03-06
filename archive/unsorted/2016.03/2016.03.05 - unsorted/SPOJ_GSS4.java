package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.*;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_GSS4 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n;
        while(true) {
            try{n = in.i();}catch(Exception e) {return;}

            long []a = in.arrl(n);
            TreeMap<Integer, Long> map = new TreeMap<>();
            for(int i = 0; i < n; ++i)
                map.put(i + 1, a[i]);

            BIT tree = new BIT(n, a);
            Stack<Entry> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            int m = in.i();
            while(m-- > 0) {
                int t = in.i(), l = in.i(), r = in.i();
                if(t == 0) {
                    while(!map.isEmpty()) { // find the next element that is not 1
                        Map.Entry<Integer, Long> mapEntry = map.ceilingEntry(l);
                        if(mapEntry == null || mapEntry.getKey() > r) break;

                        map.remove(mapEntry.getKey());
                        Entry e = new Entry(mapEntry.getKey(), mapEntry.getValue());
                        long old = e.val;
                        e.val = sqrt(old);
                        if (e.val > 1)
                            stack.add(e);
                        tree.set(e.idx, -(old - e.val));
                    }
                    while(!stack.isEmpty()) // add back to the map
                        map.put(stack.peek().idx, stack.pop().val);
                }
                else {
                    long sum = tree.sumRange(l, r);
                    sb.append(sum).append('\n');
                }
            }

            if(testNumber > 1) out.println();
            out.printf("Case #%d:\n", testNumber++);
            out.print(sb.toString());
        }
    }

    class Entry {
        int idx;
        long val;

        public Entry(int idx, long val) {
            this.idx = idx;
            this.val = val;
        }
    }

    long sqrt(long x) {
        long rs = (long)Math.sqrt(x);
        while(rs*rs < x) rs++;
        while(rs*rs > x) rs--;
        return rs;
    }

    class BIT {
        long []arr;
        int n;
        BIT(int n, long []src) {
            arr = new long[n + 1];
            this.n = n;
            for(int i = 0; i < src.length; ++i)
                set(i + 1, src[i]);
        }

        void set(int i, long val) {
            while(i <= n) {
                arr[i] += val;
                i += i & (-i);
            }
        }

        long sum(int i) {
            long rs = 0;
            while(i > 0) {
                rs += arr[i];
                i -= i & (-i);
            }
            return rs;
        }

        long sumRange(int l, int r) {
            return sum(r) - sum(l - 1);
        }
    }
}