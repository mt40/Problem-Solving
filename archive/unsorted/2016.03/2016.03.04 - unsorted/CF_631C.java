package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_631C {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i();
        int []a = in.arr(n);
        Entry []sorts = new Entry[m];
        for(int i = 0; i < m; ++i) {
            int t = in.i(), r = in.i();
            sorts[i] = new Entry(r-1, (t == 1));
        }

        Deque<Entry> ranges = new LinkedList<>();
        for(Entry e : sorts) {
            while(!ranges.isEmpty() && ranges.peekLast().r <= e.r)
                ranges.pollLast();
            ranges.add(e);
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int ai : a)
            add(map, ai);

        int []rs = new int[n];
        Entry prev = ranges.pollFirst();
        int idx;
        for(idx = n - 1; idx > prev.r; --idx) {
            rs[idx] = a[idx];
            remove(map, rs[idx]);
        }
        for(Entry e : ranges) {
            int dif = prev.r - e.r;
            while(dif-- > 0) {
                if(prev.asc) rs[idx--] = remove(map, map.lastKey());
                else rs[idx--] = remove(map, map.firstKey());
            }
            prev = e;
        }
        if(prev.r >= 0) {
            while(!map.isEmpty())
                rs[idx--] = prev.asc
                        ? remove(map, map.lastKey())
                        : remove(map, map.firstKey());
        }

        for(int rsi : rs)
            out.print(rsi + " ");
        out.println();
    }

    void add(TreeMap<Integer, Integer> map, int key) {
        if(map.containsKey(key))
            map.put(key, map.get(key) + 1);
        else
            map.put(key, 1);
    }

    int remove(TreeMap<Integer, Integer> map, int key) {
        int after = map.get(key) - 1;
        if(after > 0)
            map.put(key, after);
        else
            map.remove(key);
        return key;
    }

    class Entry {
        int r;
        boolean asc;

        public Entry(int r, boolean asc) {
            this.r = r;
            this.asc = asc;
        }
    }
}