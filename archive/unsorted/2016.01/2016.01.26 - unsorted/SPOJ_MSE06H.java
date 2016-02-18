package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_MSE06H {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i(), k = in.i();
        BIT tree = new BIT(m);
        Edge []a = new Edge[k];
        for(int i = 0; i < k; ++i) {
            a[i] = new Edge(in.i(), in.i());
            tree.add(a[i].des);
        }
        Arrays.sort(a);

        long ans = 0;
        for(Edge e : a) {
            ans += tree.sum(e.des - 1);
            tree.remove(e.des);
        }

        out.printf("Test case %d: ", testNumber);
        out.println(Long.toUnsignedString(ans)); // for safety :)
    }

    class BIT {
        int []arr;
        int n;

        public BIT(int n) {
            this.n = n;
            arr = new int[n + 1];
        }

        void add(int i) {
            while(i <= n) {
                arr[i]++;
                i += i & (-i);
            }
        }

        void remove(int i) {
            while(i <= n) {
                arr[i]--;
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
    }

    class Edge implements Comparable<Edge> {
        int src, des;

        public Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }

        @Override
        public int compareTo(Edge o) {
            int t = Integer.compare(src, o.src);
            return (t == 0) ? Integer.compare(des, o.des) : t;
        }
    }
}