package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.PriorityQueue;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_AMR12G {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), m = in.i(), k = in.i();
        char [][]a = in.c(n, m);

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int alreadyOn = 0;
        for(int i = 0; i < n; ++i) {
            int cnt = 0;
            for(char c : a[i]) {
                if (c == '.')
                    cnt++;
                else
                    alreadyOn++;
            }
            int remain = m - cnt;
            heap.add(cnt - remain);
        }

        int dif = inf;
        while (!heap.isEmpty() && k > 0) {
            if(heap.peek() < 0)
                break;
            dif = heap.poll();
            alreadyOn += dif;
            k--;
        }

        if(k > 0) k %= 2;
        if(k > 0) {
            int last = -dif;
            if(!heap.isEmpty() && heap.peek() > last)
                last = heap.poll();
            alreadyOn += last;
        }

        out.println(alreadyOn);
    }
}