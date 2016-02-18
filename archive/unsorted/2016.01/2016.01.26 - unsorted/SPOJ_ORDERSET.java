package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.*;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_ORDERSET {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        List<Query> list = new ArrayList<Query>();
        TreeSet<Integer> set = new TreeSet<>();
        int Q = in.i();
        for(int i = 0; i < Q; ++i) {
            char t = in.s().charAt(0);
            int v = in.i();
            list.add(new Query(t, v));
            set.add(v);
        }

        Map<Integer, Integer> compress = new HashMap<>();
        int []origin = new int[set.size() + 1];
        int ci = 1;
        for(int i : set) {
            compress.put(i, ci);
            origin[ci] = i;
            ci++;
        }

        boolean []vst = new boolean[set.size() + 1];
        BIT tree = new BIT(Q);
        for(Query q : list) {
            if(q.t == 'I') {
                int v = compress.get(q.v);
                if(vst[v]) continue; // already added

                tree.add(v);
                vst[v] = true;
            }
            else if(q.t == 'D') {
                if (!compress.containsKey(q.v)) continue;

                int v = compress.get(q.v);
                if (!vst[v]) continue; // not exist

                tree.delete(compress.get(q.v));
                vst[v] = false;
            }
            else if(q.t == 'K') {
                if(q.v > tree.currentSize) {
                    out.println("invalid");
                    continue;
                }
                int v = tree.kth(q.v);
                out.println((v < 0) ? "invalid" : origin[v]);
            }
            else {
                long v = tree.sum(compress.get(q.v) - 1);
                out.println(v);
            }
        }
    }

    class Query {
        char t;
        int v;

        public Query(char t, int v) {
            this.t = t;
            this.v = v;
        }
    }

    class BIT {
        long []tree;
        int size, currentSize;

        public BIT(int size) {
            this.size = size;
            tree = new long[size + 1];
        }

        void add(int i) {
            while (i <= size) {
                tree[i]++;
                i += i & (-i);
            }
            currentSize++;
        }

        void delete(int i) {
            while(i <= size) {
                tree[i]--;
                i += i & (-i);
            }
            currentSize--;
        }

        long sum(int i) {
            long rs = 0;
            while(i > 0) {
                rs += tree[i];
                i -= i & (-i);
            }
            return rs;
        }

        int kth(int k) {
            int low = 1, hi = size, rs = hi;
            while(low <= hi) {
                int m = low + (hi - low) / 2;
                long s = sum(m);
                if(s == k) {
                    rs = m;
                    hi = m - 1;
                }
                else if(s < k) low = m + 1;
                else hi = m - 1;
            }
            return rs;
        }
    }
}