package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import helperClasses.FastScanner;
import helperClasses.Util;

public class CF_644A {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i(), a = in.i(), b = in.i();

        boolean ok = n <= a * b;
        if(ok) {
            Queue<Integer> odd = new LinkedList<>();
            Queue<Integer> even = new LinkedList<>();
            for(int i = 1; i <= n; ++i) {
                if((i & 1) == 0) even.add(i);
                else odd.add(i);
            }

            int [][]as = new int[a][b];
            boolean flag = true;
            for(int i = 0; i < a; ++i) {
                flag = !flag;
                boolean isEven = flag;
                for(int j = 0; j < b; ++j) {
                    if(isEven)
                        out.print(even.isEmpty() ? 0 : even.poll());
                    else
                        out.print(odd.isEmpty() ? 0 : odd.poll());

                    out.print(" ");
                    isEven = !isEven;
                }
                out.println();
            }
        }
        else
            out.println(-1);
    }
}