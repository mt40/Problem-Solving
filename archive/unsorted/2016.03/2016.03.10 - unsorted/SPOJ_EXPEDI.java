package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_EXPEDI {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        Stop []stops = new Stop[n + 1];
        stops[n] = new Stop(0, 0); //
        for(int i = 0; i < n; ++i)
            stops[i] = new Stop(in.i(), in.i());
        int l = in.i(), p = in.i(); // initial position and fuel

        Arrays.sort(stops, (o1,o2) -> Integer.compare(o1.dist, o2.dist));
        PriorityQueue<Stop> heap = new PriorityQueue<>((o1,o2)->Integer.compare(o2.fuel, o1.fuel));
        int ans = 0;
        for(int i = n; i >= 0; --i) {
            Stop st = stops[i];
            if(reachable(l, p, st))
                heap.add(st); // this stop is reachable, but we don't choose it yet, save it there
            else {
                int oldP = p, oldL = l, gain = 0;
                p = p - (l - st.dist);
                while(p < 0) {
                    if(heap.isEmpty()) {
                        out.println(-1);
                        return;
                    }
                    Stop toGo = heap.poll();
                    ans++;
                    p += toGo.fuel;
                    gain += toGo.fuel;
                    l = Math.min(toGo.dist, l);
                }
                heap.add(st); //  this is now reachable, save it for l
                p = oldP - (oldL - l) + gain;
            }
        }

        out.println(ans);
    }

    boolean reachable(int l, int p, Stop target) {
        int dif = l - target.dist;
        return p >= dif;
    }

    class Stop {
        int dist, fuel;

        public Stop(int dist, int fuel) {
            this.dist = dist;
            this.fuel = fuel;
        }
    }
}