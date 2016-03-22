package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_644B {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), b = in.i();
        Query []a = new Query[n];
        for(int i = 0, idx = 0; i < n; ++i) {
            int start = in.i(), len = in.i();
            a[idx++] = new Query(start, len, i);
        }

        Arrays.sort(a);

        long []rs = new long[n];
        long curTime = 0;
        Queue<Query> queue = new LinkedList<>();
        for(Query qi : a) {
            while(!queue.isEmpty()) {
                if(curTime > qi.time) break;
                Query todo = queue.poll();
                curTime = Math.max(curTime, todo.time);
                curTime += todo.len;

                rs[todo.idx] = curTime;
            }

            if(queue.size() < b)
                queue.add(qi);
            else
                rs[qi.idx] = -1;
        }
        while(!queue.isEmpty()) {
            Query todo = queue.poll();
            curTime = Math.max(curTime, todo.time);
            curTime += todo.len;
            rs[todo.idx] = curTime;
        }

        for(long i : rs) out.print(i + " ");
        out.println();
    }

    class Query implements Comparable<Query> {
        int time, len, idx;

        public Query(int time, int len, int idx) {
            this.time = time;
            this.len = len;
            this.idx = idx;
        }

        @Override
        public int compareTo(Query o) {
            return Integer.compare(time, o.time);
        }
    }
}