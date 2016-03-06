package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_ABA12C {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), k = in.i();
        List<Bag> bags = new ArrayList<>();
        for(int i = 0; i < k; ++i) {
            int price = in.i();
            if(price >= 0)
                bags.add(new Bag(i + 1, price));
        }

        Entry []dp = new Entry[k + 1];
        for(int i = 0; i <= k; ++i) dp[i] = new Entry(0, -1);
        for(Bag b : bags) {
            for(int i = 0; i <= k; ++i) {
                int j = i - b.w;
                if(j == 0 || (j > 0 && dp[j].cost >= 0)) {
                    if(dp[j].cost < 0) dp[j].cost = 0;

                    boolean ok = dp[i].cost == -1 || dp[j].cost + b.p < dp[i].cost;
                    if(ok && dp[j].cnt + 1 <= n) {
                        if(dp[i].cost < 0) dp[i].cost = 0;

                        dp[i].cnt = dp[j].cnt + 1;
                        dp[i].cost = dp[j].cost + b.p;
                    }
                }
            }
        }

        out.println((dp[k].cost >= 0) ? dp[k].cost : -1);
    }

    class Bag {
        int w, p;

        public Bag(int w, int p) {
            this.w = w;
            this.p = p;
        }
    }

    class Entry {
        int cnt, cost;

        public Entry(int cnt, int cost) {
            this.cnt = cnt;
            this.cost = cost;
        }
    }
}