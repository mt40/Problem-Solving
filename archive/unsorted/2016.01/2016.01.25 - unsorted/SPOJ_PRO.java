package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_PRO {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        TreeSet<Entry> tree = new TreeSet<>();

        long ans = 0;
        for(int i = 0, j = 0; i < n; ++i) {
            int k = in.i();
            while(k-- > 0) {
                tree.add(new Entry(in.i(), j));
                j++;
            }
            if(tree.size() >= 2)
                ans += tree.pollLast().a - tree.pollFirst().a;
        }
        out.println(Long.toUnsignedString(ans));
    }

    class Entry implements Comparable<Entry> {
        int a, b;

        public Entry(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Entry o) {
            int t = Integer.compare(a, o.a);
            return (t == 0) ? Integer.compare(b, o.b) : t;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return a == entry.a && b == entry.b;
        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;
            return result;
        }

        @Override
        public String toString() {
            return "{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }
}