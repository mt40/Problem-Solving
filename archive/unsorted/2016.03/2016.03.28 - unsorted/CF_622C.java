package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.*;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_622C {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i();
        int []a = in.arr(n);
        Segment []pts = new Segment[m];
        for(int i = 0; i < m; ++i) {
            int l = in.i() - 1, r = in.i() - 1, x = in.i();
            pts[i] = new Segment(l, r, x, i, false);
        }

        int []results = new int[m];
        Arrays.sort(pts, (o1, o2) -> Integer.compare(o1.left, o2.left));
        Map<Integer, ArrayList<Segment>> map = new HashMap<>();
        for(int i = 0, pi = 0; i < n; ++i) {
            while(pi < m && pts[pi].left == i) {
                add(map, pts[pi].val, pts[pi]);
                pi++;
            }
            List<Integer> trash = new ArrayList<>();
            for(int key : map.keySet()) {
                if(key == a[i])
                    continue;
                List<Segment> list = map.get(key);
                if(list == null || list.size() == 0)
                    continue;
                for(Segment seg : list) {
                    if(seg.right >= i)
                        results[seg.idx] = i + 1;
                    else
                        results[seg.idx] = -1;
                }
                trash.add(key);
            }
            for(int ti : trash)
                map.remove(ti);
        }
        for(int key : map.keySet()) {
            List<Segment> list = map.get(key);
            if(list == null || list.size() == 0)
                continue;
            for(Segment seg : list) {
                results[seg.idx] = -1;
            }
        }

        for(int rs : results)
            out.println(rs);
    }

    void add(Map<Integer, ArrayList<Segment>> map, int key, Segment item) {
        if(!map.containsKey(key))
            map.put(key, new ArrayList<>());
        map.get(key).add(item);
    }

    class Segment {
        int left, right, val, idx;
        boolean isEnd;

        public Segment(int left, int right, int val, int idx, boolean isEnd) {
            this.left = left;
            this.right = right;
            this.val = val;
            this.idx = idx;
            this.isEnd = isEnd;
        }
    }
}