package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_WEIRDFN {
    int inf = Integer.MAX_VALUE;
    int mod = 1000 * 1000 * 1000 + 7;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int a = in.i(), b = in.i(), c = in.i(), n = in.i();

        PriorityQueue<Long> left = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Long> right = new PriorityQueue<>();

        left.add(1L);
        long sum = 1;
        for(int i = 2; i <= n; ++i) {
            long median = left.peek();
            long f = calc(a, b, c, median, i);
            sum += f;

            left.add(f);
            if(right.size() > 0)
                left.add(right.poll());
            while(left.size() > right.size() + 1) // keep balance
                right.add(left.poll());
        }

        out.println(sum);
    }

    long calc(int a, int b, int c, long median, int idx) {
        return (a * median + b * idx + c) % mod;
    }
}