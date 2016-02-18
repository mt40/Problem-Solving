package workspace;

import helperClasses.InputReader;

import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Queue;

public class CF_441B {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt(), v = in.nextInt();
        PriorityQueue<Fruits> min = new PriorityQueue<>();
        for (int i = 0; i < n; ++i) {
            int expire = in.nextInt() + 1, amt = in.nextInt();
            min.add(new Fruits(expire, amt));
        }

        int day = min.peek().expire - 1;
        int havest = 0, ans = 0;
        while (min.size() > 0) {
            Fruits f = min.peek();
            while (havest < v && inDay(f, day)) {
                int cur = Math.min(v - havest, f.amount);
                f.amount -= cur;
                havest += cur;
                if (f.amount == 0) {
                    min.poll();
                    if(min.size() == 0) break;
                    f = min.peek();
                }
            }
            ans += havest;
            havest = 0;
            day++;
            while(min.size() > 0 && min.peek().expire < day) min.poll();
        }

        out.println(ans);
    }

    boolean inDay(Fruits f, int day) {
        return day == f.expire || day == f.expire - 1;
    }

    class Fruits implements Comparable<Fruits> {
        int expire, amount;

        public Fruits(int expire, int amount) {
            this.expire = expire;
            this.amount = amount;
        }

        @Override
        public int compareTo(Fruits o) {
            return Integer.compare(expire, o.expire);
        }
    }
}
