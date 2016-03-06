package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeSet;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_KNJIGE {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);
        Deque<Integer> s = new LinkedList<>();
        for(int i = n - 1; i >= 0; --i)
            s.add(a[i]);

        int ans = 0, cur = n;
        for(int i = n - 1; i >= 0; --i) {
            if(a[i] < cur)
                ans++;
            else
                cur--;
        }
        out.println(ans);
    }
}