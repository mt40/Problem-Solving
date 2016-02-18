package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.HashSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_RPLD {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), r = in.i();
        boolean ans = true;
        HashSet<Entry> set = new HashSet<>();
        for(int i = 0; i < r; ++i) {
            Entry e = new Entry(in.i(), in.s());
            if(set.contains(e))
                ans = false;
            set.add(e);
        }

        out.printf("Scenario #%d: ", testNumber);
        out.println(ans ? "possible" : "impossible");
    }

    class Entry {
        int id;
        String code;

        public Entry(int id, String code) {
            this.id = id;
            this.code = code;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Entry entry = (Entry) o;

            if (id != entry.id) return false;
            return code.equals(entry.code);

        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + code.hashCode();
            return result;
        }
    }
}