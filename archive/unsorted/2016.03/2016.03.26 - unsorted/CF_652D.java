package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.*;

import helperClasses.FastScanner;

public class CF_652D {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();

        List<End> ends = new ArrayList<>(n);
        for(int i = 0; i < n; ++i) {
            int x = in.i(), y = in.i();
            //ends.add(new End(x, y, i, false));
            ends.add(new End(y, x, i, true));
        }

        Set<Integer> ordered = new TreeSet<>();
        Map<Integer, Integer> compress = new HashMap<>();
        for(End e : ends) {
            ordered.add(e.pos);
            ordered.add(e.other);
        }
        int idx = 1;
        for(int i : ordered)
            compress.put(i, idx++);
        for(End e : ends) {
            e.pos = compress.get(e.pos);
            e.other = compress.get(e.other);
        }

        int []results = new int[n];

        Collections.sort(ends);
        BIT past = new BIT(ordered.size());
        for (End e : ends) {
            results[e.idx] = past.sumToEnd(e.other);
            past.set(e.other);
        }

        for(int ri : results) {
            out.println(ri);
        }
    }

    class BIT {
        int []arr;
        int size;
        BIT(int n) {
            arr = new int[n + 1];
            this.size = n;
        }

        void set(int idx) {
            while(idx <= size) {
                arr[idx]++;
                idx += idx & (-idx);
            }
        }

        int sumToEnd(int idx) {
            return rangeSum(idx, size);
        }

        int rangeSum(int left, int right) {
            return sum(right) - sum(left - 1);
        }

        int sum(int idx) {
            int sum = 0;
            while(idx > 0) {
                sum += arr[idx];
                idx -= idx & (-idx);
            }
            return sum;
        }
    }

    class End implements Comparable<End> {
        int pos, other, idx;
        boolean isRight;

        public End(int pos, int other, int idx, boolean isRight) {
            this.pos = pos;
            this.other = other;
            this.idx = idx;
            this.isRight = isRight;
        }

        @Override
        public int compareTo(End o) {
            return Integer.compare(pos, o.pos);
        }
    }
}