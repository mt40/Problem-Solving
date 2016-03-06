package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_ARRANGE {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        int n = in.i();
        int []a = in.arr(n);

        Arrays.sort(a);

        int one = 0;
        for(int ai : a)
            if(ai == 1) one++;

        int []b = new int[n - one];
        for(int i = one, j = 0; i < n; ++i)
            b[j++] = a[i];
        n = b.length;

        while(one-- > 0) out.print("1 "); // print all 1's first
        if(n == 2 && b[0] == 2 && b[1] == 3)
            out.print("2 3");
        else {
            for(int i = n - 1; i >= 0; --i)
                out.print(b[i] + " ");
        }
        out.println();
    }
}