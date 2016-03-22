package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_ADFRUITS {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        while(true) {
            char []a, b;
            try {
                a = in.c(true);
                b = in.c(true);
            }
            catch(Exception e) {
                return;
            }
            int n = a.length-1, m = b.length-1;

            Entry [][]lcs = new Entry[n+1][m+1];
            for(int i = 0; i <= n; ++i)
                for(int j = 0; j <= m; ++j)
                    lcs[i][j] = new Entry();
            int maxLen = 0;
            Entry maxPos = null;
            for(int i = 1; i <= n; ++i) {
                for(int j = 1; j <= m; ++j) {
                    if(a[i] == b[j]) {
                        Entry prev = lcs[i-1][j-1];
                        lcs[i][j].update(i, j, prev.len + 1, prev);
                    }
                    else {
                        Entry first = lcs[i - 1][j];
                        Entry second = lcs[i][j - 1];
                        Entry max = maxEntry(first, second);
                        lcs[i][j].update(i, j, max.len, max);
                    }
                    if(lcs[i][j].len > maxLen) {
                        maxLen = lcs[i][j].len;
                        maxPos = lcs[i][j];
                    }
                }
            }

            Stack<Entry> stack = new Stack<>();
            for(Entry cur = maxPos; cur != null; cur = cur.prev)
                if(a[cur.a] == b[cur.b])
                    stack.add(cur);

            StringBuilder sb = new StringBuilder();
            int ita = 1, itb = 1;
            while(!stack.isEmpty()) {
                Entry e = stack.pop();
                if(e.a == 0) continue;
                while(ita < e.a)
                    sb.append(a[ita++]);
                while(itb < e.b)
                    sb.append(b[itb++]);
                sb.append(a[e.a]);
                ita++;
                itb++;
            }
            while(ita <= n)
                sb.append(a[ita++]);
            while(itb <= m)
                sb.append(b[itb++]);

            out.println(sb);
        }
    }

    Entry maxEntry(Entry a, Entry b) {
        return (a.len >= b.len) ? a : b;
    }

    class Entry {
        int a, b, len;
        Entry prev;

        void update(int a, int b, int len, Entry prev) {
            this.a = a;
            this.b = b;
            this.len = len;
            this.prev = prev;
        }
    }
}