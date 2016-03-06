package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_RATING {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), max = 0;
        Entry []coders = new Entry[n];
        for(int i = 0; i < n; ++i) {
            coders[i] = new Entry(in.i(), in.i(), i);
            max = Util.max(coders[i].a, coders[i].h, max);
        }

        Arrays.sort(coders, (o1, o2) -> {
            int t = Integer.compare(o1.a, o2.a);
            return (t == 0) ? Integer.compare(o1.h, o2.h) : t;
        });

        HashMap<Entry, Integer> map = new HashMap<>(); // stores the duplicates
        BIT tree = new BIT(max);
        int []result = new int[n];
        tree.add(coders[0].h);
        add(map, coders[0]);
        for(int i = 1; i < n; ++i) {
            int smallers = tree.sum(coders[i].h) - get(map, coders[i]);
            result[coders[i].idx] = smallers;

            tree.add(coders[i].h);
            add(map, coders[i]);
        }

        for(int i = 0; i < n; ++i)
            out.println(result[i]);
    }

    int get(HashMap<Entry, Integer> map, Entry key) {
        if(map.containsKey(key))
            return map.get(key);
        return 0;
    }

    void add(HashMap<Entry, Integer> map, Entry key) {
        if(map.containsKey(key))
            map.put(key, map.get(key) + 1);
        else
            map.put(key, 1);
    }

    class BIT {
        int []arr;
        int n;

        public BIT(int n) {
            this.n = n;
            arr = new int[n + 1];
        }

        void add(int x) {
            while(x <= n) {
                arr[x]++;
                x += x & (-x);
            }
        }

        int sum(int i) {
            int rs = 0;
            while(i > 0) {
                rs += arr[i];
                i -= i & (-i);
            }
            return rs;
        }
    }

    class Entry {
        int a, h, idx;

        public Entry(int a, int h, int idx) {
            this.a = a;
            this.h = h;
            this.idx = idx;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Entry entry = (Entry) o;

            if (a != entry.a) return false;
            return h == entry.h;

        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + h;
            return result;
        }
    }
}