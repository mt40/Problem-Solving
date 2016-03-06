package workspace;

import helperClasses.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import helperClasses.FastScanner;
import helperClasses.Util;

public class SPOJ_TOHU2 {
    int inf = Integer.MAX_VALUE;

    public void solve(int testNumber, InputReader input, PrintWriter out) {
        FastScanner in = new FastScanner(input);
        char []a = new char[100];
        for(int i = 1; i <= 99; ++i)
            a[in.i()] = in.s().charAt(0);

        List<Integer> list = new ArrayList<>();
        for (int i = 10; i <= 99; ++i)
            list.add(i - ((i % 10) + (i / 10)));

        boolean ok = true;
        for(int i : list) {
            //System.out.print(i + " ");
            if (a[i] != a[list.get(0)])
                ok = false;
        }
        //out.println();

        out.println(ok ? "YES" : "NO");
    }
}